package soap.example.services;

import java.math.BigDecimal;  
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import ar.edu.isistan.springsoap.gen.CowAlertInput;
import ar.edu.isistan.springsoap.gen.CowAlertOutput;
import ar.edu.isistan.springsoap.gen.CowBcsInput;
import ar.edu.isistan.springsoap.gen.CowBcsOutput;
import ar.edu.isistan.springsoap.gen.CowInput;
import ar.edu.isistan.springsoap.gen.CowOutput;
import ar.edu.isistan.springsoap.gen.GetAllCowAlertsRequest;
import ar.edu.isistan.springsoap.gen.GetAllCowAlertsResponse;
import ar.edu.isistan.springsoap.gen.GetAllHerdAlertsRequest;
import ar.edu.isistan.springsoap.gen.GetAllHerdAlertsResponse;
import ar.edu.isistan.springsoap.gen.GetAllHerdsRequest;
import ar.edu.isistan.springsoap.gen.GetAllHerdsResponse;
import ar.edu.isistan.springsoap.gen.GetCowRequest;
import ar.edu.isistan.springsoap.gen.GetCowResponse;
import ar.edu.isistan.springsoap.gen.GetHerdRequest;
import ar.edu.isistan.springsoap.gen.GetHerdResponse;
import ar.edu.isistan.springsoap.gen.HerdAlertInput;
import ar.edu.isistan.springsoap.gen.HerdAlertOutput;
import ar.edu.isistan.springsoap.gen.HerdInput;
import ar.edu.isistan.springsoap.gen.HerdOutput;

import ar.edu.isistan.springsoap.gen.PostCowAlertRequest;

import ar.edu.isistan.springsoap.gen.PostCowBcsRequest;
import ar.edu.isistan.springsoap.gen.PostCowRequest;

import ar.edu.isistan.springsoap.gen.PostHerdAlertRequest;
import ar.edu.isistan.springsoap.gen.PostHerdRequest;
import ar.edu.isistan.springsoap.gen.Response;

import soap.example.model.CowAlertModel;
import soap.example.model.CowBcsModel;
import soap.example.model.CowModel;
import soap.example.model.HerdAlertModel;
import soap.example.model.HerdModel;
import soap.example.repositories.CowAlertRepository;
import soap.example.repositories.CowBcsRepository;

import soap.example.repositories.HerdAlertRepository;
import soap.example.repositories.HerdRepository;
import soap.example.utils.ModelMapper;

import java.math.BigInteger;
import java.time.Instant;
import java.time.ZonedDateTime;


@Endpoint
public class EndPoint {

	
	
	private static final String NAMESPACE_URI = "http://www.isistan.edu.ar/springsoap/gen";

	private HerdRepository herdRepository;
	private HerdAlertRepository herdAlertRepository;
	private CowAlertRepository cowAlertRepository;
	private CowBcsRepository cowBcsRepository;
	
	//it automatically creates a herd repository and passes it to me as a parameter here
	@Autowired 
	public EndPoint(HerdRepository herdRepository,HerdAlertRepository herdAlertRepository,CowAlertRepository cowAlertRepository, CowBcsRepository cowBcsRepository) {
		this.herdRepository = herdRepository;
		this.herdAlertRepository = herdAlertRepository;
		this.cowAlertRepository = cowAlertRepository;
		this.cowBcsRepository = cowBcsRepository;
	}
	
	
	/*------------------------------------------------------------------------------------*/
	/*-------------------------			   Cow	     	   -------------------------------*/
	/*------------------------------------------------------------------------------------*/
	
	/*@POST one cow*/
	@PayloadRoot(namespace =  NAMESPACE_URI, localPart = "postCowRequest")
	@ResponsePayload
	public Response addCow(@RequestPayload PostCowRequest request) {
		CowInput cow = request.getCow();	
		Response response = new Response();
		CowModel cow_io = new CowModel(cow.getElectronicId(),cow.getWeight().floatValue(),
											cow.getBornDate(), cow.getLastDueDate(),cow.getNumberOfDeliveries()); 
		
		
		
		boolean herdok = herdRepository.addCowToHerd(cow.getHerdId(), cow_io);
		if(herdok) {
			response.setCode(BigInteger.valueOf(200));
		}else
			response.setCode(BigInteger.valueOf(404));//the herd not exists
		
		response.setMsg("cow id = " + cow_io.getId());
		
		return response;
	}
	
