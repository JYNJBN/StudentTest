package com.studentTest.service;

import com.studentTest.bean.Course;
import com.studentTest.bean.Major;
import com.studentTest.bean.User;

import java.util.ArrayList;

public interface FileService {
    ArrayList<User> getAllStudent();

    User getFileByNameOrId(String v);

    User getAdmine(String id);

    ArrayList getPersonFile(String studentId);

    public void insertScore(int u_id, String c_id, int c_score);

    void del(String stu);

    void upScore(String stuId, String a, String b, String c, String d);
    int createStu(String name,String phone);
    ArrayList<Course> getAllCourse();
}
