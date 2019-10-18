package com.wangyi.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.support.hsf.HSFJSONUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wangyi.bean.ChildManagements;
import com.wangyi.bean.Managements;
import com.wangyi.bean.UserAuthority;
import com.wangyi.bean.Users;
import com.wangyi.service.managementServiceImpl.ManagementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/layui")
public class PowerController {
    @Autowired
    private ManagementServiceImpl managementService;
@RequestMapping("/test")
public void test(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    Map<String,Object> map = new HashMap<>();

    String username = (String) req.getSession().getAttribute("username");
    String role_name = (String) req.getSession().getAttribute("role_name");

    Users uu = new Users();
    uu.setUsername(username);uu.setRole_name(role_name);
    map.put("user",uu);
        Integer user_id =Integer.parseInt(req.getSession().getAttribute("user_id").toString()) ;
    System.out.println("user_id:"+user_id);
        List<Integer> l1 = managementService.userAuthority(user_id);
    System.out.println(l1);
        if (l1.isEmpty()){
            map.put("list",null);
            resp.getWriter().append(JSON.toJSONString(map));
            return;
        }
        List<Integer> l2 = managementService.userAuthorityChildren(user_id);
        StringBuffer ll = new StringBuffer();
        StringBuffer l02 = new StringBuffer();
        for (Integer i: l1) {
            ll.append(i+",");
        }
        for (Integer j:l2 ) {
            l02.append(j+",");
        }
        String a1 = ll.substring(0,ll.length()-1).toString();
        String a2 =l02.substring(0,l02.length()-1).toString() ;
        System.out.println("啊哈？:"+a1);
    System.out.println(a2);
        List<Managements> list = managementService.selectManagementsByName(a1,a2);
        for (Managements s: list) {
            System.out.println(s);
        }

    map.put("list",list);
        resp.getWriter().append(JSON.toJSONString(map));
        return;
}
@RequestMapping("/test02")
    public void test02(HttpServletRequest req, HttpServletResponse resp){
    Integer cp = null;
    Integer ps = null;
    if (req.getParameter("currentPage")==null){
        cp = 1;
    }else{
        cp = Integer.parseInt(req.getParameter("currentPage"));
    }
    if (req.getParameter("pageSize")==null){
        ps = 5;
    }else{
        ps = Integer.parseInt(req.getParameter("pageSize"));
    }
    PageHelper.startPage(cp,ps);
    List<Users> list = managementService.selectUsers();
    PageInfo<Users> info = new PageInfo<>(list);
    try {
        resp.getWriter().append(JSON.toJSONString(info));
        return;
    } catch (IOException e) {
        e.printStackTrace();
    }
}
@RequestMapping("managementsList")
    public void test03(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    Integer level = Integer.parseInt(req.getParameter("level"));
    Integer authority_level = Integer.parseInt(req.getSession().getAttribute("authority_level").toString());
    if (level <= authority_level){
        resp.getWriter().append(JSON.toJSONString("您不能设置高于或等于你的权限级别"));
        return;
    }
    String list = req.getParameter("list");
    Integer user_id = Integer.parseInt(req.getParameter("id"));

    String role_name = req.getParameter("role_name");
   Integer alert_level = Integer.parseInt(req.getParameter("authority_level"));
    String ex = req.getParameter("boolean");

          if (authority_level>2 && ex.equals("true")){
          resp.getWriter().append(JSON.toJSONString("您没有增加添加\"管理员管理\"的权限"));
          return;
          }
          else if (alert_level==1&&authority_level ==1){
              resp.getWriter().append(JSON.toJSONString("你是超管！改你自己？"));
              return;
          }
          else if (alert_level==1 ){
              resp.getWriter().append(JSON.toJSONString("您以为您比\"超级管理员\"还屌？"));
              return;
          }
          else if (alert_level <= authority_level){
              resp.getWriter().append(JSON.toJSONString("您没有资格修改此人的权限"));
              return;
          }
    int a1 = managementService.updateAuthorityLevel(user_id,level);
    if (a1<1){
        resp.getWriter().append(JSON.toJSONString("添加失败，请重新操作"));
        return;
    }

    System.out.println("哈喽"+list);
    List<String> list1 = (List<String>) JSON.parse(list);

    Integer row =  managementService.addRoleName(user_id,role_name);
    if (row<0){
        resp.getWriter().append(JSON.toJSONString("添加失败"));
        return;
    }

    for (String s: list1) {
        Integer father_id = Integer.parseInt( s.substring(0,1));
        String[] children = s.substring(2,s.length()).split(",");
        for (int i = 0;i<children.length;i++){
            Integer r2 = managementService.addManagements(user_id,father_id,Integer.parseInt(children[i]));
            if (r2<0){resp.getWriter().append(JSON.toJSONString("添加时发生未知错误"));return;}
        }
    }
        resp.getWriter().append(JSON.toJSONString("添加完成"));

}
@RequestMapping("/test04")
    public void test04(HttpServletRequest req, HttpServletResponse resp){
    try {
        List<Managements> list = managementService.selectManagements();
        resp.getWriter().append(JSON.toJSONString(list));
        return;
    } catch (IOException e) {
        e.printStackTrace();
    }

}
@RequestMapping("/login")
public void test05(HttpServletRequest req, HttpServletResponse resp) throws IOException {
String username = req.getParameter("username");
String password = req.getParameter("password");

List<Users> usersList = managementService.selectUsers02();
    for (Users user: usersList) {
        if (user.getUsername().equals(username)){
            if (user.getPassword().equals(password)){
                HttpSession session = req.getSession();
                session.setAttribute("user_id", user.getId());
                session.setAttribute("username",user.getUsername());
                session.setAttribute("role_name",user.getRole_name());
                session.setAttribute("authority_level",user.getAuthority_level());
                resp.getWriter().append(JSON.toJSONString("登陆成功"));
                return;
            }
            resp.getWriter().append(JSON.toJSONString("密码不正确"));
        }
    }
    resp.getWriter().append(JSON.toJSONString("账号不存在"));
}
@RequestMapping("/removeManagements")
public void test06(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    Integer id = Integer.parseInt(req.getParameter("id"));
    Integer authority_level = Integer.parseInt(req.getSession().getAttribute("authority_level").toString());
    Integer alert_level = Integer.parseInt(req.getParameter("authority_level"));


    if (alert_level==1&&authority_level ==1){
        resp.getWriter().append(JSON.toJSONString("你是超管！删你自己？"));
        return;
    }


        else if (alert_level==1 ){
            resp.getWriter().append(JSON.toJSONString("您以为您比\"超级管理员\"还屌？"));
            return;
        }

    else if (authority_level>=alert_level){
        resp.getWriter().append(JSON.toJSONString("您没有移除此管理员的权限"));
        return;
    }



    int row1 = managementService.removeManagements(id);
    int row2 = managementService.restoreRoleName(id);
    int row3 = managementService.addRoleName(id,"普通用户");
    int row4 = managementService.updateAuthorityLevel(id,5);
    if (row1>0 &&row2>0){
        resp.getWriter().append(JSON.toJSONString("权限已全部移除"));
    return;
    }else{
        resp.getWriter().append(JSON.toJSONString("未知错误，请重试"));
        return;
    }


}
@RequestMapping("/test01")
public void test07(HttpServletRequest req, HttpServletResponse resp){
    System.out.println(req.getParameter("id"));
    Integer user_id =Integer.parseInt(req.getParameter("id")) ;
    System.out.println("user_id:"+user_id);
    List<Integer> l1 = managementService.userAuthority(user_id);
    System.out.println(l1);
    List<Integer> l2 = managementService.userAuthorityChildren(user_id);
    StringBuffer l01 = new StringBuffer();
    StringBuffer l02 = new StringBuffer();
    for (Integer i: l1) {
        l01.append(i+",");
    }
    for (Integer j:l2 ) {
        l02.append(j+",");
    }
    String a1 = l01.substring(0,l01.length()-1).toString();
    String a2 =l02.substring(0,l02.length()-1).toString() ;
    System.out.println("啊哈？:"+a1);
    System.out.println(a2);
    List<Managements> list = managementService.selectManagementsByName(a1,a2);
    List list01 = new ArrayList();
    for (Managements s : list){
        Map fatherMap = new HashMap();
        fatherMap.put("title",s.getManagements_name());
        List childList = new ArrayList();
        for (ChildManagements ss: s.getChildManagementsList() ) {
            Map childMap = new HashMap();
            childMap.put("title",ss.getChild_name());
            childList.add(childMap);
        }
        fatherMap.put("children",childList);
        list01.add(fatherMap);
    }
    try {
        resp.getWriter().append(JSON.toJSONString(list01));
    } catch (IOException e) {
        e.printStackTrace();
    }
}
@RequestMapping("/test03")
public void test08(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    String management_name = req.getParameter("management");
    if(management_name==null){
        String child_name = req.getParameter("child");
        System.out.println(child_name);
        String tree_url = req.getParameter("tree_url");
        Integer father_id = Integer.parseInt(req.getParameter("id"));
                Integer row2 = managementService.addChildManagement(child_name,father_id,tree_url);
                if (row2>0){resp.getWriter().append(JSON.toJSONString("添加成功！"));return;}
        }else{
        Integer row1 = managementService.addManagement(management_name);
        if (row1>0){
            resp.getWriter().append(JSON.toJSONString("添加成功！"));
            return;
        }
    }
    }



}



