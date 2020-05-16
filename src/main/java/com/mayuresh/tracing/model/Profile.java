package com.mayuresh.tracing.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Slf4j
@Data
@Component
@RequestScope
public class Profile {

    private int id;
    private String contactNumber;
    private String userName;

    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id +
                ", name='" + contactNumber + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
