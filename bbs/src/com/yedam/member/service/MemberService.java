package com.yedam.member.service;

import java.util.List;

import com.yedam.member.vo.MemberVO;

public interface MemberService {
	//전체조회, 한건조회, 입력, 수정, 삭제
	List<MemberVO> selectMemberList();
	MemberVO selectMember();
	public int insertMember(MemberVO vo);
	public int updateMember(MemberVO vo);
	public int deleteMember(MemberVO vo);
}
