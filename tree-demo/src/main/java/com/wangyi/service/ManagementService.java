package com.wangyi.service;



import com.wangyi.bean.Managements;
import com.wangyi.bean.UserAuthority;
import com.wangyi.bean.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ManagementService {
    List<Managements> selectManagements();
    List<Managements> selectManagementsByName(String m_id,String children);
    List<Users> selectUsers();
    List<Users> selectUsers02();
    Integer addManagements(Integer user_id,Integer managements_id,Integer childManagements_id);
    Integer addRoleName( Integer id,String role_name);
    List<Integer> userAuthority( Integer user_id);
    List<Integer> userAuthorityChildren(Integer user_id);
    Integer removeManagements(Integer user_id);
    Integer restoreRoleName(Integer user_id);
    Integer updateAuthorityLevel(Integer user_id, Integer level);
    Integer addManagement(String management_name);
    Integer addChildManagement(String name,Integer id,String tree_url);
}
