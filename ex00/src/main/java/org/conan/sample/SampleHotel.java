package org.conan.sample;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Component
@ToString
@Getter
@AllArgsConstructor	// or @RequiredArgsConstructor
// 모든 args로 생성자 생성
// p68 ~ 70
public class SampleHotel {
	@NonNull
	private Chef chef;
//	public SampleHotel(Chef chef) {
//		this.chef = chef;
//	}
}
