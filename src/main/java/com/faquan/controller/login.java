package com.faquan.controller;

import com.faquan.pojo.people;
import com.faquan.pojo.support.FlagCode;
import com.faquan.pojo.support.result;
import com.faquan.service.peopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/login")
public class login {


    @Autowired
    private peopleService ps;

    @PostMapping()
    public result getByUsernameAndPassword(@RequestBody people people) {
        result result = new result();
        System.out.println(people);
        String username = people.username;
        String password = people.password;
        people byUsernameAndPassword = ps.getByUsernameAndPassword(username, password);
        System.out.println(byUsernameAndPassword);
        if (byUsernameAndPassword == null) {
            result.setFlag(FlagCode.GET_FAILED);
        } else {
            result.setFlag(FlagCode.GET_SUCCESS);
            result.setData(byUsernameAndPassword);
        }
        return result;
    }
}

