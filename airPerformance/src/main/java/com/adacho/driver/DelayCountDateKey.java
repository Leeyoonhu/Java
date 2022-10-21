package com.adacho.driver;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.MultipleOutputs;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import com.adacho.common.DateKey;
import com.adacho.common.DateKeyComparator;
import com.adacho.common.GroupKeyComparator;
import com.adacho.common.GroupKeyPartitioner;
import com.adacho.mapper.DelayCountMapperDateKey;
import com.adacho.reducer.DelayCountReducerDateKey;

public class DelayCountDateKey extends Configured implements Tool  {
	public static void main(String[] args) throws Exception {
		// 기존의 yarn으로 jar를 parsing하는 명령어에서 wordType을 줄건데, 그 때 추가로 준 wordType 인자를 받기 위해서 선언
		int res = ToolRunner.run(new Configuration(), new DelayCountDateKey(), args);
		System.out.println("MAP-REDUCE RESULT : " + res);
	}
	
		// 여태 드라이버에서 설정했던 내용을 run method를 override 하여 설정
		@Override
		public int run(String[] args) throws Exception {
			String[] otherArgs = new GenericOptionsParser(getConf(), args).getRemainingArgs();
			// 사용자가 추가한 args를 제외한 기존의 args
			if(otherArgs.length != 2) {
				System.err.println("Usage: DelayCountDateKey <input> <output>");
				System.exit(1);
			}
			
			Job job = Job.getInstance(getConf(), "DelayCountDateKey");
			
			// JAR - MAPPER - REDUCER
			// Jar 로 쓸 class 지정
			job.setJarByClass(DelayCountDateKey.class);
			// Mapper로 쓸 클래스 지정
			job.setMapperClass(DelayCountMapperDateKey.class);
			// Reducer로 쓸 클래스 지정
			job.setReducerClass(DelayCountReducerDateKey.class);
			
			// INPUT - OUTPUT
			// input 값 format class 지정(타입)
			job.setInputFormatClass(TextInputFormat.class);
			// output 값 format class 지정(타입)
			job.setOutputFormatClass(TextOutputFormat.class);
			
			// OUTPUT KEY_VALUE
			// output key 값 클래스 지정
			job.setMapOutputKeyClass(DateKey.class);
			// output value 값 클래스 지정
			job.setMapOutputValueClass(IntWritable.class);

			// FILE IN, OUTPUT FORMAT
			FileInputFormat.addInputPath(job, new Path(otherArgs[0]));
			FileOutputFormat.setOutputPath(job, new Path(otherArgs[1]));
			
			// === 그루핑에 의해 추가된 코드 ===
			MultipleOutputs.addNamedOutput(job, "departure", TextOutputFormat.class, DateKey.class, IntWritable.class);
			MultipleOutputs.addNamedOutput(job, "arrival", TextOutputFormat.class, DateKey.class, IntWritable.class);
			
			job.setPartitionerClass(GroupKeyPartitioner.class);
			job.setGroupingComparatorClass(GroupKeyComparator.class);
			job.setSortComparatorClass(DateKeyComparator.class);
			// =======
			
			// job이 끝날 때 까지 동기화를 기다림
			job.waitForCompletion(true);
			
			return 0;
		}
}
