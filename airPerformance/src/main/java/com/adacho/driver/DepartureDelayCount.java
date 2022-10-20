package com.adacho.driver;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

import com.adacho.mapper.DepartureDelayCountMapper;
import com.adacho.reducer.DelayCountReducer;


public class DepartureDelayCount {
	public static void main(String[] args) throws Exception {
		Configuration config = new Configuration();
		if(args.length != 2) {
			System.err.println("Usage: DepartureDelayCount <input> <output>");
			System.exit(1);
		}
		/* job ID는 yarn jar hadoop-3.2.4/share/hadoop/mapreduce/hadoop-mapreduce-examples-3.2.4.jar wordcount sample-input sample-output 실행시에
		나왔던 job ID */
		Job job = Job.getInstance(config, "DepartureDelayCount");
		
		// JAR - MAPPER - REDUCER
		// Jar 로 쓸 class 지정
		job.setJarByClass(DepartureDelayCount.class);
		// Mapper로 쓸 클래스 지정
		job.setMapperClass(DepartureDelayCountMapper.class);
		// Reducer로 쓸 클래스 지정
		job.setReducerClass(DelayCountReducer.class);
		
		// INPUT - OUTPUT
		// input 값 format class 지정(타입)
		job.setInputFormatClass(TextInputFormat.class);
		// output 값 format class 지정(타입)
		job.setOutputFormatClass(TextOutputFormat.class);
		
		// OUTPUT KEY_VALUE
		// output key 값 클래스 지정
		job.setMapOutputKeyClass(Text.class);
		// output value 값 클래스 지정
		job.setMapOutputValueClass(IntWritable.class);

		// FILE IN, OUTPUT FORMAT
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		// job이 끝날 때 까지 동기화를 기다림
		job.waitForCompletion(true);
	}
}
