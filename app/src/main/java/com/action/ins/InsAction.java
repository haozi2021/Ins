package com.action.ins;

import android.os.Build;
import android.os.Message;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.MainActivity;
import com.action.Action;
import com.tools.AppTools;

import androidx.annotation.RequiresApi;

public class InsAction implements Action {

    MainActivity context;
    public WebView wv;


    public InsAction() {
        this.context = MainActivity.ma;
        this.wv = MainActivity.ma.fb;
        wv.setWebViewClient(new InsAction.MyWebViewClient(this));
        loadUrl();
    }

    public void loadUrl() {
        wv.loadUrl(url);
    }

    String cookie = "ig_did=CB14A08D-5805-424F-A729-7C989ECCC2F6; mid=YFL2nAABAAGh3NL4vh-NuY-ssb4U; ig_nrcb=1; csrftoken=ydMWmjgN1ABHcgCbJUzbu63CYjf1KKYs; ds_user_id=45787204593; sessionid=45787204593%3AlDM78o1aSTwLWo%3A15; shbid=19082; shbts=1616049848.1034172; rur=PRN; ig_direct_region_hint=FRC";

    public static void synCookies(String url, String cookie) {
        MainActivity.ma.cookieManager.setCookie(url, cookie);
        CookieSyncManager.getInstance().sync();
    }


    private void removeCookie() {
        MainActivity.ma.cookieManager.removeAllCookie();
        CookieSyncManager.getInstance().sync();
    }


    String nowUrl = "";


    public void setUrl(String url) {
        this.nowUrl = url;
    }


    public void step() {
        go();
    }


    public final String url = "https://www.instagram.com/";

    public String action;


//    public final String action_create = "create";


    public final String action_cultivate = "cultivate";


    public long sleepTime = 0;
    ActionCultivate al;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public long action() {
        switch (action) {
            case action_cultivate:
                if (al == null) {
                    al = new ActionCultivate(wv);
                }
                sleepTime = al.action();
                break;
        }
        return sleepTime;
    }

    @Override
    public boolean isFinish() {
        return false;
    }

    public int getType() {
        return AppTools.type_fb;
    }

    public void go() {
        Message message = Message.obtain();
        message.obj = this;
        context.action.sendMessage(message);
    }


    class MyWebViewClient extends WebViewClient {
        InsAction insa;

        public MyWebViewClient(InsAction insa) {
            this.insa = insa;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            insa.setUrl(url);
        }


    }


}


//        removeCookie();
//        CookieManager.getInstance().removeSessionCookie();


//        String loginCookies = MainActivity.ma.cookieManager.getCookie(url_login);
//
//        System.out.println(loginCookies);
//
//        String[] cs = cookie.split(" ");
//
//        for (int i = 0; i < cs.length; i++) {
//            synCookies(url_login, cs[i]);
//        }
//
//
//        loginCookies = MainActivity.ma.cookieManager.getCookie(url_login);
//
//        System.out.println(loginCookies);


//
//
//
//        context.deleteDatabase("webview.db");
//        context.deleteDatabase("webviewCache.db");
//        String loginCookies = MainActivity.ma.cookieManager.getCookie(url_login);
//
//        System.out.println(loginCookies);


//        String loginCookies = MainActivity.ma.cookieManager.getCookie(url_login);
//
//        System.out.println(loginCookies);

//        String[] cs = cookie.split(" ");
//
//        for (int i = 0; i < cs.length; i++) {
//            synCookies(url_login, cs[i]);
//        }


//    private void clearCache(){
//        File file = ins.getCacheDir().getAbsoluteFile();//删除缓存
//        deleteFile(file);
//    }
//
//    public void deleteFile(File file) {
//        if (file.exists()) {
//            if (file.isFile()) {
//                file.delete();
//            } else if (file.isDirectory()) {
//                File files[] = file.listFiles();
//                for (int i = 0; i < files.length; i++) {
//                    deleteFile(files[i]);
//                }
//            }
//            file.delete();
//        }
//    }


