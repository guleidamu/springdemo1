package com.example.businessdemo.feign.client;

import com.example.businessdemo.data.vo.Qid;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "business-damumyschool")
public interface ExtractData {

    @RequestMapping("/student/mychool")
    String getMyschool(@RequestBody Qid id);
}
