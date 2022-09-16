package org.conan.controller;





import org.conan.domain.Ticket;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import com.google.gson.Gson;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@Log4j
public class SampleControllerTest {
	@Setter(onMethod_ = @Autowired)
	private WebApplicationContext ctx;
//	가짜 MVC mockMvc생성(아직 form을 안만들었으므로)
	private MockMvc mockMvc;
	
//	모든 Test전에 실행되는 메서드
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	@Test
	public void testList() throws Exception {
		log.info(
//				MockMvcRequestBuilders는 get 방식으로 호출
//				이후에 BoardController의 getList()를 통해 Model에 어떤 데이터가있는지 확인
			mockMvc.perform(MockMvcRequestBuilders.get("/board/list"))
			.andReturn()
			.getModelAndView()
			.getModelMap());
	}
	
	@Test
	public void testResister() throws Exception {
		String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
				.param("title", "mockMvc test from controller")
				.param("content", "mockMvc test from controller")
				.param("writer", "userTEST"))
				.andReturn().getModelAndView().getViewName();
//		post로 url호출한 임시 모델 form에 param k-v선언후, return
		log.info(resultPage);
	}
	
	@Test
	public void testGet() throws Exception {
		log.info(mockMvc.perform(MockMvcRequestBuilders
				.get("/board/get")
				.param("bno", "2"))
				.andReturn()
				.getModelAndView().getModelMap());
						
						
	}
	
	@Test
	public void testModify() throws Exception {
		
		String resultPage = mockMvc
				.perform(MockMvcRequestBuilders.post("/board/modify")
						.param("bno","1")
						.param("title", "수정된 테스트 새글 제목")
						.param("content", "수정된 테스트 새글 내용")
						.param("writer", "user00"))
				.andReturn().getModelAndView().getViewName();
		log.info(resultPage);
	}
	@Test
	public void testRemove() throws Exception {
		String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/remove")
				.param("bno", "4")).andReturn().getModelAndView().getViewName();
		log.info(resultPage);
	}
	@Test
	public void testConvert() throws Exception {
		Ticket ticket = new Ticket();
		ticket.setTno(123);
		ticket.setOwner("admin");
		ticket.setGrade("SSS");
		String jsonStr = new Gson().toJson(ticket);
		log.info(jsonStr);
//		mockmvc는 contype()을 이용해 전달하는 데이터가 무슨 타입인지 알려줄 수 있음
//		Gson lib는 Java 객체 >> JSON 변환
		mockMvc.perform(post("/rsample/ticket")
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonStr))
				.andExpect(status().is(200));
		
	}
}
