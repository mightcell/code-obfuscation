package com.mightcell.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mightcell.entity.Role;
import com.mightcell.mapper.RoleMapper;
import com.mightcell.service.RoleService;
import org.springframework.stereotype.Service;

/**
 * @author 修雯天
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
}
