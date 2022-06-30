package com.zhfw.system.controller;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhfw.entity.PageResult;
import com.zhfw.entity.Result;
import com.zhfw.entity.StatusCode;
import com.zhfw.system.pojo.UumUser;
import com.zhfw.system.service.UumUserService;
import com.zhfw.system.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/uumUser")
public class UumUserController {


    @Autowired
    private UumUserService uumUserService;

    /**
     * 查询全部数据
     * @return
     */
    @GetMapping
    public Result findAll(){
        List<UumUser> uumUserList = uumUserService.findAll();
        return new Result(true, StatusCode.OK,"查询成功",uumUserList) ;
    }

    /***
     * 根据ID查询数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id){
        UumUser uumUser = uumUserService.findById(id);
        return new Result(true,StatusCode.OK,"查询成功",uumUser);
    }


    /***
     * 新增数据
     * @param uumUser
     * @return
     */
    @PostMapping
    public Result add(@RequestBody UumUser uumUser){
        uumUserService.add(uumUser);
        return new Result(true,StatusCode.OK,"添加成功");
    }


    /***
     * 修改数据
     * @param uumUser
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody UumUser uumUser,@PathVariable Integer id){
        uumUser.setId(id);
        uumUserService.update(uumUser);
        return new Result(true,StatusCode.OK,"修改成功");
    }


    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        uumUserService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 多条件搜索品牌数据
     * @param searchMap
     * @return
     */
    @GetMapping(value = "/search" )
    public Result findList(@RequestParam Map searchMap){
        List<UumUser> list = uumUserService.findList(searchMap);
        return new Result(true,StatusCode.OK,"查询成功",list);
    }


    /***
     * 分页搜索实现
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result findPage(@RequestParam Map searchMap, @PathVariable  int page, @PathVariable  int size){
        Page<UumUser> pageList = uumUserService.findPage(searchMap, page, size);
        PageResult pageResult=new PageResult(pageList.getTotal(),pageList.getRecords());
        return new Result(true,StatusCode.OK,"查询成功",pageResult);
    }

    @PostMapping("/login")
    public Result login(@RequestBody UumUser uumUser){
        boolean result = uumUserService.login(uumUser);
        if (result){
            //密码是正确的
            //生成jwt令牌,返回到客户端
            Map<String,String> info = new HashMap<>();
            info.put("username",uumUser.getUserName());
            //基于工具类生成jwt令牌
            String jwt = JwtUtil.createJWT(UUID.randomUUID().toString(), uumUser.getUserName(), null);
            info.put("token",jwt);
            return new Result(true, StatusCode.OK,"登录成功",info);
        }else{
            return new Result(false, StatusCode.ERROR,"登录失败");
        }
    }


}
