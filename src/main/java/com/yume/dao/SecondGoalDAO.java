/**
 * This Interface is abstract DAO.
 * It define basic functions which are create, read, update, delete, list..
 */
package com.yume.dao;

import java.util.List;

import com.yume.domain.SecondGoalVO;

public interface SecondGoalDAO {

	public int createSecondGoal(SecondGoalVO sg) throws Exception;
	
	public SecondGoalVO readSecondGoal(Integer second_num) throws Exception;
	
	public int updateSecondGoal(SecondGoalVO sg) throws Exception;
	
	public int deleteSecondGoal(Integer second_num) throws Exception;
	
	public List<SecondGoalVO> listSecondGoal() throws Exception;
	
}
