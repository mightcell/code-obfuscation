package com.mightcell.entity.response;

import com.baomidou.mybatisplus.annotation.TableId;
import com.mightcell.entity.User;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author 修雯天
 */
@Data
public class UserPageDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;

    private String password;

    private String username;

    private String phone;

    private String email;

    private Integer status;
}
