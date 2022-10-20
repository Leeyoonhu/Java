package com.adacho.reducer;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class DelayCountReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
	private IntWritable result = new IntWritable();
	
	@Override
	protected void reduce(Text key, Iterable<IntWritable> values,
			Reducer<Text, IntWritable, Text, IntWritable>.Context context) throws IOException, InterruptedException {
		
		int sum = 0;
		for(IntWritable value: values) {
			sum += value.get();
			// k-v 나눌 당시에 value는 1이 고정이였으므로 1회 순환해서 키가 있을 경우마다 sum에 1씩 더해줄 것임
		}
		// 결과로 보여줄 창에 key- value(sum) 형태로 set해서 단어가 몇번이나 출력되었는지 확인 가능하게 set
		result.set(sum);
		context.write(key, result);
	}
}
