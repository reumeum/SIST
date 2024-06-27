package kr.spring.member.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.spring.member.vo.MemberVO;

@Mapper
public interface MemberMapper {
	// 회원관리 - 일반회원
	@Select("SELECT spmember_seq.nextval FROM dual")
	public Long selectMem_num(); // 시퀀스 만들어서 Long 타입으로 반환

	@Insert("INSERT INTO spmember(mem_num,id,nick_name) VALUES(#{mem_num},#{id},#{nick_name})")
	public void insertMember(MemberVO member);

	public void insertMember_detail(MemberVO member);

	public MemberVO selectCheckMember(String id);

	@Select("SELECT * FROM spmember JOIN spmember_detail USING(mem_num) WHERE mem_num=#{mem_num}")
	public MemberVO selectMember(Long mem_num);

	@Update("UPDATE spmember SET nick_name=#{nick_name} WHERE mem_num=#{mem_num}")
	public void updateMember(MemberVO member);

	public void updateMember_detail(MemberVO member);

	@Update("UPDATE spmember_detail SET passwd=#{passwd} WHERE mem_num=#{mem_num}")
	public void updatePassword(MemberVO member);

	public void deleteMember(Long mem_num);

	public void deleteMember_detail(Long mem_num);

	// 자동 로그인
	public void updateAu_id(String au_id, Long mem_num);

	public void selectAu_id(String au_id);

	public void deleteAu_id(Long mem_num);

	// 비밀번호 찾기
	public void updateRandomPassword(MemberVO member);

	// 프로필 이미지 업데이트
	@Update("UPDATE spmember_detail SET photo=#{photo}, photo_name=#{photo_name} WHERE mem_num=${mem_num}")
	public void updateProfile(MemberVO member);
}
