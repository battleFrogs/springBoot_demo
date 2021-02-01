package com.gjc.spring_security_demo.service.base;


import com.baomidou.mybatisplus.extension.service.IService;
import com.gjc.spring_security_demo.entity.AuthDO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author gjc
 * @since 2020-03-07
 */
public interface IAuthService extends IService<AuthDO> {

    List<AuthDO> selectSysMenuByUserId(Integer userId);


}
