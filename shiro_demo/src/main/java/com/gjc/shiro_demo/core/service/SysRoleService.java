package com.gjc.shiro_demo.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gjc.shiro_demo.core.entity.SysRoleEntity;

import java.util.List;

public interface SysRoleService extends IService<SysRoleEntity> {

    /**
     * 通过用户ID查询角色集合
     *
     * @CreateTime 2019/6/18 18:01
     * @Param userId 用户ID
     * @Return List<SysRoleEntity> 角色名集合
     */
    List<SysRoleEntity> selectSysRoleByUserId(Long userId);


}
