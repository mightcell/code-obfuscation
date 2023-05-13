package com.mightcell.controller;

import cn.dev33.satoken.util.SaResult;
import com.mightcell.entity.Role;
import com.mightcell.entity.RoleMenu;
import com.mightcell.exception.CodeException;
import com.mightcell.service.RoleMenuService;
import com.mightcell.service.RoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;
import java.lang.reflect.Array;
import java.util.*;

import static com.mightcell.constant.ResultCode.ERROR;
import static com.mightcell.constant.ResultCode.SUCCESS;

/**
 * @author 修雯天
 */
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("role")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    private final RoleMenuService roleMenuService;

    /**
     * 添加角色
     *
     * 请求地址：/role/save
     * @param role 角色
     * @return 是否添加成功
     */
    @PostMapping("/save")
    public SaResult save(@RequestBody Role role) {
        boolean res = roleService.save(role);
        if (res) {
            return SaResult.ok("添加成功").setCode(SUCCESS);
        }
        return SaResult.ok("添加失败").setCode(ERROR);

    }

    /**
     * 批量添加角色
     *
     * 请求地址：/role/saveBatch
     * @param roleList 角色列表
     * @return 是否添加成功
     */
    @PostMapping("/saveBatch")
    public SaResult saveBatch(@RequestBody ArrayList<Role> roleList) {
        log.info(roleList.toString());
        boolean res = roleService.saveBatch(roleList);
        if (res) {
            return SaResult.ok("添加成功").setCode(SUCCESS);
        }
        return SaResult.ok("添加失败").setCode(ERROR);
    }

    /**
     * 修改角色
     *
     * 请求地址：/role/update
     * @param role 角色
     * @return 是否修改成功
     */
    @PutMapping("/update")
    public SaResult update(@RequestBody Role role) {
        boolean res = roleService.saveOrUpdate(role);
        if (res) {
            return SaResult.ok("操作成功").setCode(SUCCESS);
        }
        return SaResult.ok("操作失败").setCode(ERROR);
    }

    /**
     * 删除角色
     *
     * 请求地址：/role/remove/{id}
     * @param id 角色id
     * @return 是否删除角色
     */
    @DeleteMapping("/remove/{id}")
    public SaResult remove(@PathVariable Integer id) {
        boolean res = roleService.removeById(id);
        if (res) {
            return SaResult.ok("删除成功").setCode(SUCCESS);
        }
        return SaResult.ok("删除失败").setCode(ERROR);
    }

    /**
     * 批量删除角色
     *
     * 请求地址：/role/removeBatch
     * @param roleList 角色id列表
     * @return 是否删除角色
     */
    @DeleteMapping("/removeBatch")
    public SaResult removeBatch(@RequestBody ArrayList<Integer> roleList) {
        boolean res = roleService.removeByIds(roleList);
        if (res) {
            return SaResult.ok("删除成功").setCode(SUCCESS);
        }
        return SaResult.ok("删除失败").setCode(ERROR);
    }

    /**
     * 根据id查询角色
     *
     * 请求地址：/role/{id}
     * @param id 角色id
     * @return 角色信息
     */
    @GetMapping("/{id}")
    public SaResult getById(@PathVariable Integer id) {
        Role byId = roleService.getById(id);
        if (Objects.isNull(byId)) {
            log.info("目标角色不存在");
            throw new CodeException("目标角色不存在");
        }
        return SaResult.ok("获取成功").setData(byId).setCode(SUCCESS);
    }

    /**
     * 查询所有角色
     *
     * 请求地址：/role/list
     * @return 角色列表
     */
    @GetMapping("/list")
    public SaResult list() {
        List<Role> list = roleService.list();
        return SaResult.ok("获取成功").setData(list).setCode(SUCCESS);
    }

    /**
     * 查询角色总数
     *
     * 请求地址：/role/count
     * @return 角色总数
     */
    @GetMapping("/count")
    public SaResult count() {
        int count = roleService.count();
        return SaResult.ok("获取成功").setData(count).setCode(SUCCESS);
    }


    /**
     * 设置角色关系
     *
     * 请求地址：/role/roleMenu/{rid}/{mids}
     * @param rid 角色id
     * @param mids 菜单id列表
     * @return
     */
    @PostMapping("/roleMenu/{rid}")
    public SaResult setRoleMenu(@PathVariable Integer rid, @RequestBody ArrayList<Integer> mids) {
        roleMenuService.setRoleMenu(rid, mids);
        return SaResult.ok("设置成功").setCode(SUCCESS);
    }

    /**
     * 查询角色绑定的菜单
     *
     * 请求地址：/role/roleMenu/{rid}
     * @param rid 角色id
     * @return 菜单列表
     */
    @GetMapping("/roleMenu/{rid}")
    public SaResult getRoleMenu(@PathVariable Integer rid) {
        ArrayList<Integer> menuList = roleMenuService.getRoleMenuList(rid);
        return SaResult.ok("获取成功").setData(menuList).setCode(SUCCESS);
    }

}
