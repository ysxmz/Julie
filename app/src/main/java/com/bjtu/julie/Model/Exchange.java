package com.bjtu.julie.Model;

/**
 * Created by dadada on 2018/3/31.
 */
//信息实体类
public class Exchange {
    private String name; //内容
    private  int imageId; //用户头像
    public Exchange(String name,int imageId){
        this.name=name;
        this.imageId=imageId;
    }
    public String getName(){
        return name;
    }
    public int getImageId(){
        return imageId;
    }
}
