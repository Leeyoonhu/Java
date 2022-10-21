package com.adacho.common;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Partitioner;

// 그룹핑 키를 파티녀서할 GroupKeyPartitioner 객체
public class GroupKeyPartitioner extends Partitioner<DateKey, IntWritable> {

	@Override
	public int getPartition(DateKey key, IntWritable value, int numPartitions) {
		// numPartition의 수만큼 골고루 분산
		int hash = key.getYear().hashCode();
		int partition = hash % numPartitions;
		return partition;
	}	
}
