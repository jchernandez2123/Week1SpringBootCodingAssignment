/**
 * 
 */
package com.promineotech.jeep.controller;


import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import com.promineotech.jeep.controller.support.FetchJeepTestSupport;
import com.promineotech.jeep.entity.Jeep;
import com.promineotech.jeep.entity.JeepModel;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)

@ActiveProfiles("test")
@Sql(scripts = {
    "classpath:flyway/migrations/V1.0__Jeep_Schema.sql",
    "classpath:flyway/migrations/V1.1__Jeep_Data.sql"}, 
    config = @SqlConfig(encoding = "utf-8"))


class FetchJeepTest extends FetchJeepTestSupport {
  
  
  
  @Autowired
  private TestRestTemplate restTemplate;
  @LocalServerPort
  private int serverPort;

  @Test
  void testThatJeepsAreReturnedWhenAValidModelAndTrimAreSupplied() {
    
    //Given: a valid model, trim and URI
    
    JeepModel model = JeepModel.WRANGLER;
    
    String trim = "Sport";
    
    String uri = String.format("http://localhost/%d/jeeps?model=%s&trim=%s", serverPort, model, trim);
    //changed serverPort to protected in the baseTest.java
 
    //When: a connection is made to the URI
    
    ResponseEntity<List<Jeep>> response = restTemplate.exchange(uri,
        HttpMethod.GET, null, new ParameterizedTypeReference<>() {});
 
    
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    
   
    
    //String uri = String.format("%s?model=%s&trim=%s", getBaseUri(), model, trim);
    //The above was how it was typed in the video instructions^^^^^^^
  //  System.out.println(uri); this prints out the uri 
    
    
    
  //ResponseEntity<Jeep> response =  // this was in the video
    //    getRestTemplate().getForEntity(uri, Jeep.class); this was also in the video 
    
    //Then: a success (OK - 200) status code is returned
   // System.out.println(getBaseUri());
    //fail("Not yet implemented"); this was implemented first but then changed to the above code
  }

}
