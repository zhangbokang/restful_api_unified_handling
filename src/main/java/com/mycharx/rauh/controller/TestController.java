package com.mycharx.rauh.controller;

import com.mycharx.rauh.vo.TestVo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Test controller.
 *
 * @author 张卜亢
 * @date 2019.10.07 21:28:19
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("")
    public List<TestVo> getUserList() {
        List<TestVo> userVoList = new ArrayList<>(2);
        userVoList.add(TestVo.builder().id(1L).name("测试1ceshi").build());
        userVoList.add(TestVo.builder().id(2L).name("测试2ceshi").build());
        return userVoList;
    }

    /**
     * 可以手动控制返回的http状态码，通过ResponseEntity的第二个参数
     *
     * @return the response entity
     */
    @GetMapping("/testResponseEntity")
    public ResponseEntity getTestVoEntity(){
        return new ResponseEntity(TestVo.builder().id(1L).name("日拱一兵").build(), HttpStatus.OK);
    }
}
