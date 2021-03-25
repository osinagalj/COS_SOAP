package soap.example.services;

import java.math.BigDecimal; 
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import ar.edu.isistan.springsoap.gen.AnimalAlert;
import ar.edu.isistan.springsoap.gen.AssociateCowToHerdRequest;
import ar.edu.isistan.springsoap.gen.Cow;
import ar.edu.isistan.springsoap.gen.GetAnimalAlertResponse;
import ar.edu.isistan.springsoap.gen.GetHerdAlertRequest;
import ar.edu.isistan.springsoap.gen.GetHerdAlertResponse;
import ar.edu.isistan.springsoap.gen.GetHerdRequest;
import ar.edu.isistan.springsoap.gen.GetHerdResponse;
import ar.edu.isistan.springsoap.gen.Herd;
import ar.edu.isistan.springsoap.gen.HerdAlert;
import ar.edu.isistan.springsoap.gen.PostCowToHerdRequest;
import ar.edu.isistan.springsoap.gen.PostHerdAlertRequest;
import ar.edu.isistan.springsoap.gen.PostHerdRequest;
import ar.edu.isistan.springsoap.gen.Response;
import soap.example.model.AnimalAlertModel;
import soap.example.model.CowModel;
import soap.example.model.HerdAlertModel;
import soap.example.model.HerdModel;
import soap.example.repositories.CowRepository;
import soap.example.repositories.HerdAlertRepository;
import soap.example.repositories.HerdRepository;

import java.math.BigInteger;


@Endpoint
public class HerdEndPoint {

	private static final String NAMESPACE_URI = "http://www.isistan.edu.ar/springsoap/gen";

	private HerdRepository herdRepository;
	private CowRepository cowRepository;
	private HerdAlertRepository herdAlertRepository;
	//it automatically creates a herd repository and passes it to me as a parameter here
	@Autowired 
	public HerdEndPoint(HerdRepository herdRepository,CowRepository cowRepository2,HerdAlertRepository herdAlertRepository) {
		this.herdRepository = herdRepository;
		this.cowRepository = cowRepository2;
		this.herdAlertRepository = herdAlertRepository;
	}
	
	
	//How are you going to implement what we want you to implement?
	@PayloadRoot(namespace =  NAMESPACE_URI, localPart = "getHerdRequest")
	@ResponsePayload
	public GetHerdResponse getHerd(@RequestPayload GetHerdRequest request) {
		long id = request.getId().longValue();
		
		HerdModel herd = herdRepository.findHerd(id);
		GetHerdResponse response = new GetHerdResponse();
		
		
		if (herd != null) {
			Herd herd_io = new Herd(); //herd in out
			
			List<Cow> cows = new ArrayList<>();
			for (CowModel cow : herd.getCows()) {
				Cow cow_io = new Cow();
				cow_io.setId((int) cow.getId());
				cow_io.setWeight(new BigDecimal(cow.getWeight()));
				cows.add(cow_io);
			}
			
			herd_io.setCows(cows);
			herd_io.setLocation(herd.getLocation());
			response.setHerd(herd_io);
		}
		
		
		return response; //Si el response es null habria que devolver expecion dependiendo el lenguaje, si es para java o phyton etc
	}
	

	@PayloadRoot(namespace =  NAMESPACE_URI, localPart = "postHerdRequest")
	@ResponsePayload
	public Response addHerd(@RequestPayload PostHerdRequest request) {
		
		long id = request.getId().longValue();
		String location = request.getLocation().toString();
		HerdModel h = new HerdModel(id,location);
		herdRepository.addHerd(h);
		
		Response response = new Response();
		response.setCode(BigInteger.valueOf(200));
		
		return response;
	}
	
	
	@PayloadRoot(namespace =  NAMESPACE_URI, localPart = "postCowToHerdRequest")
	@ResponsePayload
	public Response addCowToHerd(@RequestPayload PostCowToHerdRequest request) {
		
		long id = request.getIdHerd().longValue();
		Cow cow = request.getCow();
		herdRepository.addCowToHerd(id, cow);
		
		
		Response response = new Response();
		response.setCode(BigInteger.valueOf(200)); //para indicar que se cargo correctamente
		return response;
	}
	
	
	@PayloadRoot(namespace =  NAMESPACE_URI, localPart = "associateCowToHerdRequest")
	@ResponsePayload
	public Response associateCowToHerd(@RequestPayload AssociateCowToHerdRequest request) {
		
		long id_herd = request.getIdHerd().longValue();
		long id_cow = request.getIdCow().longValue();
		CowModel cow = cowRepository.findAnimal(id_cow);
		
		Response response = new Response();
		if(cow != null) {		
			if(herdRepository.associateCowToHerd(id_herd, cow)) 
				response.setCode(BigInteger.valueOf(200)); // if it was added correctly
			else
				response.setCode(BigInteger.valueOf(404)); //if the herd does not exist
		}else
			response.setCode(BigInteger.valueOf(403)); //if the id of the cow does not exist
			
		return response;
	}
	
	@PayloadRoot(namespace =  NAMESPACE_URI, localPart = "postHerdAlertRequest")
	@ResponsePayload
	public Response addAlertToHerd(@RequestPayload PostHerdAlertRequest request) {
		
		long animalId = request.getIdHerd().longValue();
		int bcsThreshold = request.getBcsThreshold().intValue();
		Response response = new Response();
		
		if(cowRepository.findAnimal(animalId) != null) {
			herdAlertRepository.addAlert((int)animalId, bcsThreshold);
			response.setCode(BigInteger.valueOf(200)); //successful
		}else {
			response.setCode(BigInteger.valueOf(404)); //error cow not found
		}
		
		return response;
	}
	
	@PayloadRoot(namespace =  NAMESPACE_URI, localPart = "getHerdAlertRequest")
	@ResponsePayload
	public GetHerdAlertResponse addAlertToHerd(@RequestPayload GetHerdAlertRequest request) {
		
		GetHerdAlertResponse response = new GetHerdAlertResponse();
		
		List<HerdAlert> alerts = new ArrayList<>();
		
		for(HerdAlertModel alert: herdAlertRepository.getAlerts()) {
			System.out.println("Entro en el for, id = " + alert.getId() );
			HerdAlert new_alert = new HerdAlert();
			new_alert.setId(alert.getId());
			new_alert.setBcsThreshold(alert.getBcsThreshold());
			new_alert.setHerdId(alert.getHerdId());
			
			alerts.add(new_alert);
			
		}
	
		response.setAlerts(alerts);
		
		return response;
	}

	
}
