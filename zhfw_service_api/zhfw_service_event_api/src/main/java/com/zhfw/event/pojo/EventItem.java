package com.zhfw.event.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * brand实体类
 * @author qliu
 *
 */
@TableName("xxzx.pro_event_item")
@KeySequence(value = "PRO_EVENT_ITEM")
public class EventItem implements Serializable {

	@TableId(value = "id",type = IdType.INPUT)
	private Integer id;//品牌id

	
	private String name;//品牌名称

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


}
