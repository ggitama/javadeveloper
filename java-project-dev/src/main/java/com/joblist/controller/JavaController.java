package com.joblist.controller;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin()
public class JavaController {
	
	@Autowired
	RestTemplate restTemplate;
    
	String urlAll = "http://dev3.dansmultipro.co.id/api/recruitment/positions.json";
	String urlID = "http://dev3.dansmultipro.co.id/api/recruitment/positions/";
	
    @RequestMapping(value = "/java")
    public Object getProductList() {
       HttpHeaders headers = new HttpHeaders();
       headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
       HttpEntity <Object> entity = new HttpEntity<Object>(headers);
       
       return restTemplate.exchange(urlAll, HttpMethod.GET, entity, Object.class).getBody();
    }
	
    @RequestMapping(value = "/java/{ID}")
    public Object getDetailList(@PathVariable("ID") String ID) {
       HttpHeaders headers = new HttpHeaders();
       headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
       HttpEntity <Object> entity = new HttpEntity<Object>(headers);
       return restTemplate.exchange(urlID+ID, HttpMethod.GET, entity, Object.class).getBody();
    }
    
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
}