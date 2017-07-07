package com.email.service;

import com.email.common.inject.annotation.BaseComponent;
import com.email.common.service.BaseService;
import com.email.entity.User;
import com.email.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/2/18.
 */
@Service
public class UserService extends BaseService<User, Integer> {
    @Autowired
    @BaseComponent
    private UserRepository userRepository;
}
