package com.mightcell.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mightcell.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author 修雯天
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {
    /**
     * 根据flag获取角色id
     * @param role flag
     * @return rid
     */
    @Select("select id from role where flag=#{flag}")
    Integer getByFlag(@Param("flag") String role);
}
