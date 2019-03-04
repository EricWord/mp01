package com.xc.test;

import com.xc.bean.User;
import com.xc.mapper.EmployeeMapper;
import com.xc.mapper.UserMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName: TestLogic
 * @Description: 测试逻辑删除
 * @Author: Eric
 * @Date: 2019/3/4 0004
 * @Email: xiao_cui_vip@163.com
 */
public class TestLogic {
    private ApplicationContext iocContext = new ClassPathXmlApplicationContext("applicationContext.xml");

    UserMapper userMapper = iocContext.getBean("userMapper", UserMapper.class);
    @Test
    public void testLogicDelete(){
//        Integer num = userMapper.deleteById(1);
//        System.out.println(num);
        User user = userMapper.selectById(1);
        System.out.println(user);


    }

    @Test
    public void testMeta(){
        User user = new User();
//        user.setLogicFlag(1);
        user.setId(1);
        userMapper.updateById(user);

    }
}
