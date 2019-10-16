package org.zpp.mybatis;

import com.alibaba.fastjson.JSON;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.zpp.mybatis.component.UserService;
import org.zpp.mybatis.config.AppConfig;
import org.zpp.mybatis.mapper.UserMapper;
import org.zpp.mybatis.model.SysUser;

import java.io.InputStream;
import java.util.List;

/**
 *
 * {@link org.apache.ibatis.session.defaults.DefaultSqlSession}
 * {@link org.mybatis.spring.mapper.MapperFactoryBean}
 * {@link org.mybatis.spring.SqlSessionTemplate}
 *
 * @author zpp
 * @date 2019/10/11 10:08
 */
public class Test {

    public static void main(String[] args) throws Exception{
        scanTest();
    }

    /**
     * AppConfig：
     * @Configuration
     * @MapperScan("org.zpp.mybatis.mapper")
     */
    public static void springTest(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AppConfig.class);
        applicationContext.refresh();
        UserMapper userMapper = applicationContext.getBean(UserMapper.class);
        List<SysUser> list = userMapper.list();

        System.out.println(JSON.toJSONString(list));
    }

    /**
     * AppConfig：
     * @Configuration
     * @MapperScan("org.zpp.mybatis.mapper")
     *
     * @throws Exception
     */
    public static void mybatisTest() throws Exception{
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<SysUser> list = sqlSession.getMapper(UserMapper.class).list();

        System.out.println(JSON.toJSONString(list));
    }

    /**
     * AppConfig：
     * @Configuration
     * @ComponentScan("org.zpp")
     * @MapperScan("org.zpp.mybatis.mapper")
     * @Import(TestScanRegistrar.class)
     */
    public static void scanTest(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        System.out.println(applicationContext.getBean(UserService.class).getOrderService());

    }
}
