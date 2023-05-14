package com.mightcell.controller;

import cn.dev33.satoken.util.SaResult;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.mightcell.constant.MenuConstant;
import com.mightcell.entity.Directory;
import com.mightcell.entity.Menu;
import com.mightcell.exception.CodeException;
import com.mightcell.service.DirectoryService;
import com.mightcell.service.MenuService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.lang.invoke.LambdaMetafactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.mightcell.constant.ResultCode.ERROR;
import static com.mightcell.constant.ResultCode.SUCCESS;

/**
 * @author 修雯天
 */
@Slf4j
@Validated
@CrossOrigin
@RestController
@RequestMapping("menu")
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;

    private final DirectoryService directoryService;

    /**
     * 添加菜单
     *
     * 请求地址：/menu/save
     * @param menu 菜单
     * @return 是否添加成功
     */
    @PostMapping("/save")
    public SaResult save(@RequestBody Menu menu) {
        boolean res = menuService.save(menu);
        if (res) {
            return SaResult.ok("添加成功").setCode(SUCCESS);
        }
        return SaResult.ok("添加失败").setCode(ERROR);

    }

    /**
     * 批量添加菜单
     *
     * 请求地址：/menu/saveBatch
     * @param menuList 菜单列表
     * @return 是否添加成功
     */
    @PostMapping("/saveBatch")
    public SaResult saveBatch(@RequestBody ArrayList<Menu> menuList) {
        log.info(menuList.toString());
        boolean res = menuService.saveBatch(menuList);
        if (res) {
            return SaResult.ok("添加成功").setCode(SUCCESS);
        }
        return SaResult.ok("添加失败").setCode(ERROR);
    }

    /**
     * 修改菜单
     *
     * 请求地址：/menu/update
     * @param menu 菜单
     * @return 是否修改成功
     */
    @PutMapping("/update")
    public SaResult update(@RequestBody Menu menu) {
        boolean res = menuService.saveOrUpdate(menu);
        if (res) {
            return SaResult.ok("操作成功").setCode(SUCCESS);
        }
        return SaResult.ok("操作失败").setCode(ERROR);
    }

    /**
     * 删除菜单
     *
     * 请求地址：/menu/remove/{id}
     * @param id 菜单id
     * @return 是否删除菜单
     */
    @DeleteMapping("/remove/{id}")
    public SaResult remove(@PathVariable Integer id) {
        boolean res = menuService.removeById(id);
        if (res) {
            return SaResult.ok("删除成功").setCode(SUCCESS);
        }
        return SaResult.ok("删除失败").setCode(ERROR);
    }

    /**
     * 批量删除菜单
     *
     * 请求地址：/menu/removeBatch
     * @param menuList 菜单id列表
     * @return 是否删除菜单
     */
    @DeleteMapping("/removeBatch")
    public SaResult removeBatch(@RequestBody ArrayList<Integer> menuList) {
        boolean res = menuService.removeByIds(menuList);
        if (res) {
            return SaResult.ok("删除成功").setCode(SUCCESS);
        }
        return SaResult.ok("删除失败").setCode(ERROR);
    }

    /**
     * 根据id查询菜单
     *
     * 请求地址：/menu/{id}
     * @param id 菜单id
     * @return 菜单信息
     */
    @GetMapping("/{id}")
    public SaResult getById(@PathVariable Integer id) {
        Menu byId = menuService.getById(id);
        if (Objects.isNull(byId)) {
            log.info("目标菜单不存在");
            throw new CodeException("目标菜单不存在");
        }
        return SaResult.ok("获取成功").setData(byId).setCode(SUCCESS);
    }

    /**
     * 查询所有菜单
     *
     * 请求地址：/menu/list
     * @return 菜单列表
     */
    @GetMapping("/list")
    public SaResult list(@RequestParam(defaultValue = "") String name) {
        List<Menu> parentNode = menuService.findMenus(name);
        return SaResult.ok("获取成功").setData(parentNode).setCode(SUCCESS);
    }

    /**
     * 查询菜单总数
     *
     * 请求地址：/menu/count
     * @return 菜单总数
     */
    @GetMapping("/count")
    public SaResult count() {
        int count = menuService.count();
        return SaResult.ok("获取成功").setData(count).setCode(SUCCESS);
    }

    /**
     * 获取图标列表
     *
     * 请求地址：/menu/icons
     * @return 图标列表
     */
    @GetMapping("/icons")
    public SaResult icons() {
        LambdaQueryWrapper<Directory> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Directory::getType, MenuConstant.MENU_TYPE_ICON);
        List<Directory> list = directoryService.list(queryWrapper);
        return SaResult.ok("获取成功").setData(list).setCode(SUCCESS);
    }
}
