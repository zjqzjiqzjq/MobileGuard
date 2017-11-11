package cn.edu.gdmec.android.mobileguard.m4appmanager.utils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Debug;
import android.widget.Toast;

import java.io.File;

import cn.edu.gdmec.android.mobileguard.App;
import cn.edu.gdmec.android.mobileguard.m4appmanager.AppManagerActivity;
import cn.edu.gdmec.android.mobileguard.m4appmanager.adapter.AppManagerAdapter;
import cn.edu.gdmec.android.mobileguard.m4appmanager.entity.AppInfo;

import static android.app.AlertDialog.*;

/**
 * Created by Administrator on 2017/11/6 0006.
 */

public class EngineUtils {
    /**
     * 分享应用
     */
    public static void shareApplication(Context context, AppInfo appInfo) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, "推荐您使用一款软件，名称叫：" + appInfo.appName + "下载路径：https://play.google.com/store/apps/details?id=" + appInfo.packageName);
        context.startActivity(intent);
    }

    /**
     * 开启应用程序
     */
    public static void startApplication(Context context, AppInfo appInfo) {
        PackageManager pm = context.getPackageManager();
        Intent intent = pm.getLaunchIntentForPackage(appInfo.packageName);
        if (intent != null) {
            context.startActivity(intent);
        } else {
            Toast.makeText(context, "该应用没有启动界面", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 开启应用设置界面
     *
     * @param context
     * @param appInfo
     */
    public static void SettingAppDetail(Context context, AppInfo appInfo) {
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.setData(Uri.parse("package:" + appInfo.packageName));
        context.startActivity(intent);
    }

    /**
     * 卸载应用
     */
    public static void uninstallApplication(Context context, AppInfo appInfo) {
        if (appInfo.isUserApp) {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_DELETE);
            intent.setData(Uri.parse("package:" + appInfo.packageName));
            context.startActivity(intent);
        } else {
            Toast.makeText(context, "系统应用无法卸载", Toast.LENGTH_LONG).show();
        }
    }
    /**
     * 关于应用
     */
    public static void aboutApplication(final Context context, AppInfo appInfo) {
        PackageManager pm = context.getPackageManager();
        try {
            PackageInfo packageInfo = pm.getPackageInfo(context.getPackageName(),0);
            float code = appInfo.appCode;
            String aname = appInfo.appName;
            //String aper = appInfo.appPermissions;

            AlertDialog.Builder builder = new Builder(context);
            builder.setTitle(aname);
            builder.setMessage("Version:" + code + "\nInstall time" + "\nCertificate issuer:" +"\n\nPermissions:");
            builder.setPositiveButton( "ok", new OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            } );
            builder.show();

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }





    }

    /*public void aboutAppAialog(Context context, AppInfo appInfo){


    }
*/
}









