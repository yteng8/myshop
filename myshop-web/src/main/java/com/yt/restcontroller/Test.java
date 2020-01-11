package com.yt.restcontroller;

import com.yt.service.TestService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Api(description = "用户管理")

public class Test {

    @Autowired
    TestService testService;

    @RequestMapping("hello")
    public List<String> a2(){
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        return list;
    }

    @RequestMapping("hello3")
    public List<String> a3(int a){
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        return list;
    }

    @RequestMapping("hello4")
    public List<String> a4(){
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        System.out.println("--------------------------------");
        testService.aa();

        return list;
    }




}
