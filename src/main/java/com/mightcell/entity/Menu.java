package com.mightcell.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author 修雯天
 */
@Data
public class Menu implements Serializable {

    private static final long serialVersionUID = -6872451285215199651L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private String path;

    private String icon;

    private String description;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime updateTime;

    @TableLogic
    private Integer isDeleted;
}
