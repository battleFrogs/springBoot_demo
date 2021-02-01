package com.gjc.spring_security_demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gjc.spring_security_demo.entity.AuthDO;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author gjc
 * @since 2020-03-07
 */
public interface AuthDOMapper extends BaseMapper<AuthDO> {

    List<AuthDO> selectSysMenuByUserId(Integer userId);


}
