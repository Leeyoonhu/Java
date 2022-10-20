package com.adacho.mapper;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable>{
	// 처음에 가져올때 map으로 가져옴 (key - value)
	// (key)lineNumber == LongWritable 
	// (value) 한 줄 텍스트 == Text
	private final static IntWritable one = new IntWritable(1);
	
	private Text word = new Text();
	
	// context 는 하둡의 맵 리듀와 통신하기 위한 객체임 (얘를 이요해서 하둡의 맵 리듀스 시스템에 값을 넣어 줄 것임)
	
	// MAP
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		// value로 들어온 한 줄의 텍스트를 StringTokenizer 객체를 통해서 자를것임
		// 해당 객체는 디폴트로 스페이스로 짜름
		StringTokenizer strToken = new StringTokenizer(value.toString());
		while(strToken.hasMoreTokens()) {
			word.set(strToken.nextToken());
			context.write(word, one);
		}
	}
}
