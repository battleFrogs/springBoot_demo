package com.gjc.spring_security_demo.service.base.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gjc.spring_security_demo.dao.UserDOMapper;
import com.gjc.spring_security_demo.entity.UserDO;
import com.gjc.spring_security_demo.service.base.IUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gjc
 * @since 2020-03-07
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDOMapper, UserDO> implements IUserService {


}
