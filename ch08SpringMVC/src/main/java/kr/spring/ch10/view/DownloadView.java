package kr.spring.ch10.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

public class DownloadView extends AbstractView {

	public DownloadView() {
		setContentType("application/download;charset=utf-8");
	}

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 다운로드하는 파일의 경로 정보가 저장된 File 객체 반환
		File file = (File) model.get("downloadFile");

		// 컨텐트 타입 지정 -> application/download이기 때문에 뷰어형태가 아니라 무조건 다운로드 처리
		response.setContentType("application/download;charset=utf-8");
		// 컨텐트의 용량 지정
		response.setContentLength((int) file.length());
		// 파일명 구하기
		String fileName = new String(file.getName().getBytes("utf-8"), "iso-8859-1");

		// HTTP 응답 메시지 헤더 세팅
		response.setHeader("Content-Disposition", "attachment;filename=\""+ fileName +"\";");
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		//파일 쓰기
		OutputStream out = response.getOutputStream();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file); //파일 읽기
			//읽은 정보를 쓰기 정보로 변환하는 기능을 제공하는 스프링 유틸리티 메서드
			FileCopyUtils.copy(fis, out);
		} finally {
			if (fis != null) try {fis.close();} catch (IOException e) {}
		}
		
		out.flush(); //파일 전송
	}

}
