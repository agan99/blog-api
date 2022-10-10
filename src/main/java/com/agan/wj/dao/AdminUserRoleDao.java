package com.agan.wj.dao;

import com.agan.wj.pojo.AdminUserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminUserRoleDao extends JpaRepository<AdminUserRole, Integer> {
    List<AdminUserRole> findAllByUid(Integer uid);

    List<AdminUserRole> findAllByRid(Integer rid);
}
