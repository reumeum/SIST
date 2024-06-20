package kr.spring.board.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.board.service.BoardService;
import kr.spring.board.vo.BoardVO;
import kr.spring.util.PagingUtil;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;

	// 로그 처리 (로그 대상 지정)
	private static final Logger log = LoggerFactory.getLogger(BoardController.class);

	/*
	 * 로그 레벨 FATAL : 가장 심각한 오류 ERROR : 일반적인 오류 ------------------------- 프로그램 동작이 안됨
	 * WARN : 주의를 요하는 경우 INFO : 런타임시 관심있는 경우 DEBUG : 시스템 흐름과 관련된 상세 정보 TRACE : 가장
	 * 상세한 정보
	 */

	// 유효성체크를 위한 폼 초기화
	@ModelAttribute
	public BoardVO initCommand() {
		return new BoardVO();
	}

	// 폼호출
	@GetMapping("/insert.do")
	public String form() {
		return "insertForm";
	}

	// 전송된 데이터 처리
	@PostMapping("/insert.do")
	public String submit(@Valid BoardVO vo, BindingResult result) {
		log.debug("<<BoardVO>>😍😍 : " + vo);

		// 유효성 체크 결과 오류가 있으면 폼을 호출
		if (result.hasErrors()) {
			return form();
		}

		// 글 등록
		boardService.insertBoard(vo);
		return "redirect:/list.do";
	}

	//목록
	@RequestMapping("/list.do")
	public ModelAndView process(@RequestParam(value = "pageNum", defaultValue = "1") int currentPage) {
		
		int count = boardService.getBoardCount();
		log.debug("<<count>>😍😍 : " + count);
		
		//페이지 처리
		PagingUtil page = new PagingUtil(currentPage, count, 20, 10, "list.do");
		
		//목록 호출
		List<BoardVO> list = null;
		if (count > 0) {
			list = boardService.getBoardList(page.getStartRow(), page.getEndRow());
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("selectList");
		mav.addObject("count", count);
		mav.addObject("list", list);
		mav.addObject("page", page.getPage());

		return mav;
	}
	
	//상세 페이지
	@RequestMapping("/detail.do")
	public ModelAndView detail(int num) {
		log.debug("<<num>>😍😍 : " + num);
		BoardVO board = boardService.getBoard(num);
		//						뷰 이름			속성명 	속성값
		return new ModelAndView("selectDetail", "board", board);
	}
	
	//수정 폼
	@GetMapping("/update.do")
	public String formUpdate(int num, Model model) {
		model.addAttribute("boardVO", boardService.getBoard(num));
		
		return "updateForm";
	}
	
	//전송된 데이터 처리
	@PostMapping("/update.do")
	public String submitUpdate(@Valid BoardVO vo, BindingResult result) {
		log.debug("<<BoardVO>>😍😍 : " + vo);
		
		//유효성 체크 결과 오류가 있으면 폼을 호출
		if (result.hasErrors()) {
			return "updateForm"; //메서드가 아닌 jsp 파일 호출. formUpdate() 메서드는 인자 두개를 받기 때문에 복잡함.
		}
		
		//DB에 저장된 비밀번호 구하기
		BoardVO db_board = boardService.getBoard(vo.getNum());
		//비밀번호 일치여부 체크
		if (!db_board.getPasswd().equals(vo.getPasswd())) {
			result.rejectValue("passwd", "invalidPassword"); //필드가 있으면 rejectValue 사용
			return "updateForm";
		}
		
		//글 수정
		boardService.updateBoard(vo);
		
		return "redirect:/list.do";
	}
	
	//글 삭제 폼 호출
	//유효성 체크를 위해서는 자바빈에 담아서 처리해야함
	@GetMapping("delete.do")
	public String formDelete(BoardVO vo) {
		return "deleteForm";
	}
	
	//전송된 데이터 처리
	@PostMapping("/delete.do")
	public String submitDelete(@Valid BoardVO vo, BindingResult result) {
		log.debug("<<BoardVO>> : " + vo);
		
		//비밀번호만 유효성 체크 결과 오류가 있으면 폼 호출
		if (result.hasFieldErrors("passwd")) {
			return "deleteForm";
		}
		
		//DB에 저장된 비밀번호 구하기
		BoardVO db_board = boardService.getBoard(vo.getNum());
		
		if (!db_board.getPasswd().equals(vo.getPasswd())) {
			result.rejectValue("passwd", "invalidPassword");
			return "deleteForm";
		}
		
		//글 삭제
		boardService.deleteBoard(vo.getNum());
		
		return "redirect:/list.do";
	}
	
}
