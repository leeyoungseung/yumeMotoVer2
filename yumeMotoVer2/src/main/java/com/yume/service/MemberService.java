package com.yume.service;

import java.util.List;

import com.yume.domain.*;

public interface MemberService {

	public int joinMember(MemberVO mvo) throws Exception;
	
	public MemberVO readMember(Integer m_num)throws Exception;
	
	public int updateMember(MemberVO mvo) throws Exception;
	
	public int deleteMember(Integer mb_no) throws Exception;
	
	public List<MemberVO> listMember() throws Exception;
}
