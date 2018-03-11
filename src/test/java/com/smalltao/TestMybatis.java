package com.smalltao;

import com.smalltao.mybatis.model.User;
import com.smalltao.mybatis.utils.MyBatisUtil;
import com.sun.org.apache.xml.internal.security.Init;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class TestMybatis {

    private  SqlSession sqlSession;

    @Before
    public void init(){

        sqlSession = MyBatisUtil.getSqlSession();


    }



    @Test
    public void testAddUser() throws IOException {
        User user = new User();

        user.setUsername("佳哥");
        user.setBirthday("0926");
        user.setAddress("吉安");

        System.out.println("之前的user"+user);

        //执行增加操作
        int insert = sqlSession.insert("User.addUser", user);

        System.out.println("之后的user"+user+"==========");

    }

    @Test
    public void updateUser(){

        User user = new User();
        user.setId(28);
        user.setUsername("小小小2222");


        sqlSession.update("User.updateUser",user);
    }


@Test
public void deleteUser(){
     sqlSession.delete("User.deleteUserById",28);
}

@Test
public void findAll(){
    List<Object> users = sqlSession.selectList("User.findAll");
    for (Object user : users) {
        System.out.println(user);
    }

}

@Test
public void findUserById(){
    User user = sqlSession.selectOne("User.findUserById", 29);

    System.out.println(user);

}


    @After
    public void destory(){

        //提交事务
        sqlSession.commit();

        //关闭资源
        sqlSession.close();
    }


}
