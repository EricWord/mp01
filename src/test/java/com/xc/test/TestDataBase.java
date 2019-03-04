package com.xc.test;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.xc.bean.Employee;
import com.xc.mapper.EmployeeMapper;
import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;

import javax.sql.DataSource;
import java.security.PublicKey;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

/**
 * @ClassName: TestDataBase
 * @Description: 测试数据库连接
 * @Author: Eric
 * @Date: 2019/3/3 0003
 * @Email: xiao_cui_vip@163.com
 */
public class TestDataBase {
    private ApplicationContext iocContext = new ClassPathXmlApplicationContext("applicationContext.xml");

    EmployeeMapper employeeMapper = iocContext.getBean("employeeMapper", EmployeeMapper.class);

    @Test
    public void testEnv() throws SQLException {
        DataSource dataSource = iocContext.getBean("dataSource", DataSource.class);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }

    @Test
    public void testInsert() {

//        System.out.println(num);
        //获取刚插入的数据在数据库中的id
//        Integer id = employee.getId();
//        System.out.println(id);
        Employee employee = new Employee();
        for (int i = 0; i < 30; i++) {

            employee.setAge(25 + i);
            employee.setEmail(i + "yuebuqun@163.com");
            employee.setGender("1");
            employee.setLastName("yuebuqun" + i);
            Integer num = employeeMapper.insert(employee);
        }
        System.out.println("批量插入完成！");

    }

    @Test
    public void testUpdateById() {
        Employee e = new Employee();
        e.setId(7);
        e.setAge(55);
        e.setEmail("laowang@qq.com");
        e.setGender("0");
        e.setLastName("老王");
        Integer res = employeeMapper.updateById(e);
        System.out.println(res);
    }

    @Test
    public void testSelectById() {
        Employee employee = employeeMapper.selectById(7);
        System.out.println(employee);

    }

    @Test
    public void testSelectOne() {
        Employee e = new Employee();
        e.setLastName("老王");
        Employee employee = employeeMapper.selectOne(e);
        System.out.println(employee);
    }

    @Test
    public void testSelectBatch() {
        List<Integer> idList = new ArrayList<Integer>();
        for (int i = 0; i < 8; i++) {
            idList.add(i);
        }
        List<Employee> employees = employeeMapper.selectBatchIds(idList);
        for (Employee e : employees) {
            System.out.println(e);
        }

    }

    @Test
    public void testSelectByMap() {
        Map<String, Object> mp = new HashMap<>();
        mp.put("last_name", "老王");
        List<Employee> employees = employeeMapper.selectByMap(mp);
        System.out.println(employees);
    }

    @Test
    public void testSelectByPage() {
        List<Employee> employees = employeeMapper.selectPage(new Page<Employee>(2, 2), null);
        for (Employee e : employees) {
            System.out.println(e);

        }
    }

    @Test
    public void testDeleteById() {
        Integer num = employeeMapper.deleteById(7);
        System.out.println(num);

    }

    @Test
    public void testDeleteByMap() {
        Map<String, Object> mp = new HashMap<>();
        mp.put("last_name", "yuebuqun");
        Integer num = employeeMapper.deleteByMap(mp);
        System.out.println(num);
    }

    @Test
    public void testDeleteBatch() {
        List<Integer> idList = new ArrayList<>();
        for (int i = 15; i < 21; i++) {
            idList.add(i);
        }
        Integer num = employeeMapper.deleteBatchIds(idList);
        System.out.println(num);
    }

    @Test
    public void testSelectByPageWrapper() {
        List<Employee> lis = employeeMapper.selectPage(new Page<Employee>(1, 5), new EntityWrapper<Employee>().between("age", 21, 44));
        for(Employee e:lis){
            System.out.println(e);
        }
    }
    @Test
    public  void testSelectList(){

        List<Employee> lis = employeeMapper.selectList(new EntityWrapper<Employee>().like("last_name", "yuebuqun"));
        for(Employee e:lis){
            System.out.println(e);
        }


    }
    @Test
    public void testEntityWrapperUpdate(){
        Employee employee = new Employee();
        employee.setEmail("wangsiis@sina.com");
        employeeMapper.update(employee,new EntityWrapper<Employee>().eq("last_name","yuebuqun12"));


    }

    @Test
    public void testEntityWrapperDelete(){
        employeeMapper.delete(new EntityWrapper<Employee>().eq("last_name","yuebuqun13"));

    }

    @Test
    public void testEntityWrapperOtherFun(){
        List<Employee> list = employeeMapper.selectList(new EntityWrapper<Employee>()
                .eq("gender", 1)
//                .orderBy("age")
                .orderDesc(Arrays.asList(new String[]{"age"}))
        );
        for(Employee em:list){
            System.out.println(em);
        }

    }
    @Test
    public void testCondition(){
        List<Employee> list = employeeMapper.selectPage(new Page<Employee>(1, 2), Condition.create()
                .like("last_name", "yuebuqun")
        );
        for(Employee emp:list){
            System.out.println(emp);

        }

    }

}
