package com.zhfw.system.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhfw.system.pojo.UumUser;

import java.util.List;
import java.util.Map;

public interface UumUserService {

    /***
     * 查询所有
     * @return
     */
    List<UumUser> findAll();

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    UumUser findById(Integer id);

    /***
     * 新增
     * @param uumUser
     */
    void add(UumUser uumUser);

    /***
     * 修改
     * @param uumUser
     */
    void update(UumUser uumUser);

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
    List<UumUser> findList(Map<String, Object> searchMap);

    /***
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    Page<UumUser> findPage(int page, int size);

    /***
     * 多条件分页查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    Page<UumUser> findPage(Map<String, Object> searchMap, int page, int size);

    /**
     * 用户登录
     */
    boolean login(UumUser uumUser);


}
