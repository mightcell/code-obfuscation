package com.mightcell.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mightcell.entity.Menu;
import com.mightcell.mapper.MenuMapper;
import com.mightcell.service.MenuService;
import org.springframework.stereotype.Service;

/**
 * @author 修雯天
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {
}
