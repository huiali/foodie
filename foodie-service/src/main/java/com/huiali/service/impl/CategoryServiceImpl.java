package com.huiali.service.impl;

import com.huiali.mapper.CategoryMapper;
import com.huiali.pojo.Category;
import com.huiali.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Category getCategory(int id) {
        return categoryMapper.selectByPrimaryKey(id);
    }
}
