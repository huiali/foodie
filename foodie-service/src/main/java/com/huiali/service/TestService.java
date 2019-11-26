package com.huiali.service;

import com.huiali.pojo.Test;

public interface TestService {
    Test get(int id);

    void save();

    void update(int id);

    void delete(int id);
}
