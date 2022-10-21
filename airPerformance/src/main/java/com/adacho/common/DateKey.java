package com.adacho.common;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableUtils;

// 복합키 클래스
public class DateKey implements WritableComparable<DateKey> {
	private String year;
	private Integer month;
	
	public DateKey() {
		
	}
	
	public DateKey(String year, Integer month) {
		this.year = year;
		this.month = month;
	}
	
	@Override
	public void write(DataOutput out) throws IOException {
		WritableUtils.writeString(out, year);
		out.writeInt(month);
	}
	
	@Override
	public void readFields(DataInput in) throws IOException {		
		year = WritableUtils.readString(in);
		month = in.readInt();
	}
	
	// 하둡에서 comapreTo로 비교할 것임 (복합 키의 핵심)
	// 서로다른 DateKey 객체끼리의 비교
	@Override
	public int compareTo(DateKey key) {
		// 내 년도와 가져온 키의 년도 비교 (전차 - 후자)
		// result는 >> -1, 0, 1 중에서 나옴
		int result = year.compareTo(key.year);
		
		// 둘이 년도가 같다면
		if(result == 0) {
			// 월로 비교해서 누가 큰지 볼 것임
			result = month.compareTo(key.month);
		}
		
		return result;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return new StringBuilder().append(year).append(",").append(month).toString();
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}
}
