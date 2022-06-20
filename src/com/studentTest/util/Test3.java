/*
package com.studentTest.util;

import com.studentTest.dao.FileDao;
import com.studentTest.dao.FileDaoImpl;

public class Test3 {
    public static void main(String[] args) {

        for(int i=1002;i<=1025;i++){
            int score[] =new int[4];

            for(int j=0;j<4;j++){
                score[j]=(int)(Math.random()*100);
            }
            String sql = " INSERT INTO userchoose(u_id,c_id,c_score) VALUES("+i+",1001,"+score[0]+"),("+i+",1002,"+score[1]+")," +
                    "("+i+",1003,"+score[2]+"),("+i+",1004,"+score[3]+")";

            FileDaoImpl fd = new FileDaoImpl();
            fd.ins(sql);

        }

    }

}
*/
