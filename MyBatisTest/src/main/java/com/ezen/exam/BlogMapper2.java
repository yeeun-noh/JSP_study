package com.ezen.exam;

import java.util.List;


public interface BlogMapper2 {

	public TestVO selectOne(int id);
	
	public List<TestVO> selectAllList();
	
	public int insertTest(TestVO vo);
	
	public int updateTest(TestVO vo);
	
	public int deleteTest(int id);
}
