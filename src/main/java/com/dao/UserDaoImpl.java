package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.User;
import com.utils.DBconn;

public class UserDaoImpl implements UserDao {
    @Override
    public boolean register(User user) {
        boolean flag = false;
        DBconn.init();
        int i = DBconn.addUpdDel("insert into user(name, pwd, sex, home, info)" +
                "values('"+ user.getName() + "','"+ user.getPwd() + "', '"+ user.getSex()+"', '"+ user.getHome()+"', '"+user.getInfo()+"')");
        if (i > 0) {
            flag = true;
        }
        DBconn.closeConn();
        return flag;
    }
    public boolean login(String name, String pwd) {
        boolean flag = false;
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from user where name='"+name+"' and pwd='"+pwd+"'");
            System.out.println("rs = " + rs);
            while (rs.next()) {
                if (rs.getString("name").equals(name) && rs.getString("pwd").equals(pwd)) {
                    flag = true;
                }
            }
            DBconn.closeConn();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
    public List<User> getUserAll() {
        List<User> list = new ArrayList<>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from user");
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPwd(rs.getString("pwd"));
                user.setSex(rs.getString("sex"));
                user.setHome(rs.getString("home"));
                user.setInfo(rs.getString("info"));
                System.out.println("user = " + user.getName());
                list.add(user);
            }
            DBconn.closeConn();
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i).getName() + " i");
            }
            System.out.println(list.size() + "list.size()");
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public boolean update(int id, String name, String pwd, String sex, String home, String info) {
        boolean flag = false;
        DBconn.init();
        String sql ="update user set name ='"+name
                +"' , pwd ='"+pwd
                +"' , sex ='"+sex
                +"' , home ='"+home
                +"' , info ='"+info+"' where id = "+id;
        int i = DBconn.addUpdDel(sql);
        if (i > 0) {
            flag = true;
        }
        DBconn.closeConn();
        return flag;
    }
    public boolean delete(int id) {
        boolean flag = false;
        DBconn.init();
        String sql = "delete from user where id =" + id;
        int i = DBconn.addUpdDel(sql);
        System.out.println("i233 = " + i);
        if (i > 0) {
            flag = true;
        }
        DBconn.closeConn();
        return flag;
    }
}
