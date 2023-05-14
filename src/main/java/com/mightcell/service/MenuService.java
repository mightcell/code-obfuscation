package com.mightcell.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mightcell.entity.Menu;

import java.util.List;

/**
 * @author 修雯天
 */
public interface MenuService extends IService<Menu> {
    List<Menu> findMenus(String name);
}
