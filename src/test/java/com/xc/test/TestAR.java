package com.xc.test;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.xc.bean.Employee;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sun.management.snmp.jvminstr.JvmMemMgrPoolRelEntryImpl;

import java.util.List;

/**
 * @ClassName: TestAR
 * @Description: 测试活动记录
 * @Author: Eric
 * @Date: 2019/3/4 0004
 * @Email: xiao_cui_vip@163.com
 */
public class TestAR {
    private ApplicationContext iocContext = new ClassPathXmlApplicationContext("applicationContext.xml");

    @Test
    public void testInsert() {
        Employee emp = new Employee();
        emp.setLastName("王者荣耀");
        emp.setAge(33);
        emp.setEmail("wangzhe@163.com");
        emp.setGender(0);

        boolean res = emp.insert();
        System.out.println(res);
    }

    @Test
    public void testUpdateById() {
        Employee emp = new Employee();
        emp.setLastName("吃鸡");
        emp.setId(30);
        emp.setAge(32);
        emp.setEmail("chiji@163.com");
        emp.setGender(0);
        boolean b = emp.updateById();
        System.out.println(b);
    }

    @Test
    public void testSelectById() {
        Employee emp = new Employee();
//        Employee employee = emp.selectById(30);
        emp.setId(30);
        Employee employee = emp.selectById();
        System.out.println(employee);
    }

    @Test
    public void testSelectAll() {
        Employee emp = new Employee();
        List<Employee> employees = emp.selectAll();
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    @Test
    public void testSelectEntityWrapper() {
        Employee emp = new Employee();
//        List<Employee> employees = emp.selectList(new EntityWrapper().like("last_name", "yuebuqun"));
//        for (Employee employee : employees) {
//            System.out.println(employee);
//        }

        int num = emp.selectCount(null);
        System.out.println(num);

    }

    @Test
    public void testDeleteById() {
        Employee emp = new Employee();
        boolean b = emp.deleteById(27);
        System.out.println(b);

    }

    @Test
    public void testDeleteWrapper() {
        Employee emp = new Employee();
        boolean b = emp.delete(new EntityWrapper().eq("last_name", "yuebuqun18"));
        System.out.println(b);

    }
    @Test
    public void testSelectPage() {
        Employee emp = new Employee();
        Page<Employee> page = emp.selectPage(new Page<Employee>(1, 5), new EntityWrapper<Employee>()
                .like("last_name", "yuebuqun")

        );
        List<Employee> records = page.getRecords();
        for(Employee employee:records){
            System.out.println(employee);
        }

    }
}
