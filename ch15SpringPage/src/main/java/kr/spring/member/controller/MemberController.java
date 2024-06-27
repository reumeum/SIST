package kr.spring.member.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import kr.spring.member.service.MemberService;
import kr.spring.member.vo.MemberVO;
import kr.spring.util.AuthCheckException;
import kr.spring.util.CaptchaUtil;
import kr.spring.util.FileUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;

	/*
	 * =========================== 회원가입 ============================
	 */
	// 자바빈(VO) 초기화
	@ModelAttribute
	public MemberVO initCommand() {
		return new MemberVO();
	}

	// 회원가입 폼 호출
	@GetMapping("/member/registerUser")
	public String form() {
		return "memberRegister"; // Tiles 설정명
	}

	// 전송된 데이터 처리(회원가입)
	@PostMapping("/member/registerUser")
	public String submit(@Valid MemberVO memberVO, BindingResult result, Model model, HttpServletRequest request) {
		log.debug("<<회원가입>> : " + memberVO);

		// 유효성 체크 결과 오류가 있으면 폼 호출
		if (result.hasErrors()) {
			return form();
		}
		// 회원 가입
		memberService.insertMember(memberVO);

		// UI 메시지 처리
		model.addAttribute("accessTitle", "회원 가입");
		model.addAttribute("accessMsg", "회원 가입이 완료되었습니다.");
		model.addAttribute("accessBtn", "홈으로");
		model.addAttribute("accessUrl", request.getContextPath() + "/main/main");

		return "common/resultView"; // common 폴더의 resultView.jsp 파일 호출
	}

	/*
	 * =========================== 로그인 ============================
	 */
	// 로그인 폼 호출
	@GetMapping("/member/login")
	public String formLogin() {
		return "memberLogin"; // Tiles 설정명
	}

	// 로그인 폼에서 전송된 데이터 처리
	@PostMapping("/member/login")
	public String login(@Valid MemberVO memberVO, BindingResult result, HttpSession session,
			HttpServletResponse response) throws Exception {

		log.debug("<<회원 로그인>> : " + memberVO);

		// 유효성 체크 결과 오류가 있으면 폼 호출
		// id와 passwd 필드만 체크
		if (result.hasFieldErrors("id") || result.hasFieldErrors("passwd")) {
			return formLogin();
		}

		// 로그인 체크(id, 비밀번호 일치 여부 체크)
		MemberVO member = null;
		try {
			member = memberService.selectCheckMember(memberVO.getId());

			boolean check = false;
			if (member != null) {
				// 비밀번호 일치 여부 체크
				check = member.isCheckedPassword(memberVO.getPasswd());
			}

			if (check) { // 인증 성공
				// =====TODO 자동로그인 체크 시작====//
				// =====TODO 자동로그인 체크 끝====//

				// 인증성공, 로그인 처리
				session.setAttribute("user", member);

				log.debug("<<인증 성공>>");
				log.debug("<<id>> : " + member.getId());
				log.debug("<<auth>> : " + member.getAuth());
				log.debug("<<au_id>> : " + member.getAu_id());

				if (member.getAuth() == 9) { // 관리자
					return "redirect:/main/admin";
				} else {
					return "redirect:/main/main";
				}
			}

			// 인증 실패시 예외 던지기
			throw new AuthCheckException();
		} catch (AuthCheckException e) {
			// 인증 실패로 로그인 폼 호출
			if (member != null && member.getAuth() == 1) { // 정지회원 메시지 표시
				result.reject("noAuthority");
			} else {
				result.reject("invalidIdOrPassword");
			}
			log.debug("<<인증 실패>>");

			return formLogin();
		}
	}

	@GetMapping("/member/logout")
	public String processLogout(HttpSession session) {
		// 로그아웃
		session.invalidate();

		// =====TODO 자동로그인 체크 시작====//
		// =====TODO 자동로그인 체크 끝====//

		return "redirect:/main/main";
	}

	/*
	 * =========================== 마이페이지 ============================
	 */

	// 마이페이지 호출
	@GetMapping("/member/myPage")
	public String process(HttpSession session, Model model) {
		// 세션에 저장된 정보
		MemberVO user = (MemberVO) session.getAttribute("user");

		// 회원정보 구하기
		MemberVO member = memberService.selectMember(user.getMem_num());
		log.debug("<<MY페이지>> : " + member);

		model.addAttribute("member", member);

		return "myPage"; // Tiles 설정명
	}

	/*
	 * =========================== 회원정보 수정 ============================
	 */

	// 수정 폼 호출
	@GetMapping("/member/update")
	public String formUpdate(HttpSession session, Model model) {
		MemberVO user = (MemberVO) session.getAttribute("user");
		MemberVO memberVO = memberService.selectMember(user.getMem_num());
		model.addAttribute("memberVO", memberVO);

		return "memberModify";
	}

	// 수정폼에서 전송된 데이터 처리
	@PostMapping("/member/update")
	public String submitUpdate(@Valid MemberVO memberVO, BindingResult result, HttpSession session) {

		log.debug("<<회원정보 수정>> : " + memberVO);

		// 유효성 체크 결과 오류가 있으면 폼 호출
		if (result.hasErrors()) {
			return "memberModify";
		}

		MemberVO user = (MemberVO) session.getAttribute("user");
		memberVO.setMem_num(user.getMem_num());

		// 회원정보 수정
		memberService.updateMember(memberVO);

		// 세션에 저장된 정보 변경
		user.setNick_name(memberVO.getNick_name());
		user.setEmail(memberVO.getEmail());

		return "redirect:/member/myPage";
	}

	/*
	 * =========================== 프로필 사진 출력 ============================
	 */

	// 프로필 사진 출력(로그인 전용)
	@GetMapping("/member/photoView")
	public String getProfile(HttpSession session, HttpServletRequest request, Model model) {

		MemberVO user = (MemberVO) session.getAttribute("user");
		log.debug("<<프로필 사진 출력>> : " + user);
		if (user == null) { // 로그인이 되지 않은 경우
			getBasicProfileImage(request, model);
		} else { // 로그인이 된 경우
			MemberVO memberVO = memberService.selectMember(user.getMem_num());
			viewProfile(memberVO, request, model);
		}

		return "imageView"; // 컨테이너에 저장된 클래스명
	}

	// 프로필 사진 처리를 위한 공통 코드
	public void viewProfile(MemberVO memberVO, HttpServletRequest request, Model model) {
		if (memberVO == null || memberVO.getPhoto_name() == null) {
			// DB에 저장된 프로필 이미지가 없기 때문에 기본 이미지 호출
			getBasicProfileImage(request, model);
		} else {
			// 업로드한 프로필 이미지 읽기
			model.addAttribute("imageFile", memberVO.getPhoto());
			model.addAttribute("filename", memberVO.getPhoto_name());
		}
	}

	// 기본 이미지 읽기
	public void getBasicProfileImage(HttpServletRequest request, Model model) {
		byte[] readbyte = FileUtil.getBytes(request.getServletContext().getRealPath("/image_bundle/face.png")); // 절대경로
																												// 구하기
		model.addAttribute("imageFile", readbyte);
		model.addAttribute("filename", "face.png"); // 원래 파일명
	}

	/*
	 * =========================== 비밀번호 변경 ============================
	 */

	// 비밀번호 변경 폼 호출
	@GetMapping("/member/changePassword")
	public String formChangePassword() {
		return "memberChangePassword";
	}
	
	// 비밀번호 변경 폼에서 전송된 데이터 처리

	
	/*
	 * =========================== 네이버 캡챠 API 사용 ============================
	 */
	@GetMapping("/member/getCaptcha")
	public String getCaptcha (Model model, HttpSession session) {
		String clientId = "oo3bQbhPLdQmaNbXM4NU";
		String clientSecret = "LbvyBC82c6";
		
		String code = "0"; //키 발급시 0, 캡챠 이미지 비교시 1로 세팅
		String key_apiURL = "https://openapi.naver.com/v1/captcha/nkey?code=" + code;
		
		Map<String, String> requestHeaders = new HashMap<String, String>();
		requestHeaders.put("X-Naver-Client-Id", clientId);
		requestHeaders.put("X-Naver-Client-Secret", clientSecret);
		String responseBody = CaptchaUtil.get(key_apiURL, requestHeaders);
		
		log.debug("<<responseBody>> : " + responseBody);
		JSONObject jObject = new JSONObject(responseBody);
		try {
			// https://openapi.naver.com/v1/captcha/nkey 호출로 받은 키값
			String key = jObject.getString("key");
			session.setAttribute("captcha_key", key);
			
			String apiURL = "https://openapi.naver.com/v1/captcha/ncaptcha.bin?key=" + key;
			
			
			Map<String, String> requestHeaders2 = new HashMap<String, String>();
			requestHeaders2.put("X-Naver-Client-Id", clientId);
			requestHeaders2.put("X-Naver-Client-Secret", clientSecret);
			
			byte[] response_byte = CaptchaUtil.getCaptchaImage(apiURL, requestHeaders2);
			
			model.addAttribute("imageFile", response_byte);
			model.addAttribute("filename", "captcha.jpg");
			
		} catch (Exception e) {
			log.error(e.toString());
		}
		
		return "imageView";
	}
}
