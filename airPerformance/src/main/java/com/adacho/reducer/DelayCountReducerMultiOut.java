package com.adacho.reducer;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.output.MultipleOutputs;

public class DelayCountReducerMultiOut extends Reducer<Text, IntWritable, Text, IntWritable>{
   private IntWritable result = new IntWritable();
   private MultipleOutputs<Text, IntWritable> mos;
   private Text outputKey = new Text();
   
   @Override
   protected void setup(Reducer<Text, IntWritable, Text, IntWritable>.Context context)
         throws IOException, InterruptedException {
      // TODO Auto-generated method stub
      mos = new MultipleOutputs<Text, IntWritable>(context);
   }

   @Override
   protected void reduce(Text key, Iterable<IntWritable> values,
         Reducer<Text, IntWritable, Text, IntWritable>.Context context) throws IOException, InterruptedException {
      // TODO Auto-generated method stub
	   // 이전에 outputKey.set("D : " + parser.getYear() + "," + parser.getMonth()); 에서 ,를 넣었으므로 짤라서 구분
	   String[] columns = key.toString().split(",");
	   
	   outputKey.set(columns[1] + ',' + columns[2]);
	   int sum = 0;
	   for(IntWritable value: values) {
		   sum += value.get();
	   }
	   result.set(sum);
	   
	   if(columns[0].equals("D")) {
		   mos.write("departure", outputKey, result);
	   }
	   else {
		   mos.write("arrival", outputKey, result);
	   }
   }
	// reduce 객체가 종료될 때의 행할 것
	@Override
	protected void cleanup(Reducer<Text, IntWritable, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		// 사용한 mos를 클로즈 해줌 (메모리 릭 발생 방지)
		mos.close();
	}   
}