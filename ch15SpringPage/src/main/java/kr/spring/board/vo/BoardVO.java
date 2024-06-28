package kr.spring.board.vo;

import java.sql.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardVO {
	private long board_num;			//게시판 번호
	@NotBlank
	private String title;			//제목
	@NotBlank
	private String category;		//카테고리
	@NotEmpty
	private String content;			//내용
	private int hit;				//조회수
	private Date reg_date;			//작성일자
	private Date modify_date;		//수정일자
	private MultipartFile upload;	//파일
	private String filename;		//파일명
	private String ip;				//IP주소
	private long mem_num;			//작성자 회원번호
	
	private String id;				//아이디
	private String nick_name;		//닉네임
	
	private int re_cnt;				//댓글 개수
	private int fav_cnt;			//좋아요 개수
}
