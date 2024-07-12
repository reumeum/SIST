package kr.spring.talk.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.spring.talk.dao.TalkMapper;
import kr.spring.talk.vo.TalkMemberVO;
import kr.spring.talk.vo.TalkRoomVO;
import kr.spring.talk.vo.TalkVO;

@Service
@Transactional
public class TalkServiceImpl implements TalkService {
	
	@Autowired
	TalkMapper talkMapper;

	@Override
	public List<TalkRoomVO> selectTalkRoomList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer selectRowCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertTalkRoom(TalkRoomVO talkRoomVO) {
		//기본키 생성
		talkRoomVO.setTalkroom_num(talkMapper.selectTalkRoomNum());
		//채팅방 생성
		talkMapper.insertTalkRoom(talkRoomVO);
		
		//채팅방 멤버 생성
		for (Long mem_num : talkRoomVO.getMembers()) {
			talkMapper.insertTalkRoomMember(talkRoomVO.getTalkroom_num(), talkRoomVO.getBasic_name(), mem_num);
		}
		
		//입장 메시지 처리
		//
		//
	}

	@Override
	public List<TalkMemberVO> selectTalkMember(Long talkroom_num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertTalk(TalkVO talkVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TalkVO> selectTalkDetail(Map<String, Long> map) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
