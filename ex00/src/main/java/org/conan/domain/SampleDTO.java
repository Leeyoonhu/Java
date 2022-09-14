package org.conan.domain;

import lombok.Data;

// controller의 param 수집 (request.getParameter()같은 역할)
@Data
// lombok이 getter/setter/toString() 다해줌
public class SampleDTO {
	private String name;
	private int age;
}
