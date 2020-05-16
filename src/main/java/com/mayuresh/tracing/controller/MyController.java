package com.mayuresh.tracing.controller;

import com.mayuresh.tracing.config.AppConfig;
import com.mayuresh.tracing.model.Profile;
import com.mayuresh.tracing.service.ProfileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.annotation.RequestScope;

@Slf4j
@RestController
public class MyController {

    @Autowired
    private ProfileService profileService;

    @Autowired
    private AppConfig appConfig;

    @Value("${PROFILE_URL}")
    private String profileUrl;

    @GetMapping("/profile/{userName}")
    public Profile getProfileDetails(@PathVariable String userName) {
        log.info("Started Get Profile Details API Call with Username {}", userName);

        Profile profile = profileService.getUserProfile(userName);

        log.info("Ended Get Profile Details API Call with Username {}", userName);
        return profile;
    }

    @PostMapping("/subscriber")
    public ResponseEntity<Profile> createSubscriber(@RequestBody String userName) {
        log.info("Started Create New Subscriber API Call with Username {}", userName);

        String url = profileUrl + "/" + userName;
        ResponseEntity<Profile> profileResponseEntity = appConfig.restTemplate().getForEntity(url, Profile.class);

        ResponseEntity<Profile> subscriberResponseEntity = new ResponseEntity(profileResponseEntity.getBody(), HttpStatus.CREATED);


        log.info("Started Create New Subscriber API Call with Username {}", profileResponseEntity.getBody().getUserName());
        return subscriberResponseEntity;
    }
}
