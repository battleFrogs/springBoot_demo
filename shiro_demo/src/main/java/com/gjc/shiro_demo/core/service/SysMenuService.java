package com.gjc.shiro_demo.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gjc.shiro_demo.core.entity.SysMenuEntity;

import java.util.List;

public interface SysMenuService extends IService<SysMenuEntity> {


    /**
     * 根据角色查询用户权限
     *
     * @CreateTime 2019/6/19 10:14
     * @Param roleId 角色ID
     * @Return List<SysMenuEntity> 权限集合
     */
    List<SysMenuEntity> selectSysMenuByRoleId(Long roleId);


}
