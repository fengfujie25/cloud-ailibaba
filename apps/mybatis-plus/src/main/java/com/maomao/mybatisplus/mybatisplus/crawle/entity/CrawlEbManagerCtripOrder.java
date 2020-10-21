package com.maomao.mybatisplus.mybatisplus.crawle.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author fujie.feng
 * @Date 2020-10-20
 */
@Data
@TableName("crawl_eb_manager_ctrip_order")
public class CrawlEbManagerCtripOrder {
	private Integer hid;

	private String orderid;

	private Date formdate;

	private String orderstatusdisplay;

	private String ordertype;

	private String paymenttype;

	private String holdroom;

	private String freesale;

	private String clientname;

	private Integer guests;

	private String suppliername;

	private String roomname;

	private Integer quantity;

	private String bedtype;

	private String arrivalanddeparture;

	private Integer livedays;

	private String arrivalearlyandlatesttime;

	private String cashpledge;

	private String amountdes;

	private String promotionlist;

	private String orderroomprices;

	private String invoice;

	private String ctripremarks;

	private String showladderdeductpolicy;

	private String ladderdeductpolicy;

	private String limitcancelhtml;

	private String hotelname;

	private Date insertdate;

	private String cancelpolicytitle;

	private String cancelpolicytext;

}
