package com.xc.bean;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.enums.FieldFill;

/**
 * @ClassName: User
 * @Description: 用户
 * @Author: Eric
 * @Date: 2019/3/4 0004
 * @Email: xiao_cui_vip@163.com
 */
public class User {

    private Integer id;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String name;
    @TableLogic
    private Integer logicFlag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLogicFlag() {
        return logicFlag;
    }

    public void setLogicFlag(Integer logicFlag) {
        this.logicFlag = logicFlag;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", logicFlag=" + logicFlag +
                '}';
    }
}
