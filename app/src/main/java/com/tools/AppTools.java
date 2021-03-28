package com.tools;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.provider.Settings;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.MainActivity;
import com.action.event.Event;

import androidx.annotation.RequiresApi;

import static java.lang.Thread.sleep;

public class AppTools {


    public static int width;
    public static int height;
    public static int statusBarHeight;

    //  public static String server = "http://192.168.0.117:8081/ttqk/manage/";
    public static String server = "http://192.168.28.63:8081/ttqk/manage/";


    public final static int type_tt = 1;
    public final static int type_fb = 2;
    public final static int type_ins = 3;


    public static Event event = null;


    public static void stop(long time) {

        try {
            sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    public static void show(String msg) {
        try {
            System.out.println(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void putTextIntoClip(String text) {
        ClipboardManager clipboardManager = (ClipboardManager) MainActivity.ma.getSystemService(Context.CLIPBOARD_SERVICE);
        //创建ClipData对象
        ClipData clipData = ClipData.newPlainText("simple text copy", text);
        //添加ClipData对象到剪切板中
        clipboardManager.setPrimaryClip(clipData);
    }


    /**
     * @ 获取当前手机屏幕的尺寸(单位:像素)
     */
    public static float getPingMuSize(Context mContext) {
        int densityDpi = mContext.getResources().getDisplayMetrics().densityDpi;
        float scaledDensity = mContext.getResources().getDisplayMetrics().scaledDensity;
        float density = mContext.getResources().getDisplayMetrics().density;
        float xdpi = mContext.getResources().getDisplayMetrics().xdpi;
        float ydpi = mContext.getResources().getDisplayMetrics().ydpi;
        width = mContext.getResources().getDisplayMetrics().widthPixels;
        height = mContext.getResources().getDisplayMetrics().heightPixels;

        // 这样可以计算屏幕的物理尺寸
        float width2 = (width / xdpi) * (width / xdpi);
        float height2 = (height / ydpi) * (width / xdpi);

        return (float) Math.sqrt(width2 + height2);
    }


    public static float[] getLeft(String wz) {
        float[] xy = new float[2];
        String[] wzs = wz.split("_");
        float bwidth = Float.parseFloat(wzs[0]);
        float eleft = Float.parseFloat(wzs[1]);
        float bheight = Float.parseFloat(wzs[2]);
        float etop = Float.parseFloat(wzs[3]);
        float wbl = AppTools.width / bwidth;
        float hbl = AppTools.height / bheight;
        xy[0] = etop * hbl;
        xy[1] = eleft * wbl;
        return xy;
    }


    /**
     * 获取状态栏高度
     *
     * @return
     */
    public static int getStatusBarHeight(Activity mContext) {
        //
//        Rect rect = new Rect();
//        mContext.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
//        statusBarHeight = rect.top; // 状态栏高度
//        int bottomHeight = rect.bottom;// 底部虚拟键盘的

        Resources resources = mContext.getResources();
        int resourceId = resources.getIdentifier("status_bar_height", "dimen", "android");
        statusBarHeight = resources.getDimensionPixelSize(resourceId);

        return statusBarHeight;
    }

    public static WebView getWv(int id) {

        WebView wv = (WebView) MainActivity.ma.findViewById(id);

        wv.setWebChromeClient(new WebChromeClient());

        WebSettings webSettings = wv.getSettings();
        // 让WebView能够执行javaScript
        webSettings.setJavaScriptEnabled(true);
        // 让JavaScript可以自动打开windows
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        // 设置缓存
        webSettings.setAppCacheEnabled(true);
        // 设置缓存模式,一共有四种模式
//        webSettings.setCacheMode(webSettings.LOAD_CACHE_ELSE_NETWORK);
        webSettings.setCacheMode(webSettings.LOAD_NO_CACHE);


        // 设置缓存路径
//        webSettings.setAppCachePath("");
        // 支持缩放(适配到当前屏幕)
        webSettings.setSupportZoom(true);
        // 将图片调整到合适的大小
        webSettings.setUseWideViewPort(true);
        // 支持内容重新布局,一共有四种方式
        // 默认的是NARROW_COLUMNS
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        // 设置可以被显示的屏幕控制
        webSettings.setDisplayZoomControls(true);
        // 设置默认字体大小
        webSettings.setDefaultFontSize(12);

        // 设置WebView属性，能够执行Javascript脚本
        // mWebView.getSettings().setJavaScriptEnabled(true);
        //3、 加载需要显示的网页
        String ua = "Mozilla/5.0 (Linux; Android 9; SM1921 Build/QKQ1.191021; wv) AppleWebKit/537.31 (KHTML, like Gecko) Version/4.0 Chrome/89.0.4389.91 Mobile Safari/537.36";
        webSettings.setUserAgentString(ua);

        removeCookie();
        wv.clearCache(true);
        return wv;
    }

    private static void removeCookie() {
        MainActivity.ma.cookieManager.removeAllCookie();
        CookieSyncManager.getInstance().sync();
    }

    /**
     * 同步一下cookie
     */
//    public static void synCookies(Context context, String url) {
//        CookieSyncManager.createInstance(context);
//        CookieManager cookieManager = CookieManager.getInstance();
//        cookieManager.setAcceptCookie(true);
//        cookieManager.removeSessionCookie();//移除
//        cookieManager.setCookie(url, cookies);//指定要修改的cookies
//        CookieSyncManager.getInstance().sync();
//    }

    String mac = "";
    static String phoneId = "";

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void androidId(Context context) {
        try {
            try {
                phoneId = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
