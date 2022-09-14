package org.conan.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

// p133 참조
@Data
public class SampleDTOList {
	private List<SampleDTO> sdList;
	public SampleDTOList() {
		sdList = new ArrayList<SampleDTO>();
	}
}
