package cn.edu.gdmec.android.mobileguard.m4appmanager.entity;

import android.content.pm.Signature;
import android.graphics.drawable.Drawable;
import android.hardware.camera2.params.StreamConfigurationMap;

/**
 * Created by Administrator on 2017/11/6 0006.
 */

public class AppInfo {
    /*应用程序包名*/
    public String packageName;
    /*应用程序图标*/
    public Drawable icon;
    /*应用程序名称*/
    public String appName;
    /*应用程序路径*/
    public String apkPath;
    /*应用程序大小*/
    public long appSize;

    /*应用程序版本号*/
    public String appCode;
    /*应用程序安装时间*/
    public long appTime;
    /*应用程序签名信息*/
    public String appSign;
    /*应用程序权限申请信息*/
    public String appPremissions;
    /*应用程序的活动*/
    public String appActivities;


    /*是否是手机储存*/
    public boolean isInRoom;
    /*是否是用户应用*/
    public boolean isUserApp;
    /*是否选中，默认都为false*/
    public boolean isSelected = false;

    /*拿到App位置字符串*/
    public String getAppLocation(boolean isInRoom){
        if (isInRoom) {
            return "手机内存";
        } else {
            return "外部储存";
        }
    }
}







