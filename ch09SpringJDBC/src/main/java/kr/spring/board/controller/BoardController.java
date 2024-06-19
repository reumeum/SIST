package kr.spring.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.board.vo.BoardVO;

@Controller
public class BoardController {
	//유효성체크를 위한 폼 초기화
	@ModelAttribute
	public BoardVO initCommand() {
		return new BoardVO();
	}
	
	//폼호출
	@GetMapping("/insert.do")
	public String form() {
		return "insertForm";
	}
	
	@RequestMapping("/list.do")
	public ModelAndView process() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("selectList");
		
		return mav;
	}
}
