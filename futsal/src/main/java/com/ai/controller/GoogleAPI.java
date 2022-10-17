package com.ai.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class GoogleAPI {
	// https://developers.google.com/identity/protocols/oauth2/web-server#httprest_1 참고
	public String getAccessToken(String code) {
		String accessToken = "";
		String refreshToken = "";
		String reqUrl = "https://oauth2.googleapis.com/token";
		String clientId = "407684725072-2ikndkuqcafeku5ufb4dvnm940t1d1v1.apps.googleusercontent.com";
		String clientSecret = "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";
		String redirectURL = "http://localhost:8080/loginAccess";
		try {
			URL url = new URL(reqUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			// google 문서 상 method = "POST"
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			System.out.println("url : " + url);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
			StringBuilder sb = new StringBuilder();
			// code, client_id, client_secret, redirect_uri, grant_type
			sb.append("code=" + code);
			sb.append("&client_id=" + clientId);
			sb.append("&client_secret=" + clientSecret);
			sb.append("&redirect_uri=" + redirectURL);
			sb.append("&grant_type=authorization_code");
			// access_type 매개변수를 offline로 설정하는 경우에만 refresh_token 발행
			sb.append("&access_type=offline");
			System.out.println("sb toString :: " + sb.toString());
			bw.write(sb.toString());
			bw.flush();
			
			int responseCode = conn.getResponseCode();
			// 상태 확인
			System.out.println("responseCode : " + responseCode);
			
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			String line = "";
			String result = "";
			
			while((line = br.readLine()) != null) {
				result += line;
			}
			System.out.println("responseBody : " + result);
			
			JsonParser parser = new JsonParser();
			JsonElement element = parser.parse(result);
			accessToken = element.getAsJsonObject().get("access_token").getAsString();
			refreshToken = element.getAsJsonObject().get("refresh_token").getAsString();
			
			br.close();
			bw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return accessToken;
	}
	
	public HashMap<String, Object> getUserInfo(String accessToken) {
		HashMap<String, Object> userInfo = new HashMap<String, Object>();
		
		String reqUrl = "https://www.googleapis.com/oauth2/v1/userinfo?alt=json&access_token=" + accessToken;
		BufferedReader br = null;
		try {
			URL url = new URL(reqUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			conn.setRequestMethod("GET");
			// header 에 필요한 요청
			conn.setRequestProperty("Authorization", "Bearer " + accessToken);
			
			int responseCode = conn.getResponseCode();
	        // 상태확인
			System.out.println("responseCode : " + responseCode);
			
			
			if(responseCode == 200) { 
		        br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		    } 
			else {  
		        br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		    }
			
			String line = "";
			String result = "";
			
			while((line = br.readLine()) != null) {
				result += line;
			}
			
			System.out.println("responseBody : " + result);
			
			JsonParser parser = new JsonParser();
			JsonElement element = parser.parse(result);
			
			String nickName = element.getAsJsonObject().get("name").getAsString();
			String email = element.getAsJsonObject().get("email").getAsString();
			
			userInfo.put("nickName", nickName);
			userInfo.put("email", email);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return userInfo;
	}
	
	public void logout(String accessToken) {
		// https://developers.google.com/identity/protocols/oauth2/web-server#tokenrevoke 참고
		// CURL 이란 서버와 통신할 수 있는 커맨드 명령어 툴
		String reqUrl = "https://oauth2.googleapis.com/revoke";
		BufferedReader br = null;
		try {
			//URL url = new URL(reqUrl2);
			URL url = new URL(reqUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			// method = "POST"
			// GET 방식인 경우 쿼리스트링을 사용해서 보냄
			// POST 방식이기 때문에 쿼리스트링 대신 bufferedWriter를 통해서 작성
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			
			conn.setDoOutput(true);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
			StringBuilder sb = new StringBuilder();
			sb.append("token=" + accessToken);
			bw.write(sb.toString());
			bw.flush();
			
			
			int responseCode = conn.getResponseCode();
			System.out.println("responseCode : " + responseCode);
			
			if(responseCode == 200) { 
		        br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		    } 
			else {  
		        br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		    }
			
			String line = "";
			String result = "";
			
			while((line = br.readLine()) != null) {
				result += line;
			}
			System.out.println("logout : " + result);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
