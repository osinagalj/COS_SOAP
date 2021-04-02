package soap.example;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import ar.edu.isistan.springsoap.gen.GetCowResponse;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = CowClientConfig.class, loader = AnnotationConfigContextLoader.class)
public class ClientLiveTest {

   /* @Autowired
    CowClient client;

    @Test
    public void givenCountryService_whenCountryPoland_thenCapitalIsWarsaw() {
        GetCowResponse response = client.getCountry("Poland");
        assertEquals((long)1, response.getCow().getId());
    }*/

  /*  
    @Test
    public void givenCountryService_whenCountrySpain_thenCurrencyEUR() {
        GetCountryResponse response = client.getCountry("Spain");
        assertEquals(Currency.EUR, response.getCountry().getCurrency());
    }
    
    */
}
