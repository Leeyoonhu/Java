package com.adacho.common;

import org.apache.hadoop.io.Text;

public class AirlinePerformanceParser {
	// 필요한 정보만 뽑을 거라서 필드 생성
	private int year, month, day;
	
	private int arriveDelayTime = 0;
	private int departureDelayTime = 0;
	private int distance = 0;
	
	private boolean arriveDelayAvailable = true;
	private boolean departureDelayAvailable = true;
	private boolean distanceAvailable = true;
	
	private String uniqueCarrier;

	public AirlinePerformanceParser(Text text) {
		try {
			// 한 줄의 정보를 담고있는 columns
			String[] columns = text.toString().split(",");
			
			year = Integer.parseInt(columns[0]);
			month = Integer.parseInt(columns[1]);
			day = Integer.parseInt(columns[2]);
			uniqueCarrier = columns[5];
			
			// 딜레이 타임은 없는 text도 있음 (if문으로 있을 때, 없을 때)
			if(!columns[16].equals("")) {
				departureDelayTime = (int)Float.parseFloat(columns[16]);
			}
			else {
				departureDelayAvailable = false;
			}
			
			if(!columns[26].equals("")) {
				arriveDelayTime = (int)Float.parseFloat(columns[26]);
			}
			else {
				arriveDelayAvailable = false;
			}
			
			if(!columns[37].equals("")) {
				distance = (int)Float.parseFloat(columns[37]);
			}
			else {
				distanceAvailable = false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}

	public int getArriveDelayTime() {
		return arriveDelayTime;
	}

	public int getDepartureDelayTime() {
		return departureDelayTime;
	}

	public int getDistance() {
		return distance;
	}

	public boolean isArriveDelayAvailable() {
		return arriveDelayAvailable;
	}

	public boolean isDepartureDelayAvailable() {
		return departureDelayAvailable;
	}

	public boolean isDistanceAvailable() {
		return distanceAvailable;
	}

	public String getUniqueCarrier() {
		return uniqueCarrier;
	}	
}
