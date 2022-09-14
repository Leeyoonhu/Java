package org.conan.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;
@Component
@Data
public class Restaurant {
	@Setter(onMethod_= @Autowired) // chef 객체를 만들어서 set 방식으로 받아옴, outline에서 확인가능
	private Chef chef;	
//	Restaurant에서 chef를 고용할것이기때문에 
}
