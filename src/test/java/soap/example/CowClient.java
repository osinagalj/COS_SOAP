package soap.example;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import ar.edu.isistan.springsoap.gen.GetCowRequest;
import ar.edu.isistan.springsoap.gen.GetCowResponse;


public class CowClient extends WebServiceGatewaySupport {

    public GetCowResponse getCountry(String cow) {
    	GetCowRequest request = new GetCowRequest();
        request.setId(1);

        GetCowResponse response = (GetCowResponse) getWebServiceTemplate()
          .marshalSendAndReceive(request);
        return response;
    }
}