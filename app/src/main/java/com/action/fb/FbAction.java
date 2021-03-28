package com.action.fb;

import android.os.Build;
import android.os.Message;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.MainActivity;
import com.action.Action;
import com.tools.AppTools;

import androidx.annotation.RequiresApi;

public class FbAction implements Action {

    MainActivity context;
    public WebView wv;


    public FbAction() {
        this.context = MainActivity.ma;
        this.wv = MainActivity.ma.fb;
        wv.setWebViewClient(new MyWebViewClient(this));
        loadUrl();
    }


    public void loadUrl() {
        wv.loadUrl(url);
    }

//    private void clearCache(){
//        File file = wv.getCacheDir().getAbsoluteFile();//删除缓存
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


//        if (AppTools.cl == null || AppTools.cl.isEnd) {
//            if (sleepTime > 0)
//                AppTools.stop(sleepTime);
//            sleepTime = 0;
//
//        }
//



        go();

    }

    public final String url = "https://m.facebook.com/";

//  public final String url_login = "https://www.instagram.com/";

    public String action;


    public final String action_create = "create";


    public final String action_login = "login";

    public long sleepTime = 0;
    ActionCreateAccount aca;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public long action() {
        switch (action) {
            case action_create:
                if (aca == null) {
                    aca = new ActionCreateAccount(wv);
                }
                sleepTime = aca.action();
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
        FbAction insa;

        public MyWebViewClient(FbAction insa) {
            this.insa = insa;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            insa.setUrl(url);
        }


    }


}
