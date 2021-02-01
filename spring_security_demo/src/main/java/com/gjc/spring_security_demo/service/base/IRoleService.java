package com.gjc.spring_security_demo.service.base;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gjc.spring_security_demo.entity.RoleDO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author gjc
 * @since 2020-03-07
 */
public interface IRoleService extends IService<RoleDO> {


    List<RoleDO> selectSysRoleByUserId(Integer userId);
}
