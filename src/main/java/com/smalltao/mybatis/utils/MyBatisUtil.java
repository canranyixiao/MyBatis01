package com.smalltao.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class MyBatisUtil {

    private static SqlSessionFactory sqlSessionFactory;

    static{
        //创建流
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader("mybatis.xml");

            //创建sqlsessionfactory
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //创建sqlsession
    public static SqlSession getSqlSession(){

        return sqlSessionFactory.openSession();
    }

}
