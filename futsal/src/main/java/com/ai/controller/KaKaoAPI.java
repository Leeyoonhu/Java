package com.ai.controller;

import java.io.BufferedReader; 
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;


import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class KaKaoAPI {
	// https://developers.kakao.com/docs/latest/ko/kakaologin/rest-api 문서 참고
	
	// 토큰 요청 (https://developers.kakao.com/docs/latest/ko/kakaologin/rest-api#request-token)
	public String getAccessToken(String code) {
		String accessToken = "";
		String refreshToken = "";
		// 요청 Url (HOST - OAuth)
		String reqUrl = "https://kauth.kakao.com/oauth/token";
		String clientId = "8f3bf912ba858b8abef6fa5d46d5ff7b";
		String redirectURL = "http://localhost:8080/loginAccess";
		try {
			// java.net의 URL, HttpURLConnection 객체 사용
			URL url = new URL(reqUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			// post 방식 set
			conn.setRequestMethod("POST");
			// 출력에 URL 연결을 사용하려는 경우 doOutputflag를 true로 설정하고 그렇지 않은 경우 false로 설정합니다. 기본값은 false
			conn.setDoOutput(true);
			
			// 예전에 했던 I/O
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
			StringBuilder sb = new StringBuilder();
			// grant_type = authorization_code (인가 코드) 고정 값임
			sb.append("grant_type=authorization_code");
			// client_id = javaScript Key
			sb.append("&client_id=" + clientId);
			// redirect 주소 (변경, 수정 필요)
			sb.append("&redirect_uri=" + redirectURL);
			// authorization_code
			sb.append("&code="+code);
			// client_secret 은 ON인 경우 필수설정이지만 X 이기에 추가안했음..
			
			bw.write(sb.toString());
			bw.flush();
			
			// 200 or 401
			int responseCode = conn.getResponseCode();
			System.out.println("responseCode : " + responseCode);
			
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			String line = "";
			String result = "";
			
			while((line = br.readLine()) != null) {
				result += line;
			}
			System.out.println("responseBody : " + result);
			
			// Json Parsing
			JsonParser parser = new JsonParser();
			JsonElement element = parser.parse(result);
			
			// 파싱한 결과물중에 토큰이 있음 (2개)
			accessToken = element.getAsJsonObject().get("access_token").getAsString();
			refreshToken = element.getAsJsonObject().get("refresh_token").getAsString();
			
			// 닫아주고
			br.close();
			bw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return accessToken;
	}
	
	
	// 토큰으로 유저정보 조회
	public HashMap<String, Object> getUserInfo(String accessToken) {
		HashMap<String, Object> userInfo = new HashMap<String, Object>();
		// 요청 Url, KaKaoDevelopers REST API - Access Token 사용 문서 참조
		String reqUrl = "https://kapi.kakao.com/v2/user/me";
		BufferedReader br = null;
		try {
			// java.net의 URL, HttpURLConnection 객체 사용
			URL url = new URL(reqUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			// post 방식 set
			conn.setRequestMethod("POST");
			// Access Token 사용 문서의 Authorization(인가) key - value set
			conn.setRequestProperty("Authorization", "Bearer " + accessToken);
			// 200 or 401
			int responseCode = conn.getResponseCode();
			System.out.println("responseCode : " + responseCode);
			
			// 예전에 했던 I/O
			if(responseCode == 200) { 
		        br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		    } 
			else {  
		        br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		    }
			
			String line = "";
			String result = "";
			
			// 읽어올게 없을 때 까지 result 에 더함
			while((line = br.readLine()) != null) {
				result += line;
			}
			// 결과값 확인용(후에 지워도 됨)
			System.out.println("responseBody : " + result);
			
			// Json data parsing (가져온 유저 정보 parsing)
			JsonParser parser = new JsonParser();
			JsonElement element = parser.parse(result);
			
			JsonObject properties = element.getAsJsonObject().get("properties").getAsJsonObject();
			JsonObject kakaoAccount = element.getAsJsonObject().get("kakao_account").getAsJsonObject();
			String nickName = properties.getAsJsonObject().get("nickname").getAsString();
			String email = kakaoAccount.getAsJsonObject().get("email").getAsString();
			
			// HashMap k-v 선언 
			userInfo.put("nickName", nickName);
			userInfo.put("email", email);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 유저 정보 반환
		return userInfo;
	}

	
	// 로그아웃 (https://developers.kakao.com/docs/latest/ko/kakaologin/rest-api#logout)
	// 사용자 액세스 토큰과 리프레시 토큰을 모두 만료시킵니다.
	public void logout(String accessToken) {
		// host + post
		String reqUrl = "https://kapi.kakao.com/v1/user/logout";
		BufferedReader br = null;
		try {
			URL url = new URL(reqUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			// Method = "POST"
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Authorization", "Bearer " + accessToken);
			
			// 200 or 401
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
