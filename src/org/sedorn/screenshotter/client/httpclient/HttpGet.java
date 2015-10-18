package org.sedorn.screenshotter.client.httpclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpGet {
	private String urlS = "http://sedorn.xyz:8080/api/";
	private String USER_AGENT = "SeDorn/0.5";
	
	
	public StringBuffer send(String function) throws IOException{
		URL url = new URL(urlS + function);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		
		con.setRequestMethod("GET");
		
		con.setRequestProperty("User-Agent", USER_AGENT);
	
		int responseCode = con.getResponseCode();
		
		System.out.println("\nSending 'GET' request to URL : " + url.toString());
		System.out.println("Response Code : " + responseCode);
		
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		System.out.println(response.toString());
		return response;
	}
}
