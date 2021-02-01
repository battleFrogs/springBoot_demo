package com.gjc.spring_security_demo.service.base.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gjc.spring_security_demo.dao.RoleDOMapper;
import com.gjc.spring_security_demo.entity.RoleDO;
import com.gjc.spring_security_demo.service.base.IRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author gjc
 * @since 2020-03-07
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleDOMapper, RoleDO> implements IRoleService {

    @Resource
    private RoleDOMapper roleDOMapper;

    @Override
    public List<RoleDO> selectSysRoleByUserId(Integer userId) {
        return roleDOMapper.selectSysRoleByUserId(userId);
    }
}
