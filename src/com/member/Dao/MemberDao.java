package com.member.Dao;
import com.member.utils.DButil;
import com.member.bean.Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDao {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Member> selectAll(){
        try{
            con = DButil.getConnection();
            ps = con.prepareStatement("select * from test_zz");
            // 执行sql
            rs = ps.executeQuery();
            List<Member> memberList = new ArrayList<>();
            while (rs.next()){
                Member member = new Member();
                member.setID(rs.getInt("ID"));
                member.setName(rs.getString("Name"));
                member.setPhone_number(rs.getString("Phone_number"));
                memberList.add(member);
            }
            return memberList;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭链接，避免数据库连接过多
            DButil.close(con, ps, rs);
        }
        return null;
    }

    public StringBuffer ajaxselect(String Name){
        try {
            con = DButil.getConnection();
            ps = con.prepareStatement("select * from test_zz where Name like '%" + Name + "%'");
            rs = ps.executeQuery();
            //List<Member> memberList = new ArrayList<>();
            StringBuffer strb = new StringBuffer();
            strb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            strb.append("<persons>");
            while (rs.next()) {
                strb.append("<person>");
                strb.append("<pid>"+rs.getInt("ID")+"</pid>");
                strb.append("<pname>"+rs.getString("Name")+"</pname>");
                strb.append("<phone>"+rs.getString("Phone_number")+"</phone>");
                strb.append("</person>");
            }
            strb.append("</persons>");
            System.out.println(strb.toString());
            return strb;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭资源，避免出现异常
            DButil.close(con,ps,rs);
        }
        return null;
    }

    public List<Member> selectIDMember(int ID){
        try {
            con = DButil.getConnection();
            ps = con.prepareStatement("select * from test_zz where ID = ?");
            ps.setInt(1,ID);
            rs = ps.executeQuery();
            List<Member> memberList = new ArrayList<>();
            while (rs.next()) {
                Member member = new Member();
                member.setID(rs.getInt("ID"));
                member.setName(rs.getString("Name"));
                member.setPhone_number(rs.getString("Phone_number"));
                memberList.add(member);
            }
            return memberList;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭资源，避免出现异常
            DButil.close(con,ps,rs);
        }
        return null;
    }


    public boolean addMember(String Name,String Phone_number){
        try {
            con = DButil.getConnection();
            ps = con.prepareStatement("insert into test_zz values (null,?,?)");
            //ps.setInt(1,ID);
            ps.setString(1,Name);
            ps.setString(2,Phone_number);
            int count = ps.executeUpdate();
            if(count > 0){
                return true;
            }else{
                return false;
            }
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            // 关闭资源，避免出现异常
            DButil.close(con,ps,rs);
        }
        return false;
    }

    public boolean deleteMember(int ID){
        try{
            con = DButil.getConnection();
            ps = con.prepareStatement("delete from test_zz where ID = ?");
            ps.setInt(1,ID);
            int count = ps.executeUpdate();
            if(count > 0){
                return true;
            }else{
                return false;
            }
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            // 关闭资源，避免出现异常
            DButil.close(con,ps,rs);
        }
        return false;
    }

    public boolean updateMember(int ID,String Name,String Phone_number){
        try {
            con = DButil.getConnection();
            ps = con.prepareStatement("update test_zz set Name = ?,Phone_number = ? where Id = ?");
            ps.setInt(3,ID);
            ps.setString(1,Name);
            ps.setString(2,Phone_number);
            int count = ps.executeUpdate();
            if(count > 0){
                return true;
            }else{
                return false;
            }
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            // 关闭资源，避免出现异常
            DButil.close(con,ps,rs);
        }
        return false;
    }
}
