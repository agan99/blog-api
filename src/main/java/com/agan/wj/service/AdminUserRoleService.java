package com.agan.wj.service;

import com.agan.wj.dao.AdminUserRoleDao;
import com.agan.wj.pojo.AdminUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminUserRoleService {

    @Autowired
    AdminUserRoleDao adminUserRoleDao;

    /**
     * 根据用户id获取当前用户绑定所有角色
     * @param uid
     * @return
     */
    List<AdminUserRole> findAllByUid(Integer uid){
        return adminUserRoleDao.findAllByUid(uid);
    }

    List<AdminUserRole> findAllByRid(Integer rid){
        return adminUserRoleDao.findAllByRid(rid);
    }
}
