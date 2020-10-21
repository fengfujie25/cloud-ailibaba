package com.maomao.mybatisplus.mybatisplus.mysql.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 美团eb房型信息
 * </p>
 *
 * @author fengfujie
 * @since 2020-10-20
 */
@Data
@TableName("mt_eb_room")
@EqualsAndHashCode(callSuper = false)
public class MtEbRoom implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 渠道poi_id
     */
    private String poiId;

    /**
     * 酒店code
     */
    private String hotelCode;

    /**
     * 房型id
     */
    private String roomId;

    /**
     * 房型名称
     */
    private String roomName;

    /**
     * real_room_id
     */
    private String realRoomId;

    /**
     * 0:删除 1：正常
     */
    private Integer status;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
