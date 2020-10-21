package com.maomao.mybatisplus.mybatisplus.mysql.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.maomao.mybatisplus.mybatisplus.mysql.entity.MtEbRoom;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 美团eb房型信息 Mapper 接口
 * </p>
 *
 * @author fengfujie
 * @since 2020-10-20
 */
public interface MtEbRoomMapper extends BaseMapper<MtEbRoom> {

	List<MtEbRoom> testMapper(@Param("poiId") String poiId);
}
