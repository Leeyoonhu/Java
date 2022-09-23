package org.ai.controller;

import java.io.File;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.ai.domain.BoardVO;
import org.ai.service.BoardService;
import org.ai.service.CommentService;
import org.ai.service.MemberService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
public class BoardController {
	@Autowired
	BoardService service;
	@Autowired
	MemberService mService;
	@Autowired
	CommentService cService;
	
	// 년/월/일 폴더 (파일 path앞에 system time 의 y-M-d폴더 생성)
	private String getFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String str = sdf.format(date);
//		파일 구분자 사이에 - 추가
		return str.replace("-", File.separator);
	}
	
	@GetMapping("/main")
	public void getMain() {
		log.info("check main");
	}
	
	@GetMapping("/free")
	public void getFree(Model model, HttpSession session, RedirectAttributes rttr) {
		log.info("free.......");
		session.setAttribute("boardTitle", "free");
		model.addAttribute("bList", service.getList("free"));
		model.addAttribute("mList", mService.getList());
	}
	@GetMapping("/question")
	public void getQuestion(Model model, HttpSession session, RedirectAttributes rttr) {
		log.info("question");
		session.setAttribute("boardTitle", "question");
		model.addAttribute("bList", service.getList("question"));
		model.addAttribute("mList", mService.getList());
	}
	@GetMapping("/info")
	public void getInfo(Model model, HttpSession session, RedirectAttributes rttr) {
		log.info("info");
		session.setAttribute("boardTitle", "info");
		model.addAttribute("bList", service.getList("info"));
		model.addAttribute("mList", mService.getList());
	}
	@GetMapping("/screen")
	public void getScreen(Model model, HttpSession session, RedirectAttributes rttr) {
		log.info("screen............ ");
		session.setAttribute("boardTitle", "screen");
		model.addAttribute("bList", service.getList("screen"));
		model.addAttribute("mList", mService.getList());
	}
	@GetMapping("/myArticle")
	public void getMyArticle(Model model, String nickName) {
		model.addAttribute("bList", service.getMyArticle(nickName));
		model.addAttribute("mList", mService.getList());
	}
	
	@GetMapping("/calendar")
	public void getCalendar() {
		log.info("calendar");
	}
	
	@GetMapping("/notice")
	public void getNotice(Model model) {
		log.info("notice");
		model.addAttribute("bList", service.getNoticeList());
		model.addAttribute("mList", mService.getList());
	}
	@GetMapping("/current")
	public void getCurrentList(Model model) {
		log.info("current");
		model.addAttribute("bList", service.getCurrentList());
	}
	@GetMapping("/popular")
	public void getPopular(Model model) {
		log.info("popular");
		model.addAttribute("bList", service.getPopularList());
	}
	@GetMapping("/write")	// uploadForm역할 p494부터
	public void getBoardWrite(Model model) {
		model.addAttribute("mList", mService.getList());
		log.info("write");
	}
	// 글쓰기(write)에서 이미지 첨부(글쓰기 jsp에서 ajax로 보냄)
	@RequestMapping(value = "/uploadAjax", method = RequestMethod.POST)
	public String uploadAjax (@Param("writer") String writer, @Param("title") String title, @Param("content") String content, 
	MultipartFile uploadFile, @Param("boardTitle") String boardTitle, Model model, HttpSession session, RedirectAttributes rttr) {
		log.info("글쓰기 완료 버튼.. upload..(이미지있음)");
		BoardVO vo = new BoardVO();
		String imageFilePath = null;
		String imageFileName = null;
		File saveFile = null;
		// 업로드 파일이 있을 경우에만
		if(!uploadFile.isEmpty()) {
			// 업로드 폴더 위치
			String uploadFolder = "C:\\upload";	
			// 오늘날짜 폴더 없으면 추가
			File uploadPath = new File(uploadFolder, getFolder());
			// 업로드 폴더 위치에 오늘 날짜 yy-MM-dd 폴더 추가
			if(uploadPath.exists() == false) {
				uploadPath.mkdirs();
			}
			imageFilePath = getFolder() + "/";
			imageFilePath = imageFilePath.replace("\\", "/");
			log.info("이미지 경로 : " + imageFilePath);
			imageFileName = uploadFile.getOriginalFilename();
			saveFile = new File(uploadPath, imageFileName);
		}
		vo.setWriter(writer);
		vo.setTitle(title);
		vo.setContent(content);
		vo.setImageFilePath(imageFilePath);
		vo.setImageFileName(imageFileName);
		vo.setBoardTitle(boardTitle);
		log.info("업로드 파일 명 : " + imageFileName);
		// 경로에 파일 저장
		try {
			// 파일의 저장을 위해 transfreTo 사용
			if(!uploadFile.isEmpty()) {
				uploadFile.transferTo(saveFile);
			}
			// 저장후에 DB에 쓰기
			service.write(vo);
			// 다 쓰고나서 글썻던 게시판으로 보내기
			return "redirect:../board/"+boardTitle;
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.getMessage());
		}
		// 다 쓰고나서 글썻던 게시판으로 보내기
		return "redirect:../board/"+boardTitle;
	}
	
	@RequestMapping(value = "/uploadAjax2", method = RequestMethod.POST)
	public String uploadAjax2 (@Param("writer") String writer, @Param("title") String title, @Param("content") String content, 
	@Param("boardTitle") String boardTitle, Model model, HttpSession session, RedirectAttributes rttr) {
		log.info("글쓰기 완료 버튼.. upload..(이미지없음)");
		BoardVO vo = new BoardVO();
		String imageFilePath = null;
		String imageFileName = null;
		vo.setWriter(writer);
		vo.setTitle(title);
		vo.setContent(content);
		vo.setImageFilePath(imageFilePath);
		vo.setImageFileName(imageFileName);
		vo.setBoardTitle(boardTitle);
		service.write(vo);
		return "redirect:../board/"+boardTitle;
	}
	
	@GetMapping("/display")
	@ResponseBody