	/*@GET one cow by id*/
	@PayloadRoot(namespace =  NAMESPACE_URI, localPart = "getCowRequest")
	@ResponsePayload
	public GetCowResponse getCow(@RequestPayload GetCowRequest request) {
		long id = request.getId();
		
		CowModel cow = herdRepository.findCowById(id);
		GetCowResponse response = new GetCowResponse();
		

		if (cow != null) {
			CowOutput cow_io = ModelMapper.mapper(cow);
			cow_io.setHerdId(herdRepository.getHerdOfCow(cow.getId()));
			CowBcsModel b = cowBcsRepository.findLastBcs(cow.getId());
			
			if(b!=null) {
				cow_io.setLastBcs(ModelMapper.mapper(b));
			}
		
			response.setCow(cow_io);
		}
		
	
		return response;
	
	}

	
	/*------------------------------------------------------------------------------------*/
	/*-------------------------			   CowBcs	     	   ---------------------------*/
	/*------------------------------------------------------------------------------------*/
	@PayloadRoot(namespace =  NAMESPACE_URI, localPart = "postCowBcsRequest")
	@ResponsePayload
	public Response addCowBcs(@RequestPayload PostCowBcsRequest request) {
		
		
		Response response = new Response();
	
		CowBcsInput cowBcs_i = request.getHerd();

		CowBcsModel new_bcs = new CowBcsModel(cowBcs_i.getCowId(),cowBcs_i.getCc());
		cowBcsRepository.addCowBcs(new_bcs);
			
		response.setCode(BigInteger.valueOf(200));
		response.setMsg("new cow bcs id = " + new_bcs.getId());
		
		return response;
	
	}
	
	/*------------------------------------------------------------------------------------*/
	/*-------------------------			   CowAlert	     	   ---------------------------*/
	/*------------------------------------------------------------------------------------*/
	@PayloadRoot(namespace =  NAMESPACE_URI, localPart = "postCowAlertRequest")
	@ResponsePayload
	public Response addCowAlert(@RequestPayload PostCowAlertRequest request) {
		
		Response response = new Response();
	
		CowAlertInput herd_i = request.getAlert();
			
		HerdAlertModel new_alert = new HerdAlertModel(herd_i.getCowId(),
				herd_i.getBcsThresholdMin(),
				herd_i.getBcsThresholdMax())
				;
		herdAlertRepository.addAlert(new_alert);
			
		response.setCode(BigInteger.valueOf(200));
		response.setMsg("cow alert id = " + new_alert.getId());
		
		return response;
	}
	
	@PayloadRoot(namespace =  NAMESPACE_URI, localPart = "getAllCowAlertsRequest")
	@ResponsePayload
	public GetAllCowAlertsResponse getCowAlerts(@RequestPayload GetAllCowAlertsRequest request) {
		
		GetAllCowAlertsResponse response = new GetAllCowAlertsResponse();
		List<CowAlertOutput> alerts_io = new ArrayList<CowAlertOutput>();
		for(CowAlertModel alert : cowAlertRepository.getAlerts()) {
			alerts_io.add(ModelMapper.mapper(alert));
		}
		
		response.setAlerts(alerts_io);

		return response;
	}
	
	
	/*------------------------------------------------------------------------------------*/
	/*-------------------------			   Herd	     	   -------------------------------*/
	/*------------------------------------------------------------------------------------*/
	//Example
	//How are you going to implement what we want you to implement?
	
