$(function() {
	let message_socket; //웹소켓 식별자
	
	/*----------------------------
	 *		채팅 회원 저장
	 *---------------------------*/
	let member_list = []; //채팅 회원을 저장하는 배열
	
	//채팅방 멤버를 저장하는 배열에 정보 세팅
	//채팅방 또는 채팅 페이지를 인식해서 채팅방 멤버를 초기 세팅
	if ($('#talkWrite').length>0) { //채팅방 생성 페이지 (jquery는 id로 검색해도 배열로 반환하기 때문에 length를 검사)
		member_list = [$('#user').attr('data-id')];
		console.log(member_list);
	} else if ($('#talkDetail').length>0) { //채팅 페이지
		connectWebSocket(); //웹소켓 생성
		member_list = $('#chat_member').text().split(',');
	}
	
	
	/*----------------------------
	 *		웹소켓 연결
	 *---------------------------*/
	function connectWebSocket() {
		
	}
	
	/*----------------------------
	 *		채팅방 생성
	 *---------------------------*/
	//회원 정보 검색
	$('#member_search').keyup(function() {
		if ($('#member_search').val().trim=='') {
			$('#search_area').empty();
			return;
		}
		//서버와 통신
		$.ajax({
			url: 'memberSearchAjax',
			type: 'get',
			data: {id:$('#member_search').val()},
			dataType: 'json',
			success: function(param) {
				if (param.result == 'logout') {
					$('#member_search').attr('disabled', true);
					$('#member_search').val('로그인 해야 회원 검색이 가능합니다');
				} else if (param.result == 'success') {
					$('#search_area').empty();
					$(param.member).each(function(index,item) {
						//채팅방 개설자의 아이디와 동일한 아이디와
						//이미 member_list에 저장된 아이디를 제외
						if (!member_list.includes(item.id)) {
							let output = '';
							output += `<li data-num="${item.mem_num}">`;
							output += item.id;
							output += '</li>';
							
							$('#search_area').append(output);
						}
					})
				} else {
					alert('회원 검색 오류 발생');
				}
			},
			error: function() {
				alert('네트워크 오류 발생');
			}
		});
		
	})
	//검색된 회원 선택하기
	$(document).on('click', '#search_area li', function() {
		let id = $(this).text(); //선택한 아이디
		let mem_num = $(this).attr('data-num'); //선택한 회원번호
		member_list.push(id);
		//선택한 id를 화면에 표시
		let choice_id = `<span class="member-span data-id="${id}">`;
		choice_id += `<input type="hidden" name="members" value="${mem_num}">`;
		choice_id += id + '<sup>&times;</sup></span>';
		$('#talk_member').append(choice_id);
		$('#member_search').val('');
		$('#search_area').empty(); //ul태그 초기화
		
		if ($('#name_checked').is(':checked')) { //채팅방 이름 자동 설정
			makeRoom_name();
		}
	})
	//선택한 채팅방 멤버 삭제하기
	$(document).on('click', '.member-span', function() {
		let id = $(this).attr('data-id');
		//채팅 멤버가 저장된 배열에서 삭제할 멤버의 id 제거
		member_list.splice(member_list.indexOf(id), 1);
		$(this).remove();
		
		if ($('#name_checked').is(':checked')) { //채팅방 이름 자동 설정
			makeRoom_name();
		}
		
		if ($('#talk_member span').length==0) {
			$('#name_span').text('');
			$('#basic_name').val('');
		}
	});
	
	//채팅방 이름 생성 방식 정하기(자동/수동)             
	$('#name_checked').click(function(){
		if($('#name_checked').is(':checked')){//채팅방 이름 자동 생성
			$('#basic_name').attr('type','hidden');
			if(member_list.length > 1){
				makeRoom_name();
			}
		}else{//채팅방 이름 수동 생성
			$('#basic_name').attr('type','text');
			$('#name_span').text(''); //채팅방 이름 표시 텍스트 초기화
		}
	});
	
    // 채팅방 이름 생성             
	function makeRoom_name(){
		let name = '';
		$.each(member_list,function(index,item){
			if(index>0) name += ',';
			name += item;
		});
		if(name.length>55){
			name = name.substring(0,55) + '...';
		}
		$('#basic_name').val(name);
		$('#name_span').text(name);
	}
	
	//채팅방 생성 전송
	$('#talk_form').submit(function(){
		if(member_list.length<=1){//이미 배열에 현재 로그인한 유저(채팅방 개설자)가 기본 등록되어 있어서 로그인한 유저 포함 최소 2명이 되어야 채팅 가능
			alert('채팅에 참여할 회원을 검색하세요!');
			$('#member_search').focus();
			return false;
		}
	});
	
	/*----------------------------
	 *		채팅하기
	 *---------------------------*/
});