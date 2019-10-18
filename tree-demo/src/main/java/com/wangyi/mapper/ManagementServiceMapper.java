package com.wangyi.mapper;

import com.wangyi.bean.Managements;
import com.wangyi.bean.UserAuthority;
import com.wangyi.bean.Users;
import com.wangyi.service.ManagementService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ManagementServiceMapper {
    List<Managements> selectManagements();
    List<Users> selectUsers();
    List<Users> selectUsers02();
    Integer addManagements(@Param("user_id") Integer user_id,@Param("managements_id") Integer managements_id,@Param("childManagements_id") Integer childManagements_id);
    Integer addRoleName(@Param("id") Integer id,@Param("role_name") String role_name);
    List<Integer> userAuthority(@Param("user_id") Integer user_id);
    List<Integer> userAuthorityChildren(@Param("user_id") Integer user_id);
    List<Managements> selectManagementsByName(@Param("m_id") String m_id,@Param("children") String children);
    Integer removeManagements(@Param("user_id") Integer user_id);
    Integer restoreRoleName(@Param("user_id") Integer user_id);
    Integer updateAuthorityLevel(@Param("user_id") Integer user_id,@Param("level") Integer level);
    //添加权限节点的三个接口：
    Integer addManagement(@Param("management_name") String management_name);
    Integer addChildManagement(@Param("name") String name,@Param("father_id") Integer id,@Param("tree_url") String tree_url);
    //以上
}