	@PayloadRoot(namespace =  NAMESPACE_URI, localPart = "getHerdRequest")
	@ResponsePayload
	public GetHerdResponse getHerd(@RequestPayload GetHerdRequest request) {
		long id = request.getId();
		
		HerdModel herd = herdRepository.findHerd(id);
		GetHerdResponse response = new GetHerdResponse();
		
		float bcs_total = 0f;
		if (herd != null) {
			HerdOutput herd_io = new HerdOutput(); //herd in out
			herd_io.setLocation(herd.getLocation());
			
			//the cows
			List<CowOutput> cows = new ArrayList<>();
			for (CowModel cow : herd.getCows()) {
				CowOutput cow_io = ModelMapper.mapper(cow);
				
				CowBcsModel b = cowBcsRepository.findLastBcs(cow.getId());
				if(b!=null) {	
					cow_io.setLastBcs(ModelMapper.mapper(b));
					bcs_total += (float)b.getCc();
				}
				
				cows.add(cow_io);
				
			}
			//the average
			if(!cows.isEmpty())
				herd_io.setAverageBcs((float)(bcs_total/cows.size()));
			else
				herd_io.setAverageBcs(0);
			
		
			herd_io.setCows(cows);
			
			response.setHerd(herd_io);
		}
		
		
		return response; //If the response is null, it would be necessary to return exception depending on the language, if it is for java or phyton etc.
	}
	
	
	@PayloadRoot(namespace =  NAMESPACE_URI, localPart = "getAllHerdsRequest")
	@ResponsePayload
	public GetAllHerdsResponse getAllHerd(@RequestPayload GetAllHerdsRequest request) {

		GetAllHerdsResponse response = new GetAllHerdsResponse();
		List<HerdModel> herds = herdRepository.getAll();
		List<HerdOutput> herds_io = new ArrayList<HerdOutput>();
		
		for(HerdModel herd : herds) {
			
			
			
			float bcs_total = 0f;
			if (herd != null) {
				HerdOutput herd_io = new HerdOutput(); //herd in out
				herd_io.setLocation(herd.getLocation());
				
				//the cows
				List<CowOutput> cows = new ArrayList<>();
				for (CowModel cow : herd.getCows()) {
					CowOutput cow_io = ModelMapper.mapper(cow);
					
					CowBcsModel b = cowBcsRepository.findLastBcs(cow.getId());
					if(b!=null) {	
						cow_io.setLastBcs(ModelMapper.mapper(b));
						bcs_total += (float)b.getCc();
					}
					cows.add(cow_io);
					
				}
				//the average
				if(!cows.isEmpty())
					herd_io.setAverageBcs((float)(bcs_total/cows.size()));
				else
					herd_io.setAverageBcs(0);
				
			
				herd_io.setCows(cows);
				
				herds_io.add(herd_io);
			}
			
		}

		response.setHerds(herds_io);
		
		return response; //If the response is null, it would be necessary to return exception depending on the language, if it is for java or phyton etc.
	}
	

	@PayloadRoot(namespace =  NAMESPACE_URI, localPart = "postHerdRequest")
	@ResponsePayload
	public Response addHerd(@RequestPayload PostHerdRequest request) {
		
		Response response = new Response();
		
		HerdInput herd = request.getHerd();
		HerdModel h = new HerdModel(herd.getLocation());
		response.setMsg("herd id = " + h.getId());
		
		if(herdRepository.addHerd(h))
			response.setCode(BigInteger.valueOf(200));
		else
			response.setCode(BigInteger.valueOf(403));
		
		return response;
	}
	
	/*------------------------------------------------------------------------------------*/
	/*-------------------------			   Herd Alert	     	   -----------------------*/
	/*------------------------------------------------------------------------------------*/
	@PayloadRoot(namespace =  NAMESPACE_URI, localPart = "postHerdAlertRequest")
	@ResponsePayload
	public Response addHerdAlert(@RequestPayload PostHerdAlertRequest request) {
		
		Response response = new Response();
		
		
		HerdAlertInput herd_i = request.getAlert();
			
		HerdAlertModel new_alert = new HerdAlertModel(herd_i.getHerdId(),
				herd_i.getBcsThresholdMin(),
				herd_i.getBcsThresholdMax())
				;
		herdAlertRepository.addAlert(new_alert);
			
		response.setCode(BigInteger.valueOf(200));
		response.setMsg("herd alert id = " + new_alert.getId());
		return response;
	}
	
	@PayloadRoot(namespace =  NAMESPACE_URI, localPart = "getAllHerdAlertsRequest")
	@ResponsePayload
	public GetAllHerdAlertsResponse getHerdAlerts(@RequestPayload GetAllHerdAlertsRequest request) {
		
		GetAllHerdAlertsResponse response = new GetAllHerdAlertsResponse();
		List<HerdAlertOutput> alerts_io = new ArrayList<HerdAlertOutput>();
		for(HerdAlertModel alert : herdAlertRepository.getAlerts()) {
			alerts_io.add(ModelMapper.mapper(alert));
		}
		
		response.setAlerts(alerts_io);

		return response;
	}
	
	
}
