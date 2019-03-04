package com.xc.test;

import com.baomidou.mybatisplus.plugins.Page;
import com.xc.bean.Employee;
import com.xc.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @ClassName: TestPage
 * @Description: 测试分页
 * @Author: Eric
 * @Date: 2019/3/4 0004
 * @Email: xiao_cui_vip@163.com
 */
public class TestPage {
    private ApplicationContext iocContext = new ClassPathXmlApplicationContext("applicationContext.xml");

    EmployeeMapper employeeMapper = iocContext.getBean("employeeMapper", EmployeeMapper.class);


    @Test
    public void testPagePlugin() {
        List<Employee> emps = employeeMapper.selectPage(new Page<Employee>(1, 2), null);
        for(Employee e:emps){
            System.out.println(e);
        }

    }
    @Test
    public void testPageInfo(){
        Page<Employee> page = new Page<>(1, 2);
        List<Employee> emps = employeeMapper.selectPage(page, null);
        //获取分页信息
        System.out.println("总条数："+page.getTotal());
        System.out.println("当前页码："+page.getCurrent());
        System.out.println("总页码："+page.getPages());
        System.out.println("每页显示的条数："+page.getSize());
        System.out.println("是否有上一页："+page.hasPrevious());
        System.out.println("是否有下一页："+page.hasNext());

    }

    @Test
    public void testDelPlugin(){
        employeeMapper.delete(null);

    }


}
