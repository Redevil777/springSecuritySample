package com.websystique.springmvc.service;


import com.websystique.springmvc.dao.UserProfileDao;
import com.websystique.springmvc.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userProfileService")
@Transactional
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    UserProfileDao dao;

    @Override
    public UserProfile findById(int id) {
        return dao.findById(id);
    }

    @Override
    public UserProfile findByType(String type) {
        return dao.findByType(type);
    }

    @Override
    public List<UserProfile> findAll() {
        return dao.findAll();
    }
}
