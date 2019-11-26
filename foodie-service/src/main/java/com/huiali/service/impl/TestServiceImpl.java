package com.huiali.service.impl;

import com.huiali.mapper.TestMapper;
import com.huiali.pojo.Test;
import com.huiali.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestMapper testMapper;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Test get(int id) {
        return testMapper.selectByPrimaryKey(id);
    }


    /**
     *  事务传播 -Propagation
     *  REQUIRED 默认传播方式
     *  SUPPORTS
     *  MANDATORY
     *  NESTED
     *  NEVER
     *  NOT_SUPPORTED
     *  REQUIRES_NEW
     */

//    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void save() {
        saveParent();
        saveChildren();
    }

    public void saveParent() {
        Test obj = new Test();
        obj.setName("parent");
        obj.setAge(10);
        testMapper.insert(obj);
    }

    public void saveChildren() {
        saveChildren1();
        int a = 1 / 0;
        saveChildren2();
    }

    public void saveChildren1() {
        Test obj = new Test();
        obj.setName("children-1");
        obj.setAge(10);
        testMapper.insert(obj);
    }

    public void saveChildren2() {
        Test obj = new Test();
        obj.setName("children-2");
        obj.setAge(10);
        testMapper.insert(obj);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void update(int id) {
        Test obj = testMapper.selectByPrimaryKey(id);
        obj.setAge(20);
        testMapper.updateByPrimaryKey(obj);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void delete(int id) {
        Test obj = testMapper.selectByPrimaryKey(id);
        testMapper.delete(obj);
    }
}
