package com.cloud.vongadmin.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class vongCover implements Serializable {
    @TableId(type = IdType.AUTO)
    private Long id;

    private String name;
    private String url;
    private String title;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @TableLogic//逻辑删除
    @TableField(fill = FieldFill.INSERT)
    private int deleted;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @Version
    private int version;//乐观锁
}
