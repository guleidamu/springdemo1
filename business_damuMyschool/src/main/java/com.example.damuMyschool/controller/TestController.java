package com.example.damuMyschool.controller;

import com.example.damuMyschool.data.entity.Filter;
import com.example.damuMyschool.data.entity.Grade;
import com.example.damuMyschool.data.entity.Student;
import com.example.damuMyschool.service.FilterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/test")
public class TestController {
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Resource
    private FilterService filterservice;

    @PostMapping(value="/version")
    public List<Filter> findFilterByNo(){
        List<Filter> filters =new ArrayList<Filter>();
        List<Filter> intersection = new ArrayList<Filter>();
        List<Integer> integerList = new ArrayList<Integer>();
        integerList.add(1);
        integerList.add(2);
        int j=0;
        for(Integer i:integerList){
            List<Filter> temp = new ArrayList<Filter>();
            filters = filterservice.getFilterByNo(i);
            for(Filter fvno:filters){
                fvno.setVersionno(5);
            }
            if(j ==0){
                intersection = filters;
                j++;
            }else {
                for(Filter f1:intersection){
                    for(Filter f2:filters){
                        if(f1.equals(f2)){
                            temp.add(f1);
                        }
                    }
                    intersection = temp;
                }
//                intersection.retainAll(filters);
//                filters.retainAll(intersection);
                System.out.println("交集"+intersection);
            }

        }
        return intersection;

    }

    @PostMapping(value = "/intersection")
    public void getIntersection(){
        List<Filter> filters = filterservice.getFilterByNo(1);
        List<Filter> filters1 = filterservice.getFilterByNo(1);
        filters.retainAll(filters1);
        System.out.println(filters);

        List<String> listA = new ArrayList<String>();
        List<String> listB = new ArrayList<String>();
        listA.add("A");
        listA.add("B");
        listB.add("A");
        listB.add("C");

        listA.retainAll(listB);
        System.out.println("jiaoji"+listA);
    }

    @PostMapping(value = "/equal")
    public void findStudent(){
        int i =10;
        int j =10;
        String s1 = "kong";
        String s2 = "kong";
        Grade grade1 = new Grade(1,"一年级");
        Grade grade2 = new Grade(1,"一年级");
        System.out.println(grade1.equals(grade2));


        System.out.println("intxiangdeng "+intxiangdeng(i,j));
        System.out.println("stringxd "+ stringxd(s1,s2));
        System.out.println("stringequal "+stringequal(s1,s2));
        System.out.println("objectequal "+objectequal(grade1,grade2));
        System.out.println("objectxd "+objectxd(grade1,grade2));
    }
    public boolean stringequal(String s1,String s2){
        return s1.equals(s2);
    }

    public boolean stringxd(String s1,String s2){
        return s1 ==s2;
    }

    public boolean intxiangdeng(int m,int n){
        return m==n;
    }

    public boolean objectequal(Object object1,Object object2){
        return object1.equals(object2);
    }

    public boolean objectxd(Object object1,Object object2){
        return object1 == object2;
    }

    //CollectionUtils是个工具类，提供了很多对集合的操作方法
//    判空
//    CollectionUtils.isEmpty(resultApply);
//
//    CollectionUtils.union(listA,listB);
//
//    intersection(listA,listB)
//
//        isEqualCollection(listA,listB)
}
