package com.ezen.exam;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MainClass {

	public static void main(String[] args) {
	
		String resource = "com/ezen/exam/mybatis-config.xml";
		InputStream inputStream = null;
		SqlSession session = null;
		
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			System.out.println(sqlSessionFactory);
			
			session = sqlSessionFactory.openSession();
			System.out.println("session: " + session);
					
			BlogMapper2 mapper = session.getMapper(BlogMapper2.class);
			System.out.println("mapper: " + mapper);
			
//			-selectOne:
//			TestVO vo = mapper.selectOne(1);
//			System.out.println(vo);
			
//			-selectAllList:
//			List<TestVO> list = mapper.selectAllList();
//			for(TestVO vo : list)
//				System.out.println(vo);
			
//			-insertTest:
//			TestVO vo = new TestVO();
//			vo.setName("노예은");
//			vo.setPhone("010-1111-2222");
//			vo.setAddress("300호");
//			
//			mapper.insertTest(vo);
//			session.commit();
//			
//			List<TestVO> list = mapper.selectAllList();
//			for(TestVO vo2 : list)
//				System.out.println(vo2);
			
//			-updateTest:
//			TestVO vo = new TestVO();
//			vo.setName("노예은2");
//			vo.setPhone("010-1111-2222");
//			vo.setAddress("301호");
//			vo.setId(2);
//			
//			mapper.updateTest(vo);
//			session.commit();
//			
//			List<TestVO> list = mapper.selectAllList();
//			for(TestVO vo2 : list)
//				System.out.println(vo2);

			//-deleteTest:
			mapper.deleteTest(2);
			session.commit();
			
			List<TestVO> list = mapper.selectAllList();
			for(TestVO vo2 : list)
				System.out.println(vo2);

		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
