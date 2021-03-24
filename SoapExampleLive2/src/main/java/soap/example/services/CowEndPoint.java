package soap.example.services;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ar.edu.isistan.springsoap.gen.Cow;
import ar.edu.isistan.springsoap.gen.GetCowRequest;
import ar.edu.isistan.springsoap.gen.GetCowResponse;
import soap.example.model.CowModel;
import soap.example.repositories.CowRepository;

@Endpoint
public class CowEndPoint {
	private static final String NAMESPACE_URI = "http://www.isistan.edu.ar/springsoap/gen";

	private CowRepository cowRepository;
	
	@Autowired 
	public CowEndPoint(CowRepository animalRepository) {
		this.cowRepository = animalRepository;
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
}
