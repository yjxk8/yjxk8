package com.zhfw.event.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhfw.event.dao.EventItemMapper;
import com.zhfw.event.pojo.EventItem;
import com.zhfw.event.service.EventItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class EventItemImpl implements EventItemService {

    @Autowired
    private EventItemMapper eventItemMapper;

    /**
     * 查询全部列表
     * @return
     */
    @Override
    public List<EventItem> findAll() {
        return eventItemMapper.selectList(null);
    }

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    @Override
    public EventItem findById(Integer id){
        return  eventItemMapper.selectById(id);
    }


    /**
     * 增加
     * @param eventItem
     */
    @Override
    public void add(EventItem eventItem){
        eventItemMapper.insert(eventItem);
    }


    /**
     * 修改
     * @param eventItem
     */
    @Override
    public void update(EventItem eventItem){
        eventItemMapper.updateById(eventItem);
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete(Integer id){
        eventItemMapper.deleteById(id);
    }

//
//    /**
//     * 条件查询
//     * @param searchMap
//     * @return
//     */
//    @Override
//    public List<EventItem> findList(Map<String, Object> searchMap){
//        Wrapper<EventItem> wrapper = createExample(searchMap);
//        return eventItemMapper.selectList(example);
//    }
//
//    /**
//     * 分页查询
//     * @param page
//     * @param size
//     * @return
//     */
//    @Override
//    public Page<EventItem> findPage(int page, int size){
//        Page<EventItem> page1=new Page<EventItem>(page,size);
//
//        return (Page<EventItem>)eventItemMapper.selectList(null);
//    }
//
//    /**
//     * 条件+分页查询
//     * @param searchMap 查询条件
//     * @param page 页码
//     * @param size 页大小
//     * @return 分页结果
//     */
//    @Override
//    public Page<EventItem> findPage(Map<String,Object> searchMap, int page, int size){
//        PageHelper.startPage(page,size);
//        Example example = createExample(searchMap);
//        return (Page<EventItem>)eventItemMapper.selectByExample(example);
//    }
//
//    @Override
//    public List<Map> findEventItemListByCategoryName(String categoryName) {
//        List<Map> eventItemList = eventItemMapper.findBrandListByCategoryName(categoryName);
//        return eventItemList;
//    }


}
