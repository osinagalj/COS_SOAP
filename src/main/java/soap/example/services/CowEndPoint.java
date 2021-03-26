package soap.example.services;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import ar.edu.isistan.springsoap.gen.AddCowRequest;
import ar.edu.isistan.springsoap.gen.AnimalAlert;
import ar.edu.isistan.springsoap.gen.Cow;
import ar.edu.isistan.springsoap.gen.GetAnimalAlertRequest;
import ar.edu.isistan.springsoap.gen.GetAnimalAlertResponse;
import ar.edu.isistan.springsoap.gen.GetCowRequest;
import ar.edu.isistan.springsoap.gen.GetCowResponse;

import ar.edu.isistan.springsoap.gen.PostAnimalAlertRequest;
import ar.edu.isistan.springsoap.gen.Response;
import soap.example.model.AnimalAlertModel;
import soap.example.model.CowModel;
import soap.example.repositories.AnimalAlertRepository;
import soap.example.repositories.CowRepository;

@Endpoint
public class CowEndPoint {
	private static final String NAMESPACE_URI = "http://www.isistan.edu.ar/springsoap/gen";

	private CowRepository cowRepository;
	private AnimalAlertRepository animalAlertRepository;
	
	@Autowired 
	public CowEndPoint(CowRepository animalRepository,AnimalAlertRepository animalAlertRepository) {
		this.cowRepository = animalRepository;
		this.animalAlertRepository = animalAlertRepository;
	}
	
	
	//How are you going to implement what we want you to implement?
	@PayloadRoot(namespace =  NAMESPACE_URI, localPart = "getCowRequest")
	@ResponsePayload
	public GetCowResponse getCow(@RequestPayload GetCowRequest request) {
		long id = request.getId().longValue();
		
		CowModel cow = cowRepository.findAnimal(id);
		GetCowResponse response = new GetCowResponse();
		
		if (cow != null) {
			Cow cow_io = new Cow(); //herd in out
			cow_io.setId((int) cow.getId());
			cow_io.setWeight(new BigDecimal(cow.getWeight()));
			cow_io.setElectronicId(cow.getElectronicId());	
			cow_io.setBornDate(cow.getBorn_date());
			cow_io.setLastDueDate(cow.getLastDueDate());

			response.setCow(cow_io);
		}
		
		
		return response;
	
	}
	
	//How are you going to implement what we want you to implement?
	@PayloadRoot(namespace =  NAMESPACE_URI, localPart = "addCowRequest")
	@ResponsePayload
	public Response addCow(@RequestPayload AddCowRequest request) {
	
		Cow cow = request.getCow();
		
		Response response = new Response();
		
		if (cow != null) {
			CowModel cow_io = new CowModel(); //herd in out
			cow_io.setId((int) cow.getId());
			cow_io.setWeight(cow.getWeight().floatValue());
			cow_io.setElectronicId(cow.getElectronicId());	
			cow_io.setBorn_date(cow.getBornDate());
			cow_io.setLastDueDate(cow.getLastDueDate());
			
			if(cowRepository.addAnimal(cow_io)){
				response.setCode(BigInteger.valueOf(200)); //successful
			}else {
				response.setCode(BigInteger.valueOf(403)); //the cow already exists
			}
			
		}else {
			response.setCode(BigInteger.valueOf(404)); //error in the cow data
		}
		
		
		return response;
	}
	
	

	@PayloadRoot(namespace =  NAMESPACE_URI, localPart = "postAnimalAlertRequest")
	@ResponsePayload
	public Response addCowAlert(@RequestPayload PostAnimalAlertRequest request) {
	
		long animalId = request.getIdAnimal().longValue();
		int bcsThreshold = request.getBcsThreshold().intValue();
		Response response = new Response();
		
		if(cowRepository.findAnimal(animalId) != null) {
			animalAlertRepository.addAlert((int)animalId, bcsThreshold);
			response.setCode(BigInteger.valueOf(200)); //successful
		}else {
			response.setCode(BigInteger.valueOf(404)); //error cow not found
		}
		
		return response;
	}
	

	@PayloadRoot(namespace =  NAMESPACE_URI, localPart = "getAnimalAlertRequest")
	@ResponsePayload
	public GetAnimalAlertResponse getAnimalAlerts(@RequestPayload GetAnimalAlertRequest request) {
	
		GetAnimalAlertResponse response = new GetAnimalAlertResponse();
		
		List<AnimalAlert> alerts = new ArrayList<>();
		
		for(AnimalAlertModel alert: animalAlertRepository.getAlerts()) {
			System.out.println("Entro en el for, id = " + alert.getId() );
			AnimalAlert new_alert = new AnimalAlert();
			new_alert.setId(alert.getId());
			new_alert.setBcsThreshold(alert.getBcsThreshold());
			new_alert.setAnimalId(alert.getAnimalId());
			
			alerts.add(new_alert);
			
		}
	
		response.setAlerts(alerts);
		
		return response;
	}
	
}
