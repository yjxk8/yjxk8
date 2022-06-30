package com.zhfw.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhfw.system.dao.UumUserMapper;
import com.zhfw.system.pojo.UumUser;
import com.zhfw.system.service.UumUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;
import java.util.Map;

@Service
public class UumUserServiceImpl implements UumUserService {

    @Autowired
    private UumUserMapper uumUserMapper;

    /**
     * 查询全部列表
     *
     * @return
     */
    @Override
    public List<UumUser> findAll() {
        return uumUserMapper.selectList(null);
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @return
     */
    @Override
    public UumUser findById(Integer id) {
        return uumUserMapper.selectById(id);
    }


    /**
     * 增加
     *
     * @param uumUser
     */
    @Override
    public void add(UumUser uumUser) {
        //获取盐
        String gensalt = BCrypt.gensalt();
        //对用户的密码进行加密
        String hashpw = BCrypt.hashpw(uumUser.getUserPassword(), gensalt);
        uumUser.setUserPassword(hashpw);
        uumUserMapper.insert(uumUser);
    }


    /**
     * 修改
     *
     * @param uumUser
     */
    @Override
    public void update(UumUser uumUser) {
        uumUserMapper.updateById(uumUser);
    }

    /**
     * 删除
     *
     * @param id
     */
    @Override
    public void delete(Integer id) {
        uumUserMapper.deleteById(id);
    }


    /**
     * 条件查询
     *
     * @param searchMap
     * @return
     */
    @Override
    public List<UumUser> findList(Map<String, Object> searchMap) {
        return uumUserMapper.selectList(createQuery(searchMap));
    }

    /**
     * 分页查询
     *
     * @param page
     * @param size
     * @return
     */
    @Override
    public Page<UumUser> findPage(int page, int size) {
        Page<UumUser> page1 = new Page(page, size);
        return uumUserMapper.selectPage(page1, null);
    }

    /**
     * 条件+分页查询
     *
     * @param searchMap 查询条件
     * @param page      页码
     * @param size      页大小
     * @return 分页结果
     */
    @Override
    public Page<UumUser> findPage(Map<String, Object> searchMap, int page, int size) {
        Page<UumUser> page1=new Page(page,size);
        QueryWrapper qw = createQuery(searchMap);
        return uumUserMapper.selectPage(page1,qw);
    }

    @Override
    public boolean login(UumUser uumUser) {
        //根据登录名获取管理员信息
        UumUser uumUser1 = new UumUser();
        uumUser1.setUserName(uumUser.getUserName());
        uumUser1.setStatus("1");
        UumUser uumUserResult = uumUserMapper.selectById(uumUser1);

        if (uumUserResult == null) {
            return false;
        } else {
            //对密码进行校验
            String md5Pwd = DigestUtils.md5DigestAsHex(uumUser.getUserPassword().getBytes());
            return uumUserResult.getUserPassword().equals(md5Pwd);
        }

        //返回结果
    }

    /**
     * 构建查询对象
     *
     * @param searchMap
     * @return
     */
    private QueryWrapper createQuery(Map<String, Object> searchMap) {
        QueryWrapper<UumUser> qw = new QueryWrapper<>();
        if (searchMap != null) {
            // 用户名
            if (searchMap.get("loginName") != null && !"".equals(searchMap.get("loginName"))) {
                qw.like("loginName", searchMap.get("loginName"));
            }
            // 密码
            if (searchMap.get("password") != null && !"".equals(searchMap.get("password"))) {
                qw.like("password", searchMap.get("password"));
            }
            // 状态
            if (searchMap.get("status") != null && !"".equals(searchMap.get("status"))) {
                qw.eq("status", searchMap.get("status"));
            }

            // id
            if (searchMap.get("id") != null) {
                qw.eq("id", searchMap.get("id"));
            }

        }
        return qw;
    }

}
