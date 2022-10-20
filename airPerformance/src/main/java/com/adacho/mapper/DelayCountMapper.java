package com.adacho.mapper;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import com.adacho.common.AirlinePerformanceParser;

public class DelayCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
	private final static IntWritable outputValue = new IntWritable(1);
	private Text outputKey = new Text();
	// 출발 지연인지 도착 지연인지 보기위해 Type 변수 선언
	private String workType;
	
	// mapper 개체가 생성될 때 최초로 실행 setup
	@Override
	protected void setup(Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		// map method가 실행되기 전에 type을 받아서 시작이면 시작지연, 도착이면 도착지연으로 보냄
		workType = context.getConfiguration().get("workType");
	}
	
	// setup 후 MAPPER
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		AirlinePerformanceParser parser = new AirlinePerformanceParser(value);
		
		outputKey.set(parser.getYear() + "," + parser.getMonth());
		
		// 만약 타입이 출발이면
		if(workType.equals("departure")) {
			// 출발 지연시간이 양수일 때
			if(parser.getDepartureDelayTime() > 0) {
				context.write(outputKey, outputValue);
			}
		}
		// 만약 타입이 도착이면
		if(workType.equals("arrival")) {
			// 도착 지연시간이 양수일 때
			if(parser.getArriveDelayTime() > 0) {
				context.write(outputKey, outputValue);
			}
		}
	}
}
