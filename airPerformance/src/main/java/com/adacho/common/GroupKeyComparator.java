package com.adacho.common;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class GroupKeyComparator extends WritableComparator {
	protected GroupKeyComparator() {
		super(DateKey.class, true);
	}
	
	@Override
	public int compare(WritableComparable a, WritableComparable b) {
	      // TODO Auto-generated method stub
	      DateKey k1 = (DateKey)a;
	      DateKey k2 = (DateKey)b;
	      return k1.getYear().compareTo(k2.getYear()); //년도만비교
	}
}
