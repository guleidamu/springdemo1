package com.example.businessdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BusinessdemoApplicationTests {

    @Test
    public void contextLoads() {

     int a[] = {5,3,34,15,6,88};
     for (int i = 0; i <a.length; i++){
         for(int j = 0; j<a.length-1-i; j++){
             if(a[j] > a[j+1]){
                 int temp = a[j];
                 a[j] = a[j+1];
                 a[j+1] = temp;
              }
         }
     }
     for(int k = 0; k<a.length;k++){
         System.out.print(a[k]+" ");
     }

    }

}

