package com.studentTest.util;

import java.io.*;
/*
* INSERT u_user(u_pwd,u_phone,u_role,u_isdelte,u_name)
VALUES('as','192939',1,0,'周周')
* */
public class getFile {
    public static void main(String[] args) {
        for(int i=0;i<20;i++){
            String name = getName();
            String phone = getPhone();
            String sql = "INSERT u_user(u_pwd,u_phone,u_role,u_isdelte,u_name)" +
                    "VALUES('111aaa','"+phone+"',1,0,'"+name+"')";
            System.out.println(sql);


        }
        System.out.println(getPhone());
    }
    public static String getPhone(){
        int id = (int)(Math.random()*4)+1;
        StringBuilder sb= new StringBuilder("1");
        if(id==1){
            sb.append("55");
        }else if(id==2){
            sb.append("87");
        }else if(id==3){
            sb.append("89");
        }else if(id==4){
            sb.append("78");
        }else {
            sb.append("51");
        }
        for (int i=0;i<8;i++){
            sb.append((int)(Math.random()*10)+"");
        }


        return sb.toString();
    }

    public static String getName(){
        int index1 = (int)(Math.random()*100+1);
        int index2 = (int)(Math.random()*100+1);
        int index3 = (int)(Math.random()*100+1);
        char firstName = getFirstName(index1);
        char lastTName1 = getFirstName(index2);
        char lastTName2 = getFirstName(index3);
        return firstName+""+lastTName1+lastTName2;
    }


    public static char getFirstName(int index){

        char[] xc=  {
                '赵','钱','孙','李','周','吴','郑','王',
                '冯','陈','褚','卫','蒋','沈','韩','杨',
                '朱','秦','尤','许','何','吕','施','张',
                '孔','曹','严','华','金','魏','陶','姜',
                '戚','谢','邹','喻','柏','水','窦','章',
                '云','苏','潘','葛','奚','范','彭','郎',
                '鲁','韦','昌','马','苗','凤','花','方',
                '俞','任','袁','柳','酆','鲍','史','唐',
                '费','廉','岑','薛','雷','贺','倪','汤',
                '滕','殷','罗','毕','郝','邬','安','常',
                '乐','于','时','傅','皮','卞','齐','康',
                '伍','余','元','卜','顾','孟','平','黄',
                '和','穆','萧','尹','姚','邵','湛','汪',
                '祁','毛','禹','狄','米','贝','明','臧',
                '计','伏','成','戴','谈','宋','茅','庞',
                '熊','纪','舒','屈','项','祝','董','梁',
                '杜','阮','蓝','闵','席','季','麻','强',
                '贾','路','娄','危','江','童','颜','郭',
                '梅','盛','林','刁','钟','徐','邱','骆',
                '高','夏','蔡','田','樊','胡','凌','霍',
                '虞','万','支','柯','昝','管','卢','莫',
                '经','房','裘','缪','干','解','应','宗',
                '丁','宣','贲','邓','郁','单','杭','洪',
                '包','诸','左','石','崔','吉','钮','龚',
                '程','嵇','邢','滑','裴','陆','荣','翁',
                '荀','羊','於','惠','甄','曲','家','封',
                '芮','羿','储','靳','汲','邴','糜','松',
                '井','段','富','巫','乌','焦','巴','弓',
                '牧','隗','山','谷','车','侯','宓','蓬',
                '全','郗','班','仰','秋','仲','伊','宫',
                '宁','仇','栾','暴','甘','钭','厉','戎',
                '祖','武','符','刘','景','詹','束','龙',
                '叶','幸','司','韶','郜','黎','蓟','薄',
                '印','宿','白','怀','蒲','邰','从','鄂',
                '索','咸','籍','赖','卓','蔺','屠','蒙',
                '池','乔','阴','鬱','胥','能','苍','双',
                '闻','莘','党','翟','谭','贡','劳','逄',
                '姬','申','扶','堵','冉','宰','郦','雍',
                '郤','璩','桑','桂','濮','牛','寿','通',
                '边','扈','燕','冀','郏','浦','尚','农',
                '温','别','庄','晏','柴','瞿','阎','充',
                '慕','连','茹','习','宦','艾','鱼','容',
                '向','古','易','慎','戈','廖','庾','终',
                '暨','居','衡','步','都','耿','满','弘',
                '匡','国','文','寇','广','禄','阙','东',
                '欧','殳','沃','利','蔚','越','夔','隆',
                '师','巩','厍','聂','晁','勾','敖','融',
                '冷','訾','辛','阚','那','简','饶','空',
                '曾','毋','沙','乜','养','鞠','须','丰',
                '巢','关','蒯','相','查','后','荆','红',
                '游','竺','权','逯','盖','益','桓','公',
                '万','俟','司','马','上','官','欧','阳',
                '夏','侯','诸','葛','闻','人','东','方',
                '赫','连','皇','甫','尉','迟','公','羊',
                '澹','台','公','冶','宗','政','濮','阳',
                '淳','于','单','于','太','叔','申','屠',
                '公','孙','仲','孙','轩','辕','令','狐',
                '钟','离','宇','文','长','孙','慕','容',
                '鲜','于','闾','丘','司','徒','司','空',
                '丌','官','司','寇','仉','督','子','车',
                '颛','孙','端','木','巫','马','公','西',
                '漆','雕','乐','正','壤','驷','公','良',
                '拓','跋','夹','谷','宰','父','谷','梁',
                '晋','楚','闫','法','汝','鄢','涂','钦',
                '段','干','百','里','东','郭','南','门',
                '呼','延','归','海','羊','舌','微','生',
                '岳','帅','缑','亢','况','郈','有','琴',
                '梁','丘','左','丘','东','门','西','门',
                '商','牟','佘','佴','伯','赏','南','宫',
                '墨','哈','谯','笪','年','爱','阳','佟',
                '第','五','言','福','百','家','姓','终',
        };



        return xc[index];
    }


    public static void reform(){
        File f = new File("F:\\b.txt");
        BufferedReader br =null;
        InputStreamReader isr=null;
        try {
            isr= new InputStreamReader(new FileInputStream(f), "utf-8");
            br=new BufferedReader(isr);
            String line=null;

            while((line=br.readLine())!=null){
                StringBuilder sb = new StringBuilder();
                for(int i=0;i<line.length()-1;i++){
                    if(i!=4){
                        sb.append("'");
                        if(i!=8){
                            sb.append(line.charAt(i)+"',");
                        }else{
                            sb.append(line.charAt(i)+"'");
                        }

                    }

                }

                line = line.replace(line,sb.toString());
                System.out.println(line+"'");
            }




        } catch (FileNotFoundException e) {

            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }


}
