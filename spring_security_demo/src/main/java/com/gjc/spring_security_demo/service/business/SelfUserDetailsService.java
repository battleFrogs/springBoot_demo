package com.gjc.spring_security_demo.service.business;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gjc.spring_security_demo.config.entity.SelfUserEntity;
import com.gjc.spring_security_demo.dao.UserDOMapper;
import com.gjc.spring_security_demo.entity.UserDO;
import com.gjc.spring_security_demo.service.base.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SelfUserDetailsService implements UserDetailsService {

    @Resource
    private UserDOMapper userDOMapper;

    @Resource
    private IUserService userService;

    @Override
    public SelfUserEntity loadUserByUsername(String userName) {
        UserDO userDO = userService.lambdaQuery().eq(UserDO::getUsername, userName).one();
        if (userDO == null) {
            return null;
        }
        SelfUserEntity selfUserEntity = new SelfUserEntity();
        BeanUtils.copyProperties(userDO, selfUserEntity);
        return selfUserEntity;
    }
}
