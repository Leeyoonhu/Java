package com.adacho.mapper;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import com.adacho.common.AirlinePerformanceParser;
import com.adacho.counter.DelayCounter;

public class DelayCountMapperMultiOut extends Mapper<LongWritable, Text, Text, IntWritable>{
   private final static IntWritable outputValue = new IntWritable(1);
   private Text outputKey = new Text();
   //workType은 안쓸꺼임 둘다 구할거라서
   
   @Override
   protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
         throws IOException, InterruptedException {
      // TODO Auto-generated method stub
      AirlinePerformanceParser parser = new AirlinePerformanceParser(value);

      
      if (parser.isDepartureDelayAvailable()) {
         if (parser.getDepartureDelayTime() > 0) {// 도착딜레이시간이양수면 -> 지연상황
            outputKey.set("D," + parser.getYear() + "," + parser.getMonth());
            context.write(outputKey, outputValue);
         } else if (parser.getDepartureDelayTime() == 0) {// 예정시간과 같은 정시에도착
            context.getCounter(DelayCounter.scheduled_departure).increment(1);
         } else if (parser.getDepartureDelayTime() < 0) {// 정시보다도 빨리도착
            context.getCounter(DelayCounter.early_departure).increment(1);
         }
      } else {// 도착 지연시간이 존재하지 않는다면 (데이터가 누락됬다면?)
         context.getCounter(DelayCounter.not_available_departure).increment(1);
      }
      
      
      if (parser.isArriveDelayAvailable()) {
         if (parser.getArriveDelayTime() > 0) { // 도착딜레이시간이양수면 -> 지연상황
            outputKey.set("A," + parser.getYear() + "," + parser.getMonth());
            context.write(outputKey, outputValue);
         } else if (parser.getArriveDelayTime() == 0) { // 예정시간과 같은 정시에도착
            context.getCounter(DelayCounter.scheduled_arrival).increment(1);
         } else if (parser.getArriveDelayTime() < 0) {// 정시보다도 빨리도착
            context.getCounter(DelayCounter.early_arrival).increment(1);
         }
      } else {// 도착 지연시간이 존재하지 않는다면 (데이터가 누락됬다면?)
         context.getCounter(DelayCounter.not_available_arrival).increment(1);
      }
      
   }

}
