package com.gjc.shiro_demo.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gjc.shiro_demo.core.entity.SysUserEntity;

public interface SysUserService extends IService<SysUserEntity> {

    /**
     * 根据用户名查询实体
     *
     * @CreateTime 2019/6/14 16:30
     * @Param username 用户名
     * @Return SysUserEntity 用户实体
     */
    SysUserEntity selectUserByName(String username);


}
