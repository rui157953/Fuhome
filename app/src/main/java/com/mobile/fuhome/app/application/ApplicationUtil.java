package com.mobile.fuhome.app.application;

/**
 * Created by Administrator on 2014/8/30.
 */

import android.app.Application;
import android.util.Log;

import com.facebook.drawee.backends.pipeline.Fresco;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ApplicationUtil extends Application {

    String str_ip="115.28.93.201";//"192.168.1.107";//目标IP
    //String str_ip="192.168.1.107";//目标IP
    String str_port="7001";//目标端口

    DatagramSocket socket;
    char flag = 0;//1 已经打开
    char lo_flag = 0;//0，1失败，2登录
    char rem = 0;//记录密码

    byte[] getBuf = new byte[1024];//接收缓冲
    DatagramPacket getPacket = new DatagramPacket(getBuf, getBuf.length);//接收数据报
    DatagramPacket packet;//发送包
    InetAddress serverAddress;//服务器IP
    int port;//服务器端口

    String str_openid;
    String str_userid;
    String str_psw;

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        try {
            init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void init() throws IOException,Exception {


        try {

            //首先创建一个DatagramSocket对象
            if (flag == 0) {
                socket = new DatagramSocket(port);
                flag = 1;
            }
            Log.v("初始化", "send_port");

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public DatagramSocket Out_socket()
    {
        return socket;
    }

    public void Close_socket()
    {
       socket.close();
    }

    //登name userid

    public void Set_userid(String openid,String userid,String psw){
        str_openid=openid;
        str_userid=userid;
        str_psw=psw;
    }

    public String Out_openid(){
        return str_openid;
    }

    public String Out_userid(){
       return str_userid;
    }

    public String Out_psw(){
        return  str_psw;
    }
    public String Out_ip(){
        return  str_ip;
    }
    public String Out_port(){
        return  str_port;
    }



}
