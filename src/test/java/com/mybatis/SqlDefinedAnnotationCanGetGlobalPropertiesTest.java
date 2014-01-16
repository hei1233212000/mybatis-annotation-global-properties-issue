package com.mybatis;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.mybatis.data.DummyMapper;

public class SqlDefinedAnnotationCanGetGlobalPropertiesTest {
	private static final String MYBATIS_CONFIG = "mybatis-config.xml";
	private SqlSessionFactory sqlSessionFactory;

	@Before public void before() throws IOException {
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(MYBATIS_CONFIG));
	}

	@Test public void testIfSqlDefinedXmlCanGetGlobalProperties() throws IOException {
		try (SqlSession sqlSession = sqlSessionFactory.openSession();) {
			DummyMapper mapper = sqlSession.getMapper(DummyMapper.class);
			mapper.useSqlDefinedInXmltoCreateTable();
		}
	}

	@Test public void testIfSqlDefinedAnnotationCanGetGlobalProperties() throws IOException {
		try (SqlSession sqlSession = sqlSessionFactory.openSession();) {
			DummyMapper mapper = sqlSession.getMapper(DummyMapper.class);
			mapper.useSqlDefinedInAnnotationtoCreateTable();
		}
	}
}
