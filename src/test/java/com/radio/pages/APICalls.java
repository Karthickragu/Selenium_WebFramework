package com.radio.pages;

import io.restassured.RestAssured;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APICalls {
	
	private Header header = null; 	
	private Response response = null;	
	private RequestSpecification httpRequest = null;	
	private JSONParser parser = null;
	private Object object = null;
	private JSONObject jsonObject = null;
	private JSONArray jsonArray = null;
	private String string = null;
	private String defaultShipToNumber = null;
	
	public String getValue() {
		 RestAssured.baseURI = "https://opensource-demo.orangehrmlive.com";
		 
		 RequestSpecification httpRequest = RestAssured.given();
		 
		 Response response = httpRequest.get("/index.php/auth/validateCredentials");
		 
		 
		 return response.asString();
	}

	public void getValue_Login(String username, String password) throws ParseException {
		RestAssured.baseURI = "https://qaservices.mscdirect.com/customerservice/apiLogin";
		httpRequest = RestAssured.given();
		httpRequest.param("format", "json");
		header = new Header("txtUsername", username);
		httpRequest.header(header);
		header = new Header("txtPassword", password);
		httpRequest.header(header);
		response = httpRequest.request(Method.POST);
		//System.out.println("%***************************");
		//System.out.println(response.getBody().asString());
		//System.out.println("%*****************************");
		//return response.getBody().asString();
		
		
		parser = new JSONParser();
		object = parser.parse(response.getBody().asString());
		jsonObject = (JSONObject) object;
		parser = new JSONParser();
		System.out.println(parser);
		/*
		object = parser.parse(jsonObject.get("CustomerServiceResult").toString());
		jsonObject = (JSONObject) object;
		jsonArray = (JSONArray) jsonObject.get("customers");
		jsonObject = (JSONObject) jsonArray.get(0);
		object = parser.parse(jsonObject.get("billToInfo").toString());
		jsonObject = (JSONObject) object;
		defaultShipToNumber = jsonObject.get("canDisplayNSS").toString();
		System.out.println(defaultShipToNumber);
		return defaultShipToNumber;
		*/
	}
	
	
	
}
