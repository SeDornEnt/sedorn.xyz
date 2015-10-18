package org.sedorn.screenshotter.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.sedorn.screenshotter.json.JSONException;
import org.sedorn.screenshotter.json.JSONObject;

public class Config {
	
	public File config;
	
	public BufferedReader reader;
	public BufferedWriter writer;
	
	public boolean isNew = false;
	
	public void init() throws IOException{
		 config = new File("config.json");
		
		if(!config.exists()){
			config.createNewFile();
		}

		
	}
	public void set(String key, boolean value){
		config = new File("config.json");
		try {
			reader = new BufferedReader(new FileReader(config));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		String jsonData = null;
		try {
			jsonData = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		JSONObject json;
		
		if(jsonData != null){
			 json = new JSONObject(jsonData);
		} else {
			json = new JSONObject();
		}
		json.remove(key);
		json.put(key, value);
		
		config.delete();
			
		try {
			config.createNewFile();
			writer = new BufferedWriter(new FileWriter(config));
			writer.write(json.toString());
			writer.close();
			
			isNew = true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void set(String key, String value){
		config = new File("config.json");
		try {
			reader = new BufferedReader(new FileReader(config));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		String jsonData = null;
		try {
			jsonData = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		JSONObject json;
		
		if(jsonData != null){
			 json = new JSONObject(jsonData);
		} else {
			json = new JSONObject();
		}
		json.remove(key);
		json.put(key, value);
		
		config.delete();
			
		try {
			config.createNewFile();
			writer = new BufferedWriter(new FileWriter(config));
			writer.write(json.toString());
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getString(String key){
		config = new File("config.json");
		try {
			reader = new BufferedReader(new FileReader(config));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		String jsonData = null;
		try {
			jsonData = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		JSONObject json;
		
		if(jsonData != null){
			 json = new JSONObject(jsonData);
		} else {
			json = new JSONObject();
		}
		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String response = null;
		
		try{
			response = json.getString(key);
		} catch(JSONException e){
			e.printStackTrace();
		}
		
		return response;
	}
	public boolean getBoolean(String key){
		
		config = new File("config.json");
		try {
			reader = new BufferedReader(new FileReader(config));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		String jsonData = null;
		try {
			jsonData = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		JSONObject json;
		
		if(jsonData != null){
			 json = new JSONObject(jsonData);
		} else {
			json = new JSONObject();
		}
		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		boolean response = false;
		try{
			response = json.getBoolean(key);
		} catch(JSONException e){
			e.printStackTrace();
		}
		
		return response;
	}
}
