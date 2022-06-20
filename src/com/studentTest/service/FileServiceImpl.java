package com.studentTest.service;

import com.studentTest.bean.Course;
import com.studentTest.bean.Major;
import com.studentTest.bean.User;
import com.studentTest.dao.FileDao;
import com.studentTest.dao.FileDaoImpl;

import java.util.ArrayList;

public class FileServiceImpl implements FileService{
    FileDao fs = new FileDaoImpl();
    @Override
    public ArrayList<User> getAllStudent() {

        return fs.getAllStudent();
    }

    @Override
    public User getFileByNameOrId(String v) {
        return fs.getFileByNameOrId(v);
    }

    @Override
    public User getAdmine(String id) {
        return fs.getAdmine(id);
    }

    @Override
    public ArrayList getPersonFile(String studentId) {
        return fs.getPersonFile(studentId);
    }

    @Override
    public void del(String stu) {
        fs.del(stu);
    }

    @Override
    public void upScore(String stuId, String a, String b, String c, String d) {
        fs.upScore(stuId,a,b,c,d);
    }


    @Override
    public void insertScore(int u_id, String c_id, int c_score) {
        fs.insertScore(u_id,c_id,c_score);
    }

    @Override
    public int createStu(String name, String phone) {
       return fs.createStu(name,phone);
    }

    @Override
    public ArrayList<Course> getAllCourse() {
       return fs.getAllCourse();
    }


}
