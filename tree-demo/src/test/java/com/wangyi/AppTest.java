package com.wangyi;

import static org.junit.Assert.assertTrue;

import com.wangyi.mapper.ManagementServiceMapper;
import com.wangyi.service.ManagementService;
import com.wangyi.service.managementServiceImpl.ManagementServiceImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void test(){
        List<Integer> l1 = new ArrayList<>();
        l1.add(1);l1.add(1);l1.add(4);
        StringBuffer ll = new StringBuffer();
        for (Integer i: l1) {
            ll.append(i+",");
        }
        System.out.println(ll.substring(0,ll.length()-1).toString());
    }


}

