package com.example.damuMyschool.controller;

//import com.alibaba.fastjson.JSON;
import com.example.damuMyschool.data.entity.Student;
import com.example.damuMyschool.data.vo.Qid;
import com.example.damuMyschool.service.studentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Resource
    private studentService studentService;

    @PostMapping(value = "/id")
    public Student findStudent(@RequestBody Qid id){
//        Map<String,Object> mp= JSON.parseObject(id,Map.class);
        return studentService.selectStudentById(Integer.parseInt(id.getId()));
    }

    @PostMapping(value = "/mychool")
    public String getMyschool(@RequestBody Qid id){
        //测试调用超时
//        Thread thread= new Thread();
//        try {
//            thread.sleep(6000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return "diaoquchenggong"+id;
    }
}
