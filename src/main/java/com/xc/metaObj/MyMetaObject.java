package com.xc.metaObj;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

/**
 * @ClassName: MyMetaObject
 * @Description: 自动填充
 * @Author: Eric
 * @Date: 2019/3/4 0004
 * @Email: xiao_cui_vip@163.com
 */
public class MyMetaObject extends MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        Object name = getFieldValByName("name", metaObject);
        if (null == name) {
            System.out.println("插入操作满足自动填充条件");
            setFieldValByName("name", "EricINSERT", metaObject);

        }

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        Object name = getFieldValByName("name", metaObject);
        if (null == name) {
            System.out.println("更新操作满足自动填充条件");
            setFieldValByName("name", "EricUPDATE", metaObject);

        }

    }
}
