/**
 * This Interface is abstract DAO.
 * It define basic functions which are create, read, update, delete, list..
 */
package com.yume.dao;

import java.util.List;

import com.yume.domain.MemberVO;

public interface MemberDAO {

	public int joinMember(MemberVO mvo) throws Exception;
	
	public MemberVO readMember(Integer m_num)throws Exception;
	
	public int updateMember(MemberVO mvo) throws Exception;
	
	public int deleteMember(Integer mb_no) throws Exception;
	
	public List<MemberVO> listMember() throws Exception;
	
}
