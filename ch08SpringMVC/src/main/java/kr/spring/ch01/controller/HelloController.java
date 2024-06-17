package kr.spring.ch01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	//요청URL과 실행 메서드 연결
	@RequestMapping("/hello.do")
	public ModelAndView hello() {
		ModelAndView mav = new ModelAndView();
		//뷰 이름 지정
		mav.setViewName("hello"); //hello.jsp를 호출할 때 hello만 명시 -> servlet-context.xml의 ViewResolver 참조
																		// /WEB-INF/views/hello.jsp
		//뷰에서 사용할 데이터 세팅
		mav.addObject("greeting", "안녕하세요"); //request에 저장
		
		return mav;
	}
}
