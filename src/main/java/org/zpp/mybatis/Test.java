package org.zpp.mybatis;

import com.alibaba.fastjson.JSON;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.zpp.mybatis.config.AppConfig;
import org.zpp.mybatis.mapper.UserMapper;
import org.zpp.mybatis.model.SysUser;

import java.io.InputStream;
import java.util.List;

/**
 * @author zpp
 * @date 2019/10/11 10:08
 */
public class Test {

    public static void main(String[] args) throws Exception{
        mybatisTest();
    }

    public static void springTest(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AppConfig.class);
        applicationContext.refresh();
        UserMapper userMapper = applicationContext.getBean(UserMapper.class);
        List<SysUser> list = userMapper.list();

        System.out.println(JSON.toJSONString(list));
    }

    public static void mybatisTest() throws Exception{
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<SysUser> list = sqlSession.getMapper(UserMapper.class).list();

        System.out.println(JSON.toJSONString(list));
    }
}
