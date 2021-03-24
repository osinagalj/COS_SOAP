package soap.example.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import ar.edu.isistan.springsoap.gen.Cow;
import ar.edu.isistan.springsoap.gen.GetHerdRequest;
import ar.edu.isistan.springsoap.gen.GetHerdResponse;
import ar.edu.isistan.springsoap.gen.Herd;
import soap.example.model.CowModel;
import soap.example.model.HerdModel;
import soap.example.repositories.HerdRepository;


/*What do you think my methods are going to call me?
		 *
		 * You are going to define how you think my methods are going to be called.
 * */
@Endpoint
public class HerdEndPoint {

	private static final String NAMESPACE_URI = "http://www.isistan.edu.ar/springsoap/gen";

	private HerdRepository herdRepository;
	
	
	//it automatically creates a herd repository and passes it to me as a parameter here
	@Autowired 
	public HerdEndPoint(HerdRepository herdRepository) {
		this.herdRepository = herdRepository;
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
			
			response.setHerd(herd_io);
		}
		
		
		return response; //Si el response es null habria que devolver expecion dependiendo el lenguaje, si es para java o phyton etc
	}
	
	
}
