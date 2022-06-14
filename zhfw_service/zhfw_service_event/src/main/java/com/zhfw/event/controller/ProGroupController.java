package com.zhfw.event.controller;

import com.zhfw.entity.Result;
import com.zhfw.entity.StatusCode;
import com.zhfw.event.pojo.ProGroup;
import com.zhfw.event.pojo.ProGroup;
import com.zhfw.event.service.ProGroupService;
import com.zhfw.event.service.ProGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/proGroup")
public class ProGroupController {


    @Autowired
    private ProGroupService proGroupService;

    /**
     * 查询全部数据
     * @return
     */
    @GetMapping
    public Result findAll(){
        List<ProGroup> proGroupList = proGroupService.findAll();
        return new Result(true, StatusCode.OK,"查询成功",proGroupList) ;
    }

    /***
     * 根据ID查询数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id){
        ProGroup proGroup = proGroupService.findById(id);
        return new Result(true,StatusCode.OK,"查询成功",proGroup);
    }


    /***
     * 新增数据
     * @param proGroup
     * @return
     */
    @PostMapping
    public Result add(@RequestBody ProGroup proGroup){
        proGroupService.add(proGroup);
        return new Result(true,StatusCode.OK,"添加成功");
    }


    /***
     * 修改数据
     * @param proGroup
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody ProGroup proGroup,@PathVariable Integer id){
        proGroup.setId(id);
        proGroupService.update(proGroup);
        return new Result(true,StatusCode.OK,"修改成功");
    }


    /***
     * 根据ID删除业务类型数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        proGroupService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 多条件搜索业务类型数据
     * @param searchMap
     * @return
     */
    @GetMapping(value = "/search" )
    public Result findList(@RequestParam Map searchMap){
        List<ProGroup> list = proGroupService.findList(searchMap);
        return new Result(true,StatusCode.OK,"查询成功",list);
    }


//    /***
//     * 分页搜索实现
//     * @param searchMap
//     * @param page
//     * @param size
//     * @return
//     */
//    @GetMapping(value = "/search/{page}/{size}" )
//    public Result findPage(@RequestParam Map searchMap, @PathVariable  int page, @PathVariable  int size){
//        Page<ProGroup> pageList = proGroupService.findPage(searchMap, page, size);
//        PageResult pageResult=new PageResult(pageList.getTotal(),pageList.getRecords());
//        return new Result(true,StatusCode.OK,"查询成功",pageResult);
//    }
//
//    @GetMapping("/category/{categoryName}")
//    public Result<List<Map>> findProGroupListByCategoryName(@PathVariable("categoryName")String categoryName){
//        List<Map> proGroupList = proGroupService.findProGroupListByCategoryName(categoryName);
//        return new Result<>(true,StatusCode.OK,"查询成功",proGroupList);
//    }
}
