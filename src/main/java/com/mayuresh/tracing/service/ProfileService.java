package com.mayuresh.tracing.service;

import com.mayuresh.tracing.model.Profile;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    public Profile getUserProfile(String userName) {
        Profile profile = new Profile();
        profile.setId(1001);
        profile.setContactNumber("9999999999");
        profile.setUserName(userName);

        return profile;
    }
}
