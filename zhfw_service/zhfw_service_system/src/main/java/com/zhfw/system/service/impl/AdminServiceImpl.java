package com.zhfw.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhfw.system.dao.AdminMapper;
import com.zhfw.system.pojo.Admin;
import com.zhfw.system.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;
import java.util.Map;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    /**
     * 查询全部列表
     *
     * @return
     */
    @Override
    public List<Admin> findAll() {
        return adminMapper.selectList(null);
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @return
     */
    @Override
    public Admin findById(Integer id) {
        return adminMapper.selectById(id);
    }


    /**
     * 增加
     *
     * @param admin
     */
    @Override
    public void add(Admin admin) {
        //获取盐
        String gensalt = BCrypt.gensalt();
        //对用户的密码进行加密
        String hashpw = BCrypt.hashpw(admin.getPassword(), gensalt);
        admin.setPassword(hashpw);
        adminMapper.insert(admin);
    }


    /**
     * 修改
     *
     * @param admin
     */
    @Override
    public void update(Admin admin) {
        adminMapper.updateById(admin);
    }

    /**
     * 删除
     *
     * @param id
     */
    @Override
    public void delete(Integer id) {
        adminMapper.deleteById(id);
    }


    /**
     * 条件查询
     *
     * @param searchMap
     * @return
     */
    @Override
    public List<Admin> findList(Map<String, Object> searchMap) {
        return adminMapper.selectList(createQuery(searchMap));
    }

    /**
     * 分页查询
     *
     * @param page
     * @param size
     * @return
     */
    @Override
    public Page<Admin> findPage(int page, int size) {
        Page<Admin> page1 = new Page(page, size);
        return adminMapper.selectPage(page1, null);
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
    public Page<Admin> findPage(Map<String, Object> searchMap, int page, int size) {
        Page<Admin> page1=new Page(page,size);
        QueryWrapper qw = createQuery(searchMap);
        return adminMapper.selectPage(page1,qw);
    }

    @Override
    public boolean login(Admin admin) {
        //根据登录名获取管理员信息
        Admin admin1 = new Admin();
        admin1.setLoginName(admin.getLoginName());
        admin1.setStatus("1");
        Admin adminResult = adminMapper.selectById(admin1);

        if (adminResult == null) {
            return false;
        } else {
            //对密码进行校验
            String md5Pwd = DigestUtils.md5DigestAsHex(admin.getPassword().getBytes());
            return adminResult.getPassword().equals(md5Pwd);
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
        QueryWrapper<Admin> qw = new QueryWrapper<>();
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
