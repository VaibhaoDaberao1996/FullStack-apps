package com.Transaction.Utils;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.Transaction.Entity.ProductTransaction;

@Component
public class ApiService {
	
	@Value("${api.url}")
	private String url;

	public List<ProductTransaction> fetchTransaction(){
		
		RestTemplate restTemplate = new RestTemplate();
		
		System.out.println(url);
		ProductTransaction[] tranArray = restTemplate.getForObject(url, ProductTransaction[].class);
		
		List<ProductTransaction> resultList = Arrays.asList(tranArray);
		
		return resultList;
		
		
	}
}
