package com.zhfw.event.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhfw.event.pojo.EventItem;

import java.util.List;
import java.util.Map;

public interface EventItemService {

    /***
     * 查询所有
     * @return
     */
    List<EventItem> findAll();

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    EventItem findById(Integer id);

    /***
     * 新增
     * @param eventItem
     */
    void add(EventItem eventItem);

    /***
     * 修改
     * @param eventItem
     */
    void update(EventItem eventItem);

    /***
     * 删除
     * @param id
     */
    void delete(Integer id);

//    /***
//     * 多条件搜索
//     * @param searchMap
//     * @return
//     */
//    List<EventItem> findList(Map<String, Object> searchMap);
//
//    /***
//     * 分页查询
//     * @param page
//     * @param size
//     * @return
//     */
//    Page<EventItem> findPage(int page, int size);
//
//    /***
//     * 多条件分页查询
//     * @param searchMap
//     * @param page
//     * @param size
//     * @return
//     */
//    Page<EventItem> findPage(Map<String, Object> searchMap, int page, int size);
//
//    /**
//     * 根据分类名称查询品牌列表
//     * @param categoryName
//     * @return
//     */
//    public List<Map> findEventItemListByCategoryName(String categoryName);
//

}
