package com.bjpowernode.service.impl;

import com.bjpowernode.mapper.AdminMapper;
import com.bjpowernode.pojo.Admin;
import com.bjpowernode.pojo.AdminExample;
import com.bjpowernode.service.AdminService;
import com.bjpowernode.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    //在业务逻辑层中，一定会有数据访问层的对象
    @Autowired
    AdminMapper adminMapper;

    @Override
    public Admin login(String name, String pwd) {

        //根据用户传入的用户或到DB中查询响应的用户对象
        //如果有条件,一定要创建
        AdminExample example = new AdminExample();
        /**
         * 如何添加条件
         * select * from admin where a_name = 'admin'
         */

        //添加用户名a_name条件
        example.createCriteria().andANameEqualTo(name);//a_name = 'admin'

        List<Admin> list = adminMapper.selectByExample(example);//select * from admin where

        if (list.size() >0 ){
            Admin admin = list.get(0);
            //如果查到用户对象，再进行密码的对比.注意密码是密文
            /**
             * admin.getApass = c984aed014aec7623a54f0591da07a85fd4b762d
             * pwd=000000
             * 在进行密码对比时，要将传入的pwd进行md5加密，在与数据库中查到的对象与密码进行对比
             */

            String miPwd = MD5Util.getMD5(pwd);
            if(miPwd.equals(admin.getaPass())) {
                return admin;
            }
        }
        return null;
    }
}
