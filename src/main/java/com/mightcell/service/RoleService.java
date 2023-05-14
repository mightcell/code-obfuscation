package com.mightcell.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mightcell.entity.Role;

/**
 * @author 修雯天
 */
public interface RoleService extends IService<Role> {
    /**
     * 根据flag查询角色id
     * @param role flag
     * @return rid
     */
    Integer getByFlag(String role);

}
