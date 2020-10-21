package com.maomao.mybatisplus.mybatisplus.mysql.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.maomao.mybatisplus.mybatisplus.mysql.entity.MtEbRoom;

import java.util.List;

/**
 * <p>
 * 美团eb房型信息 服务类
 * </p>
 *
 * @author fengfujie
 * @since 2020-10-20
 */
public interface IMtEbRoomService extends IService<MtEbRoom> {

	List<MtEbRoom> testMapperSql(String poiId);
}
