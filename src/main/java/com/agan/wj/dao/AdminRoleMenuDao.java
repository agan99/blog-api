package com.agan.wj.dao;

import com.agan.wj.pojo.AdminRoleMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRoleMenuDao extends JpaRepository<AdminRoleMenu, Integer> {
    /**
     * 根据角色id查询菜单项
     * @param rid
     * @return
     */
    List<AdminRoleMenu> findAllByRid (Integer rid);

}
