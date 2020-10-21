package com.maomao.mybatisplus.mybatisplus.mysql.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.maomao.mybatisplus.mybatisplus.mysql.entity.MtEbRoom;
import com.maomao.mybatisplus.mybatisplus.mysql.mapper.MtEbRoomMapper;
import com.maomao.mybatisplus.mybatisplus.mysql.service.IMtEbRoomService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 美团eb房型信息 服务实现类
 * </p>
 *
 * @author fengfujie
 * @since 2020-10-20
 */
@DS("mysql")
@Service
public class MtEbRoomServiceImpl extends ServiceImpl<MtEbRoomMapper, MtEbRoom> implements IMtEbRoomService {

	@Override
	public List<MtEbRoom> testMapperSql(String poiId) {
		return baseMapper.testMapper(poiId);
	}
}
