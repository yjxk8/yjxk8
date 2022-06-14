package com.zhfw.event.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhfw.event.pojo.EventItem;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface EventItemMapper extends BaseMapper<EventItem> {

    @Select("SELECT name,image FROM tb_brand where id in( SELECT brand_id FROM tb_category_brand WHERE category_id in ( SELECT id from tb_category where name=#{categoryName}))")
    public List<Map> findBrandListByCategoryName(@Param("categoryName")String categoryName);
}
