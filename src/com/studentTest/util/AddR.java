package com.studentTest.util;

public class AddR {
    //  1002 - 1025
    String sql = "INSERT INTO userchoose(`s_id`,`u_id`,`c_score`) VALUES(1002,'1001',77),(1002,'1002',65),(1002,'1003',45),(1002,'1003',67)";

    public static void main(String[] args) {
        for(int i = 1002;i<=1025;i++){
            int []score = getScore();
            String sql = "INSERT INTO userchoose(`s_id`,`u_id`,`c_score`) VALUES("+ i +",'1001',"+score[0]+"),("+i+",'1002',65),("+i+",'1003',"+score[0]+"),("+i+",'1003',"+score[0]+")";
            //执行
            //Dao.zhixing(sql);
            System.out.println(sql);
        }


    }

    public static int[]getScore(){
        int[] a = new int[3];
        a[0] = (int)(Math.random()*100);
        a[1] = (int)(Math.random()*100);
        a[2] = (int)(Math.random()*100);
        return a;
    }






}

