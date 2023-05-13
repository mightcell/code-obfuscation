package com.mightcell.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mightcell.entity.RoleMenu;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.ArrayList;

/**
 * @author 修雯天
 */
@Mapper
public interface RoleMenuMapper extends BaseMapper<RoleMenu> {
    /**
     * 删除当前角色id的所有绑定菜单关系
     * @param rid 角色id
     * @return 受影响的行数
     */
    @Delete("delete from role_menu where rid=#{rid}")
    int deleteByRoleId(@Param("rid") Integer rid);

    /**
     * 查询当前角色id绑定的菜单
     * @param rid 角色id
     * @return 菜单列表
     */
    @Select("select mid from role_menu where rid=#{rid}")
    ArrayList<Integer> getRoleMenuList(@Param("rid") Integer rid);
}
