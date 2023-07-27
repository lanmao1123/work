package com.team.dashuaibackend.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 用户尿量记录表
 * @TableName niao
 */
@TableName(value ="niao")
@Data
public class Niao implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     *
     */
    private Long user_id;

    /**
     *
     */
    private Double niao_amount;

    /**
     *
     */
    private Date create_time;

    /**
     *
     */
    private Double yali;

    /**
     * 感染0-未感染 1-感染
     */
    private Integer hurt;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
