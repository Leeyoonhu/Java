package com.adacho.reducer;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

// 맵에서 던져준 단어를 가지고 단어의 갯수로 출력할 것임
public class WordCountReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
	private IntWritable result = new IntWritable();
	
	// REDUCER
	@Override
	protected void reduce(Text key, Iterable<IntWritable> values,
			Reducer<Text, IntWritable, Text, IntWritable>.Context context) throws IOException, InterruptedException {
		// Iterable 로 선언한 이유??
		// key값은 동일한데 value 값이 여러개임 
		int sum = 0;
		// 따라서 동일한 key값인데 몇개나 동일한 키를 가졌는지 순환하며 파악 
		for(IntWritable value: values) {
			sum += value.get();
			// k-v 나눌 당시에 value는 1이 고정이였으므로 1회 순환해서 키가 있을 경우마다 sum에 1씩 더해줄 것임
		}
		// 결과로 보여줄 창에 key- value(sum) 형태로 set해서 단어가 몇번이나 출력되었는지 확인 가능하게 set
		result.set(sum);
		context.write(key, result);
	}
}
