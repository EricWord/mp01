package com.xc.test;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

/**
 * @ClassName: TestMPGB
 * @Description: MP代码生成器
 * @Author: Eric
 * @Date: 2019/3/4 0004
 * @Email: xiao_cui_vip@163.com
 */
public class TestMPGB {

    @Test
    public void testGen(){
        GlobalConfig config = new GlobalConfig();
        config.setActiveRecord(true)
                .setAuthor("Eric")
                .setOutputDir("E:\\projects\\mp01\\src\\main\\java")
                .setFileOverride(true)
                .setServiceName("%sService")
                .setIdType(IdType.AUTO);

        //数据源的配置
        DataSourceConfig dsConfig = new DataSourceConfig();
        dsConfig.setDbType(DbType.MYSQL)
                .setUrl("jdbc:mysql://localhost:3306/mp")
                .setDriverName("com.mysql.jdbc.Driver")
                .setUsername("root")
                .setPassword("123456");

        //策略配置
        StrategyConfig stConfig = new StrategyConfig();
        stConfig.setCapitalMode(true)
                .setDbColumnUnderline(true)
                .setNaming(NamingStrategy.underline_to_camel)
                .setInclude("tbl_employee")
                .setTablePrefix("tbl_");
        //包名策略
        PackageConfig pkConfig = new PackageConfig();
        pkConfig.setParent("com.xc")
                .setMapper("mapper")
                .setService("service")
                .setController("controller")
                .setEntity("bean");

        //整合
        AutoGenerator ag = new AutoGenerator().setGlobalConfig(config)
                .setDataSource(dsConfig)
                .setStrategy(stConfig)
                .setPackageInfo(pkConfig);
        //执行
        ag.execute();


    }

}
