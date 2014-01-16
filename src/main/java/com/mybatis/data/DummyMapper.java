package com.mybatis.data;

import org.apache.ibatis.annotations.Update;

public interface DummyMapper {
	@Update("CREATE TABLE IF NOT EXISTS ${schema}.dummy (id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY, name VARCHAR(100))")
	void useSqlDefinedInAnnotationtoCreateTable();

	void useSqlDefinedInXmltoCreateTable();
}
