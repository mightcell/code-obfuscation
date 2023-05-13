package com.mightcell.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.mightcell.entity.User;
import com.mightcell.entity.request.*;
import com.mightcell.entity.response.PageVo;
import com.mightcell.entity.response.UserPageDto;

/**
 * @author: MightCell
 * @description:
 * @date: Created in 18:50 2023-02-22
 */
public interface UserService extends IService<User> {
    /**
     * 用户登录
     * @param loginBo
     * @return 用户ID
     */
    User userLogin(LoginBo loginBo);

    /**
     * 用户注册
     * @param registerBo
     * @return 受影响的函数
     */
    int userRegister(RegisterBo registerBo);

    /**
     * 根据ID获取用户信息
     * @return 用户信息
     */
    User getUserInfoById(Long id);

    /**
     * 获取当前登录用户信息
     * @return 登录用户信息
     */
    UserVo getCurrentUserInfo();

    /**
     * 更新用户信息（用户ID）
     * @param user 更新用户
     * @return 是否更新成功
     */
    boolean updateByUserId(User user);

    /**
     * 封装UserPage
     *
     * @param userPageBo 用户分页查询参数反序列化类
     * @return 封装好的用户页面信息
     */
    Page<UserPageDto> getUserPage(UserPageBo userPageBo);

    /**
     * 切换用户状态
     * @param id 用户id
     * @return 是否成功切换用户状态
     */
    boolean updateStatus(Integer id);

}
