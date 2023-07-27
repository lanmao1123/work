package com.team.dashuaibackend.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 药品
 * @TableName yao
 */
@TableName(value ="yao")
@Data
public class Yao implements Serializable {
    /**
     * ID号
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 
     */
    private Long yao_id;

    /**
     * 药品名称
     */
    private String yao_name;

    /**
     * 开始用药日期
     */
    private Date yao_startdate;

    /**
     * 结束用药日期
     */
    private Date yao_enddate;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
