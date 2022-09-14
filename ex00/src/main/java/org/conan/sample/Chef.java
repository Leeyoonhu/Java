package org.conan.sample;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
// @Component => 컨테이너(controller, repository)의 관리가 필요한 beans 임을 알려줌
// @Data => lombok의 관리를 받을것(getter/setter, toString() 만들어줌)
// 교재 55p 내용
public class Chef {
	
}
