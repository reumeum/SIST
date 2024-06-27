package kr.spring.member.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.spring.member.service.MemberService;
import kr.spring.member.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MemberAjaxController {
	@Autowired
	private MemberService memberService;

	@GetMapping("/member/confirmId")
	@ResponseBody
	public Map<String, String> process(@RequestParam String id) {

		log.debug("<<아이디 중복 체크>> : " + id);

		Map<String, String> mapAjax = new HashMap<String, String>();

		MemberVO member = memberService.selectCheckMember(id);

		if (member != null) {
			// 아이디 중복
			mapAjax.put("result", "idDuplicated");
		} else {
			// 유효성체크보다 아이디중복체크가 먼저 일어나므로 여기서도 아이디 패턴 체크
			if (!Pattern.matches("^[A-Za-z0-9]{4,12}$", id)) {
				// 패턴 불일치
				mapAjax.put("result", "notMatchPattern");
			} else {
				// 패턴이 일치하면서 아이디 미중복
				mapAjax.put("result", "idNotFound");
			}
		}

		return mapAjax;
	}

	// 프로필 사진 업로드
	@PostMapping("/member/updateMyPhoto")
	@ResponseBody
	public Map<String, String> processProfile(MemberVO memberVO, HttpSession session) { // upload라는 이름으로 전송된 파일이
																						// setUpload를 호출해서 memberVO에 저장됨
		// ajax 통신이기 때문에 인터셉터를 쓰면 안됨(로그인 화면이 중간에 보여질 수 없음)
		Map<String, String> mapAjax = new HashMap<String, String>();
		MemberVO user = (MemberVO) session.getAttribute("user");
		if (user == null) {
			mapAjax.put("result", "logout");
		} else {
			memberVO.setMem_num(user.getMem_num());
			memberService.updateProfile(memberVO);
			
			mapAjax.put("result", "success");
		}
		
		return mapAjax;
	}
}
