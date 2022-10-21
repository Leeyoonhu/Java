package com.adacho.common;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

// 두 개의 복합 키를 비교할 때 사용할 Comparator (비교기)
public class DateKeyComparator extends WritableComparator {
	
	protected DateKeyComparator() {
		super(DateKey.class, true);
	}
	
	@Override
	public int compare(WritableComparable a, WritableComparable b) {
		
		DateKey k1 = (DateKey)a;
		DateKey k2 = (DateKey)b;
		
		// 두 키의 년도 비교
		int cmp = k1.getYear().compareTo(k2.getYear());
		
		// 두 키의 년도가 같지 않으면
		if(cmp != 0) {
			// 누가 더 큰지 그냥 반환
			return cmp;
		}
		
		// 두 키의 년도가 같으면
		// 월 비교
		return k1.getMonth().compareTo(k2.getMonth());
	}
	
}
