package com.radio.pages;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import io.restassured.RestAssured;
import java.util.HashMap;
import java.util.Map;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Dummy {
	
	private static Header header = null; 	
	private static Response response = null;	
	private static RequestSpecification httpRequest = null;	
	private static JSONParser parser = null;
	private static Object object = null;
	private static JSONObject jsonObject = null;
	private static JSONArray jsonArray = null;
	private String string = null;
	private static String defaultShipToNumber = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			RestAssured.baseURI = "https://opensource-demo.orangehrmlive.com";
			httpRequest = RestAssured.given();
			
			 RequestSpecification httpRequest = RestAssured.given();
			 
			 Response response = httpRequest.get("/index.php/auth/validateCredentials");
			 
			 
			httpRequest.param("format", "json");
			header = new Header("txtUsername", "admin");
			httpRequest.header(header);
			header = new Header("txtPassword", "admin123");
			httpRequest.header(header);
			response = httpRequest.request(Method.POST);
			System.out.println("%***************************");
			System.out.println(response.getBody().asString());
			System.out.println("%*****************************");
			//return response.getBody().asString();
			
			
			parser = new JSONParser();
			try {
				object = parser.parse(response.getBody().asString());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			jsonObject = (JSONObject) object;
			parser = new JSONParser();
			System.out.println(jsonObject);
			
			
			try {
				object = parser.parse(jsonObject.get("CustomerServiceResult").toString());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			jsonObject = (JSONObject) object;
			jsonArray = (JSONArray) jsonObject.get("customers");
			jsonObject = (JSONObject) jsonArray.get(0);
			try {
				object = parser.parse(jsonObject.get("billToInfo").toString());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			jsonObject = (JSONObject) object;
			defaultShipToNumber = jsonObject.get("canDisplayNSS").toString();
			System.out.println(defaultShipToNumber);
		//	return defaultShipToNumber;
			
		}
		

	}


