package com.member.bean;

public class Member {
    private Integer ID;
    private String Name;
    private String Phone_number;

    public Integer getID(){
        return ID;
    }
    public void setID(Integer ID){
        this.ID = ID;
    }
    public String getName(){
        return Name;
    }
    public void setName(String Name){
        this.Name = Name;
    }
    public String getPhone_number(){
        return Phone_number;
    }
    public void setPhone_number(String Phone_number){
        this.Phone_number = Phone_number;
    }
    @Override
    public String toString(){
        return "Member{"+"ID"+ID+",Name='"+Name+'\'' +",Phone_number="+Phone_number+'}';
    }
}
