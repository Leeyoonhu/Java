package com.adacho.reducer;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.output.MultipleOutputs;

import com.adacho.common.DateKey;

public class DelayCountReducerDateKey extends Reducer<DateKey, IntWritable, DateKey, IntWritable> {
	private IntWritable result = new IntWritable();
	private MultipleOutputs<DateKey, IntWritable> mos;
	private DateKey outputKey = new DateKey();
	
	@Override
	   protected void setup(Reducer<DateKey, IntWritable, DateKey, IntWritable>.Context context)
	         throws IOException, InterruptedException {
	      // TODO Auto-generated method stub
	      mos = new MultipleOutputs<DateKey, IntWritable>(context);
	}

	@Override
	protected void reduce(DateKey key, Iterable<IntWritable> values,
			Reducer<DateKey, IntWritable, DateKey, IntWritable>.Context context) throws IOException, InterruptedException {
		
		String[] columns = key.toString().split(",");
		int sum = 0;
		   
		// 현재 month 값을 저장
	    Integer bMonth = key.getMonth();
	    
	    // 출발일 경우
	    if(columns[0].equals("D")) {
	    	for(IntWritable value: values) {
	    		// 월이 바뀌면
			    if(bMonth != key.getMonth()) {
			    	result.set(sum);			    	
			    	// 년도의 마지막 2자리
			    	outputKey.setYear(key.getYear().substring(2));	
			    	outputKey.setMonth(bMonth);
			    	mos.write("departure", outputKey, result);
			    	// 다음 달 sum 처리
			    	sum = 0;
			    }
			    // 만약에 bMonth == key.getMonth()면
	    		sum += value.get();
	    		bMonth = key.getMonth();
		    }
	    	if(bMonth == key.getMonth()) {
	    		result.set(sum);
	    		outputKey.setYear(key.getYear().substring(2));	
		    	outputKey.setMonth(bMonth);
		    	mos.write("departure", outputKey, result);
	    	}
	    }
	    
	    // 도착일 경우
	    else {
	    	for(IntWritable value: values) {
	    		// 월이 바뀌면
			    if(bMonth != key.getMonth()) {
			    	result.set(sum);			    	
			    	// 년도의 마지막 2자리
			    	outputKey.setYear(key.getYear().substring(2));	
			    	outputKey.setMonth(bMonth);
			    	mos.write("arrival", outputKey, result);
			    	// 다음 달 sum 처리
			    	sum = 0;
			    }
			    // 만약에 bMonth == key.getMonth()면
	    		sum += value.get();
	    		bMonth = key.getMonth();
		    }
	    	if(bMonth == key.getMonth()) {
	    		result.set(sum);
	    		outputKey.setYear(key.getYear().substring(2));	
		    	outputKey.setMonth(bMonth);
		    	mos.write("arrival", outputKey, result);
	    	}
	    }
	}


	@Override
	protected void cleanup(Reducer<DateKey, IntWritable, DateKey, IntWritable>.Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		mos.close();
	}
	
	
}
