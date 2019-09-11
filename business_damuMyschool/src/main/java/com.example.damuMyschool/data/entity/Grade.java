package com.example.damuMyschool.data.entity;


public class Grade {

    public int getGradeNo() {
        return gradeNo;
    }

    public void setGradeNo(int gradeNo) {
        this.gradeNo = gradeNo;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    private int gradeNo;

    private String gradeName;

    public Grade(int gradeNo,String gradeName){
        this.gradeNo = gradeNo;
        this.gradeName = gradeName;
    }
}
