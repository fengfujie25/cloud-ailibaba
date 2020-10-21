package com.maomao.mybatisplus.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.maomao.mybatisplus.mybatisplus.crawle.entity.CrawlEbManagerCtripOrder;
import com.maomao.mybatisplus.mybatisplus.crawle.mapper.CrawlEbManagerCtripOrderMapper;
import com.maomao.mybatisplus.mybatisplus.mysql.entity.MtEbRoom;
import com.maomao.mybatisplus.mybatisplus.mysql.service.IMtEbRoomService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author fujie.feng
 * @Date 2020-10-20
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisPlusTest {

	@Autowired
	private IMtEbRoomService mtEbRoomService;

	@Autowired
	private CrawlEbManagerCtripOrderMapper mapper;

	@Test
	public void test() {
		QueryWrapper<MtEbRoom> mtEbRoomQueryWrapper = new QueryWrapper<>();
		mtEbRoomQueryWrapper.eq("poi_id", "4526228");

		List<MtEbRoom> list1 = mtEbRoomService.list(mtEbRoomQueryWrapper);

		List<MtEbRoom> list2 = mtEbRoomService.testMapperSql("4526228");

		QueryWrapper<CrawlEbManagerCtripOrder> queryWrapper = new QueryWrapper<CrawlEbManagerCtripOrder>();
		queryWrapper.eq("hid", 14709417);
		List<CrawlEbManagerCtripOrder> list = mapper.selectList(queryWrapper);
		list.forEach(System.out::println);
		System.out.println(list.size());

	}
}
