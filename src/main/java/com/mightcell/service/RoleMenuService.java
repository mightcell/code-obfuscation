package com.mightcell.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mightcell.entity.RoleMenu;

import java.util.ArrayList;

/**
 * @author 修雯天
 */
public interface RoleMenuService extends IService<RoleMenu> {

    /**
     * 设置角色菜单关系
     * @param rid 角色id
     * @param mids 菜单id列表
     */
    void setRoleMenu(Integer rid, ArrayList<Integer> mids);

    /**
     * 查询角色绑定的菜单
     *
     * 请求地址：/role/roleMenu/{rid}
     * @param rid 角色id
     * @return 菜单列表
     */
    ArrayList<Integer> getRoleMenuList(Integer rid);
}
