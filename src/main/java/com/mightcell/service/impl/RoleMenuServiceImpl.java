package com.mightcell.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mightcell.entity.RoleMenu;
import com.mightcell.mapper.RoleMenuMapper;
import com.mightcell.service.RoleMenuService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author 修雯天
 */
@Service
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu> implements RoleMenuService {
    @Override
    public void setRoleMenu(Integer rid, ArrayList<Integer> mids) {
        // 删除当前角色id对应所有的菜单绑定关系
        baseMapper.deleteByRoleId(rid);

        // 将菜单id列表绑定到角色id
        for (Integer mid : mids) {
            RoleMenu roleMenu = new RoleMenu();
            roleMenu.setRid(rid);
            roleMenu.setMid(mid);
            baseMapper.insert(roleMenu);
        }
    }

    @Override
    public ArrayList<Integer> getRoleMenuList(Integer rid) {
        return baseMapper.getRoleMenuList(rid);
    }
}
