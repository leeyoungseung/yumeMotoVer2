/**
 * This Interface is abstract DAO.
 * It define basic functions which are create, read, update, delete, list..
 */
package com.yume.dao;

import java.util.List;

import com.yume.domain.MainGoalVO;



public interface MainGoalDAO {

	public int createMainGoal(MainGoalVO mg) throws Exception;
	
	public MainGoalVO readMainGoal(Integer m_num) throws Exception;
	
	public int updateMainGoal(MainGoalVO mg) throws Exception;
	
	public int deleteMainGoal(Integer m_num) throws Exception;
	
	public List<MainGoalVO> listMainGoal() throws Exception;
	
}
