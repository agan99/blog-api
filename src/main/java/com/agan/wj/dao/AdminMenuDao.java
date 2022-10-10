package com.agan.wj.dao;

import com.agan.wj.pojo.AdminMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminMenuDao extends JpaRepository<AdminMenu, Integer> {

    List<AdminMenu> findAllByParentId(Integer parentId);
}
