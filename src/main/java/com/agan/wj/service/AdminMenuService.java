package com.agan.wj.service;

import com.agan.wj.dao.AdminMenuDao;
import com.agan.wj.dao.AdminRoleMenuDao;
import com.agan.wj.pojo.AdminMenu;
import com.agan.wj.pojo.AdminRoleMenu;
import com.agan.wj.pojo.AdminUserRole;
import com.agan.wj.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminMenuService {
    @Autowired
    UserService userService;

    @Autowired
    AdminUserRoleService adminUserRoleService;

    @Autowired
    AdminRoleMenuService adminRoleMenuService;

    @Autowired
    AdminMenuDao adminMenuDao;

    public List<AdminMenu> getMenusByCurrentUser(){
        String username = SecurityUtils.getSubject().getPrincipal().toString();
        User user = userService.findByUserName(username);

        // 获取当前用户对应的所有角色id
        List<Integer> rids = adminUserRoleService.findAllByUid(user.getId())
                .stream().map(AdminUserRole::getRid).collect(Collectors.toList());

        // 根据角色id列表查询出当前用户所有的菜单项
        List<Integer> menuIds = adminRoleMenuService.findMenusByRids(rids)
                .stream().map(AdminRoleMenu::getMid).collect(Collectors.toList());
        List<AdminMenu> menus = adminMenuDao.findAllById(menuIds)
                .stream().distinct().collect(Collectors.toList());

        // 处理菜单项的结构
        handleMenus(menus);
        return menus;
    }

    public List<AdminMenu> getAllByParentId(int parentId) {return adminMenuDao.findAllByParentId(parentId);}

    public void handleMenus(List<AdminMenu> menus) {
        menus.forEach(m -> {
            List<AdminMenu> children = getAllByParentId(m.getId());
            m.setChildren(children);
        });

        menus.removeIf(m -> m.getParentId() != 0);

    }

}