//	서버에 파일 있는걸 넣고 가져오기
	public ResponseEntity<byte[]>getFile(String fileName){
		log.info("fileName : " + fileName);
//		파일이 있는 경로
		File file = new File("c:/upload/" + fileName);
		log.info("file : " + file);
		ResponseEntity<byte[]> result = null;
		try {
			HttpHeaders header = new HttpHeaders();
			header.add("Content-Type", Files.probeContentType(file.toPath()));
			result = new ResponseEntity<byte[]>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return result;
	}
	
	@PostMapping("/search")
	public void search(@Param("title")String title, @Param("content")String content, Model model) {
		model.addAttribute("bList", service.search(title, content));
		model.addAttribute("mList", mService.getList());
	}
	
	@GetMapping("/view")
	public void getBoardView(@RequestParam("number") int number, Model model){
		log.info("getList > > > >" + number);
		service.plusView(number);
		model.addAttribute("bList", service.getBoardView(number));
		model.addAttribute("mList", mService.getList());
		model.addAttribute("cList", cService.getList());
	}
	
	@PostMapping("plusreco")
	public String plusReco(Integer number) {
		service.plusReco(number);
		return "redirect: ../board/view?number=" + number;
	}
	//======================================REMOVEME
	@GetMapping("/test")
	public void getTest() {
		log.info("check main");
	}
	@PostMapping("/delete")
	public String deleteBoard(@Param("number")Integer number, @Param("boardTitle")String boardTitle) {
		service.deleteBoard(number);
		return "redirect: ../board/"+boardTitle;
	}
	@GetMapping("/update")
	public void getUpdate(@Param("number")Integer number, Model model) {
		model.addAttribute("bList", service.getBoardView(number));
		model.addAttribute("mList", mService.getList());
	}
	
	// 글수정 에서 이미지 첨부했을 경우
		@RequestMapping(value = "/updateAjax", method = RequestMethod.POST)
		public String updateAjax (@Param("number") Integer number, @Param("title") String title, @Param("content") String content, 
		MultipartFile uploadFile, @Param("boardTitle") String boardTitle, Model model, HttpSession session, RedirectAttributes rttr) {
			log.info("글수정 완료 버튼.. upload..(이미지있음)");
			String imageFilePath = null;
			String imageFileName = null;
			File saveFile = null;
			if(!uploadFile.isEmpty()) {
				String uploadFolder = "C:\\upload";	
				File uploadPath = new File(uploadFolder, getFolder());
				if(uploadPath.exists() == false) {
					uploadPath.mkdirs();
				}
				imageFilePath = getFolder() + "/";
				imageFilePath = imageFilePath.replace("\\", "/");
				log.info("이미지 경로 : " + imageFilePath);
				imageFileName = uploadFile.getOriginalFilename();
				saveFile = new File(uploadPath, imageFileName);
			}
			log.info("수정된 파일 명 : " + imageFileName);
			try {
				if(!uploadFile.isEmpty()) {
					uploadFile.transferTo(saveFile);
				}
				service.update(number, title, content, imageFileName, imageFilePath);
				return "redirect:../board/"+boardTitle;
			} catch (Exception e) {
				// TODO: handle exception
				log.error(e.getMessage());
			}
			return "redirect:../board/"+boardTitle;
		}
		// 이미지 첨부x
		@RequestMapping(value = "/updateAjax2", method = RequestMethod.POST)
		public String updateAjax2 (@Param("number") Integer number, @Param("title") String title, @Param("content") String content, 
		@Param("boardTitle") String boardTitle, Model model, HttpSession session, RedirectAttributes rttr) {
			log.info("글수정 완료 버튼.. upload..(이미지없음)");
			service.update2(number, title, content);
			return "redirect:../board/"+boardTitle;
		}
	
}
