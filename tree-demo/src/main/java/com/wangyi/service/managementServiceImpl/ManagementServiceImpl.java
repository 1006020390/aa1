package com.wangyi.service.managementServiceImpl;

import com.wangyi.bean.Managements;
import com.wangyi.bean.UserAuthority;
import com.wangyi.bean.Users;
import com.wangyi.mapper.ManagementServiceMapper;
import com.wangyi.service.ManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ManagementServiceImpl implements ManagementService {
    @Autowired
    private ManagementServiceMapper serviceMapper;


    @Override
    public List<Managements> selectManagements() {
        return serviceMapper.selectManagements();
    }

    @Override
    public List<Managements> selectManagementsByName(String m_id, String children) {
        return serviceMapper.selectManagementsByName(m_id,children);
    }

    @Override
    public List<Users> selectUsers() {
        return serviceMapper.selectUsers();
    }

    @Override
    public List<Users> selectUsers02() {
        return serviceMapper.selectUsers02();
    }

    @Override
    public Integer addManagements(Integer user_id, Integer managements_id, Integer childManagements_id) {
        return serviceMapper.addManagements(user_id,managements_id,childManagements_id);
    }

    @Override
    public Integer addRoleName(Integer id, String role_name) {
        return serviceMapper.addRoleName(id,role_name);
    }

    @Override
    public List<Integer> userAuthority(Integer user_id) {
        return serviceMapper.userAuthority(user_id);
    }

    @Override
    public List<Integer> userAuthorityChildren(Integer user_id) {
        return serviceMapper.userAuthorityChildren(user_id);
    }

    @Override
    public Integer removeManagements(Integer user_id) {
        return serviceMapper.removeManagements(user_id);
    }

    @Override
    public Integer restoreRoleName(Integer user_id) {
        return serviceMapper.restoreRoleName(user_id);
    }

    @Override
    public Integer updateAuthorityLevel(Integer user_id, Integer level) {
        return serviceMapper.updateAuthorityLevel(user_id,level);
    }

    @Override
    public Integer addManagement(String management_name) {
        return serviceMapper.addManagement(management_name);
    }

    @Override
    public Integer addChildManagement(String name, Integer id, String tree_url) {
        return serviceMapper.addChildManagement(name,id,tree_url);
    }
}
