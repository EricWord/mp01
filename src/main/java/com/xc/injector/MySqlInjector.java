package com.xc.injector;

import com.baomidou.mybatisplus.entity.TableInfo;
import com.baomidou.mybatisplus.mapper.AutoSqlInjector;
import org.apache.ibatis.builder.MapperBuilderAssistant;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.session.Configuration;

/**
 * @ClassName: MySqlInjector
 * @Description: 自定义启动注入SQLl类
 * @Author: Eric
 * @Date: 2019/3/4 0004
 * @Email: xiao_cui_vip@163.com
 */
public class MySqlInjector extends AutoSqlInjector {
    @Override
    public void inject(Configuration configuration, MapperBuilderAssistant builderAssistant, Class<?> mapperClass, Class<?> modelClass, TableInfo table) {
        //注入的sql语句
        String sql="delete from "+table.getTableName();
        //注入的方法名要与接口中定义的方法名一致
        String method="deleteAll";
        //构造SqlSource对象
        SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, modelClass);
        this.addDeleteMappedStatement(mapperClass,method,sqlSource);
    }
}
