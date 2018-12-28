package com.nguyenvulong2002.bookclient.constant;

import org.springframework.web.client.RestTemplate;

public class RestTemplateInstance {

	private static RestTemplate instance;

	//private constructor to avoid client applications to use constructor
	private RestTemplateInstance(){}

	public static RestTemplate getInstance(){
		if(instance == null) {
			instance = new RestTemplate();
		}
		return instance;
	}
}
