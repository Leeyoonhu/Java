package big_data.bit.ex08;

import java.util.Stack;

public class StackEx01 {
	// p443 예제 11-4 
	public static void main(String[] args) {
		// First-In-Last-Out or Last-In-First-Out 
		// Stack에 추가할때는 add가아닌 .push()함수, add를 사용할 수는 있음
		// Stack에서 값을 꺼낼때는 get이 아닌 .pop()함수 [값이 아예 꺼내짐], get을 사용할수 있으나 저장된 순으로 출력
		// Stack에서 Last에 있는 값이 무엇인지 살짝 보려면 .peek()함수
		Stack<String> st = new Stack<String>();
		st.push("사과");
		st.push("바나나");
		st.push("체리");
		// 이상태에서 맨 꼭대기(Last)의 값이 무엇인지?
		System.out.println("맨 꼭대기 : "+st.peek()); // 마지막에 값을 넣은 체리가 출력됨
		System.out.println("꺼낸 값 : "+st.pop()); // 꺼낸 값 확인
		System.out.println("= 남은 값 =");
		for(String s : st) {
			System.out.print(s + " ");
		}
		System.out.println();
		System.out.println(st.search("사과"));
		
	}
}
