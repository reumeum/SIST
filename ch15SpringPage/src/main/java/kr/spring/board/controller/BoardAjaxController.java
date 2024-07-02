package kr.spring.board.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.spring.board.service.BoardService;
import kr.spring.board.vo.BoardFavVO;
import kr.spring.board.vo.BoardVO;
import kr.spring.member.vo.MemberVO;
import kr.spring.util.FileUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class BoardAjaxController {
	@Autowired
	private BoardService boardService;
	/*===================================
	 * 			부모글 좋아요
	 *==================================*/
	//부모글 좋아요 읽기
	@GetMapping("/board/getFav")
	@ResponseBody
	public Map<String, Object> getFav(BoardFavVO fav, HttpSession session) {
		log.debug("<<게시판 좋아요 - BoardFavVO>> : " + fav);
		
		Map<String, Object> mapJson = new HashMap<String, Object>();
		
		MemberVO user = (MemberVO)session.getAttribute("user");
		if (user == null) {
			mapJson.put("status", "noFav");
		} else {
			//로그인된 회원번호 세팅
			fav.setMem_num(user.getMem_num());
			BoardFavVO boardFav = boardService.selectFav(fav);
			
			if (boardFav != null) {
				mapJson.put("status", "yesFav");
			} else {
				mapJson.put("status", "noFav");
			}
		}
		mapJson.put("count", boardService.selectFavCount(fav.getBoard_num()));
		
		return mapJson;
	}
	
	//부모글 좋아요 등록/삭제
	@PostMapping("/board/writeFav")
	@ResponseBody
	public Map<String, Object> writeFav(BoardFavVO fav, HttpSession session) {
		
		log.debug("<<게시판 좋아요 - 등록>> : " + fav);
		
		Map<String, Object> mapJson = new HashMap<String, Object>();
		
		MemberVO user = (MemberVO)session.getAttribute("user");
		if (user==null) {
			mapJson.put("result", "logout");
		} else {
			//로그인된 회원번호 세팅
			fav.setMem_num(user.getMem_num());
			
			BoardFavVO boardFav = boardService.selectFav(fav);
			if (boardFav != null) {
				//등록이 되어 있으면 삭제
				boardService.deleteFav(fav);
				mapJson.put("status", "noFav");
			} else {
				//등록
				boardService.insertFav(fav);
				mapJson.put("status", "yesFav");
			}
			
			mapJson.put("result", "success");
			mapJson.put("count", boardService.selectFavCount(fav.getBoard_num()));
		}
		
		return mapJson;
	}
	
	/*===================================
	 * 			부모글
	 *==================================*/
	//업로드 파일 삭제
	@PostMapping("/board/deleteFile")
	@ResponseBody
	public Map<String, String> processFile(long board_num, HttpSession session, HttpServletRequest request) {
		Map<String , String> mapJson = new HashMap<String, String>();
		MemberVO user = (MemberVO)session.getAttribute("user");
		
		if (user==null) {
			mapJson.put("result", "logout");
		} else {
			BoardVO db_board = boardService.selectBoard(board_num);
			//로그인한 회원번호와 작성자 회원번호 일치 여부 체크
			if (user.getMem_num() != db_board.getMem_num()) {
				//불일치
				mapJson.put("result", "wrongAccess");
			} else {
				//일치
				boardService.deleteFile(board_num);
				FileUtil.removeFile(request, db_board.getFilename());
				
				mapJson.put("result", "success");
			}
		}
		
		return mapJson;
	}
}
