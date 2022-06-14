package com.zhfw.event.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhfw.event.dao.ProGroupMapper;
import com.zhfw.event.pojo.ProGroup;
import com.zhfw.event.service.ProGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProGroupImpl implements ProGroupService {

    @Autowired
    private ProGroupMapper proGroupMapper;

    /**
     * 查询全部列表
     *
     * @return
     */
    @Override
    public List<ProGroup> findAll() {
        return proGroupMapper.selectList(null);
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @return
     */
    @Override
    public ProGroup findById(Integer id) {
        return proGroupMapper.selectById(id);
    }

    /**
     * 增加
     *
     * @param proGroup
     */
    @Override
    public void add(ProGroup proGroup) {
        proGroupMapper.insert(proGroup);
    }


    /**
     * 修改
     * @param proGroup
     */
    @Override
    public void update(ProGroup proGroup){
        proGroupMapper.updateById(proGroup);
    }
    /**
     * 删除
     * @param id
     */
    @Override
    public void delete(Integer id){
        proGroupMapper.deleteById(id);
    }


    /**
     * 条件查询
     * @param searchMap
     * @return
     */
    @Override
    public List<ProGroup> findList(Map<String, Object> searchMap){
        return proGroupMapper.selectList(createQuery(searchMap));
    }
//
//    /**
//     * 分页查询
//     * @param page
//     * @param size
//     * @return
//     */
//    @Override
//    public Page<ProGroup> findPage(int page, int size){
//        Page<ProGroup> page1=new Page<ProGroup>(page,size);
//
//        return (Page<ProGroup>)proGroupMapper.selectAll();
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
//    public Page<ProGroup> findPage(Map<String,Object> searchMap, int page, int size){
//        PageHelper.startPage(page,size);
//        Example example = createExample(searchMap);
//        return (Page<ProGroup>)proGroupMapper.selectByExample(example);
//    }
//
//    @Override
//    public List<Map> findProGroupListByCategoryName(String categoryName) {
//        List<Map> proGroupList = proGroupMapper.findBrandListByCategoryName(categoryName);
//        return proGroupList;
//    }

    /**
     * 构建查询对象
     * @param searchMap
     * @return
     */
    private QueryWrapper createQuery(Map<String, Object> searchMap){
        QueryWrapper<ProGroup> qw = new QueryWrapper<>();
         if(searchMap!=null){
            // 品牌名称
            if(searchMap.get("typeName")!=null && !"".equals(searchMap.get("typeName"))){
                qw.like("typeName","%"+searchMap.get("typeName")+"%");
            }

            // 品牌id
            if(searchMap.get("id")!=null ){
                qw.eq("id",searchMap.get("id"));
            }


        }
        return qw;
    }

}
