package com.adacho.mapper;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import com.adacho.common.AirlinePerformanceParser;
import com.adacho.common.DateKey;
import com.adacho.counter.DelayCounter;

public class DelayCountMapperDateKey extends Mapper<LongWritable, Text, DateKey, IntWritable>  {
	private final static IntWritable outputValue = new IntWritable(1);
	private DateKey outputKey = new DateKey();
	
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, DateKey, IntWritable>.Context context)
			throws IOException, InterruptedException {
		AirlinePerformanceParser parser = new AirlinePerformanceParser(value);
		// 만약 타입이 출발이면
		
		// 만약에 출발 지연시간이 존재한다면
		if(parser.isDepartureDelayAvailable()) {
			// 출발 지연시간이 양수일 때 (출발이 지연되었을 때)
			if(parser.getDepartureDelayTime() > 0) {
				outputKey.setYear("D," + parser.getYear());
				outputKey.setMonth(parser.getMonth());
				context.write(outputKey, outputValue);
			}
			// 출발 지연시간이 0 일때
			else if(parser.getDepartureDelayTime() == 0) {
				// 정시 출발 데이터 카운트 1 증가
				context.getCounter(DelayCounter.scheduled_departure).increment(1);
			}
			// 출발 지연시간이 음수일 때 (출발 시간보다 먼저 출발)
			else if(parser.getDepartureDelayTime() < 0) {
				// 미리 출발 데이터 카운트 1 증가
				context.getCounter(DelayCounter.early_departure).increment(1);
			}
		} 
		// 출발 지연시간이 존재하지 않는다면 (데이터가 누락됬다면?)
		else {
			// 누락된 출발 데이터 카운트 1증가
			context.getCounter(DelayCounter.not_available_departure).increment(1);
		}
	
		
		// 만약 타입이 도착이면
		// 만약에 도착 지연시간이 존재한다면
		if(parser.isArriveDelayAvailable()) {
			// 도착 지연시간이 양수일 때 (도착이 지연되었을 때)
			if(parser.getArriveDelayTime() > 0) {
				outputKey.setYear("A," + parser.getYear());
				outputKey.setMonth(parser.getMonth());
				context.write(outputKey, outputValue);
			}
			// 도착 지연시간이 0 일때
			else if(parser.getArriveDelayTime() == 0) {
				// 정시 도착 데이터 카운트 1 증가
				context.getCounter(DelayCounter.scheduled_arrival).increment(1);
			}
			// 도착 지연시간이 음수일 때 (출발 시간보다 먼저 출발)
			else if(parser.getArriveDelayTime() < 0) {
				// 미리 도착 데이터 카운트 1 증가
				context.getCounter(DelayCounter.early_arrival).increment(1);
			}
		} 
		// 도착 지연시간이 존재하지 않는다면 (데이터가 누락됬다면?)
		else {
			// 누락된 도착 데이터 카운트 1증가
			context.getCounter(DelayCounter.not_available_arrival).increment(1);
		}
	
	}
}
