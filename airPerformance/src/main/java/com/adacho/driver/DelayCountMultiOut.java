package com.adacho.driver;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.MultipleOutputs;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import com.adacho.mapper.DelayCountMapperMultiOut;
import com.adacho.reducer.DelayCountReducerMultiOut;

public class DelayCountMultiOut extends Configured implements Tool{
   public static void main(String[] args) throws Exception{
      int res = ToolRunner.run(new Configuration(), new DelayCountMultiOut(), args);
      System.out.println("MapReduce Result : " + res);
   }
   
   @Override
   public int run(String[] args) throws Exception {
      // TODO Auto-generated method stub
      String[] otherArgs = new GenericOptionsParser(getConf(), args).getRemainingArgs();
      if(otherArgs.length !=2) {
         System.err.println("Usage: DelayCountMultiOut <input> <output>");
         System.exit(1);
      }
      
      Job job = Job.getInstance(getConf(), "DelayCountMultiOut");
      
      job.setJarByClass(DelayCountMultiOut.class); //드라이브 클래스 저장
      job.setMapperClass(DelayCountMapperMultiOut.class); //메퍼클래스저장
      job.setReducerClass(DelayCountReducerMultiOut.class); //리듀스클래스저장
      
      job.setInputFormatClass(TextInputFormat.class); //두개중에 길이가 긴 것 임포트
      job.setOutputFormatClass(TextOutputFormat.class); //두개중에 길이가 긴 것 임포트
      
      job.setMapOutputKeyClass(Text.class);
      job.setMapOutputValueClass(IntWritable.class);
      
      FileInputFormat.addInputPath(job, new Path(otherArgs[0])); //여러개에 인풋데이타가 있으면 다 줄 수 있음
      FileOutputFormat.setOutputPath(job, new Path(otherArgs[1]));
      
      MultipleOutputs.addNamedOutput(job, "departure", TextOutputFormat.class, Text.class, IntWritable.class);
      MultipleOutputs.addNamedOutput(job, "arrival", TextOutputFormat.class, Text.class, IntWritable.class);
      job.waitForCompletion(true); //job이끝날때까지 기다리고있다가 동기방식으로
      
      return 0;
   }

}