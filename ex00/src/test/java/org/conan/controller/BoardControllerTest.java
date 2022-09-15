package org.conan.controller;



import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@Log4j
public class BoardControllerTest {
	@Setter(onMethod_ = @Autowired)
	private WebApplicationContext ctx;
//	가짜 MVC mockMvc생성(아직 form을 안만들었으므로)
	private MockMvc mockMvc;
	
//	모든 Test전에 실행되는 메서드
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
		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/get")
				.param("bno", "2"))
				.andReturn().getModelAndView().getModelMap());
	}
	
	@Test
	public void testModify() throws Exception {
		String resultPage =
				mockMvc.perform(MockMvcRequestBuilders.post("/board/modify")
						.param("bno", "1")
						.param("title", "mock로 modify")
						.param("content", "mock로 modify")
						.param("writer", "modify")).andReturn().getModelAndView().getViewName();
		log.info(resultPage);
	}
	@Test
	public void testRemove() throws Exception {
		String resultPage = 
				mockMvc.perform(MockMvcRequestBuilders.post("/board/remove")
						.param("bno", "7")).andReturn().getModelAndView().getViewName();
		log.info(resultPage);
	}
}
