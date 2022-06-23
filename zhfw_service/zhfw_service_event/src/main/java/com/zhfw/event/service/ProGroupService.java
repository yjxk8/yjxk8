package com.zhfw.event.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhfw.event.pojo.ProGroup;

import java.util.List;
import java.util.Map;


public interface ProGroupService {

    /***
     * 查询所有
     * @return
     */
    List<ProGroup> findAll();

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    ProGroup findById(Integer id);

    /***
     * 新增
     * @param proGroup
     */
    void add(ProGroup proGroup);

    /***
     * 修改
     * @param proGroup
     */
    void update(ProGroup proGroup);

    /***
     * 删除
     * @param id
     */
    void delete(Integer id);

    /***
     * 多条件搜索
     * @param searchMap
     * @return
     */
    List<ProGroup> findList(Map<String, Object> searchMap);

    /***
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    Page<ProGroup> findPage(int page, int size);

    /***
     * 多条件分页查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    Page<ProGroup> findPage(Map<String, Object> searchMap, int page, int size);

//    /**
//     * 根据分类名称查询品牌列表
//     * @param categoryName
//     * @return
//     */
//    public List<Map> findProGroupListByCategoryName(String categoryName);
//

}
