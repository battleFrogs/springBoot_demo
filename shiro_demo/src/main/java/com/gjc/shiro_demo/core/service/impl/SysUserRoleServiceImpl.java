package com.gjc.shiro_demo.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gjc.shiro_demo.core.dao.SysUserRoleDao;
import com.gjc.shiro_demo.core.entity.SysUserRoleEntity;
import com.gjc.shiro_demo.core.service.SysUserRoleService;
import org.springframework.stereotype.Service;

/**
 * @Description 用户与角色业务实现
 * @CreateTime 2019/6/14 15:57
 */
@Service("sysUserRoleService")
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleDao, SysUserRoleEntity> implements SysUserRoleService {

}
