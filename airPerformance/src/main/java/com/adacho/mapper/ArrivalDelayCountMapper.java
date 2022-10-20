package com.adacho.mapper;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import com.adacho.common.AirlinePerformanceParser;

// 도착 지연을 구하는 MAPPER
public class ArrivalDelayCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
	// value 로 한 줄이 들어옴
	private final static IntWritable outputValue = new IntWritable(1);
	private Text outputKey = new Text();
	
	// MAPPER
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		// 들어온 한 줄을 AirlinePerformanceParser 객체로 parsing
		AirlinePerformanceParser parser = new AirlinePerformanceParser(value);
		
		// parser에서 년도를 가져오고, 그 값에 ','를 붙이고 월을 붙일 거임
		outputKey.set(parser.getYear() + "," + parser.getMonth());
		
		// 도착 지연이 양수일 경우에만 context에 적어줌
		if(parser.getArriveDelayTime() > 0) {
			context.write(outputKey, outputValue);
		}
	}
}
