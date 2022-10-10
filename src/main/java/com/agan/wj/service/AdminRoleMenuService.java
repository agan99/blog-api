package com.agan.wj.service;

import com.agan.wj.dao.AdminRoleMenuDao;
import com.agan.wj.pojo.AdminRoleMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminRoleMenuService {
    @Autowired
    AdminRoleMenuDao adminRoleMenuDao;

    /**
     * 根据角色id列表查询出对应的菜单项
     * @param rids
     * @return
     */
    List<AdminRoleMenu> findMenusByRids (List<Integer> rids){
        ArrayList<AdminRoleMenu> menus = new ArrayList<>();
        for (Integer rid : rids) {
            menus.addAll(adminRoleMenuDao.findAllByRid(rid));
        }
        return menus;
    }
}
