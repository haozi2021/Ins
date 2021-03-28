package com;


import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;


import com.action.Action;
import com.action.WorkLine;
import com.action.ins.R;
//import com.http.ImapFetchMail;
import com.tools.AppTools;
import com.tools.Utf7ImeHelper;
import com.utf7ime2.test;

import androidx.annotation.RequiresApi;

public class MainActivity extends Activity {

    public static MainActivity ma;

    public CookieManager cookieManager;

    public WebView ins;
    public WebView fb;
    public WebView tt;

    WorkLine wl;


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.ma = this;

        CookieSyncManager.createInstance(this);

        cookieManager = CookieManager.getInstance();
        setContentView(R.layout.activity_main);
        AppTools.androidId(this);


        AppTools.getPingMuSize(this);
        AppTools.getStatusBarHeight(this);
//        ins = AppTools.getWv(R.id.ins);
        fb = AppTools.getWv(R.id.fb);
//        fb.loadUrl("https://m.facebook.com/");
//        tt = AppTools.getWv(R.id.tt);



        wl = new WorkLine();
        wl.start();

    }



    public Handler tt3 = new Handler() {
        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        public void handleMessage(Message msg) {
            EditText ed = ma.findViewById(R.id.fb);


            String dd = Utf7ImeHelper.e("的士速");
            ed.setText(dd);



        }
    };




    public Handler action = new Handler() {
        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        public void handleMessage(Message msg) {
            Action action = (Action) msg.obj;
            int type = action.getType();
//            closeWv(type);
            action.action();

//            insa.ins.loadUrl("javascript: alert('hello');");
//            String dd = "javascript:var bs = document.getElementsByTagName('button');alert(bs.length);";
//            insa.ins.loadUrl(dd);
//            document.getElementsByClassName('sqdOP')

        }
    };

    public static void synCookies(String url, String cookie) {
        MainActivity.ma.cookieManager.setCookie(url, cookie);
        CookieSyncManager.getInstance().sync();
    }


    private void closeWv(int type) {
        fb.setVisibility(View.GONE);
        tt.setVisibility(View.GONE);
        ins.setVisibility(View.GONE);
        switch (type) {
            case AppTools.type_tt:
                tt.setVisibility(View.VISIBLE);
                break;
            case AppTools.type_fb:
                fb.setVisibility(View.VISIBLE);
                break;
            case AppTools.type_ins:
                ins.setVisibility(View.VISIBLE);
                break;
        }
    }


    public Handler hintInpu = new Handler() {
        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        public void handleMessage(Message msg) {
            hintInputMethodManager();

        }
    };


    public void hintInputMethodManager() {
//        InputMethodManager imm = (InputMethodManager) MainActivity.ma.getSystemService( INPUT_METHOD_SERVICE);
//        //隐藏键盘
//        imm.hideSoftInputFromWindow(mEditMessage.getWindowToken(), 0);
//
//
//        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

        InputMethodManager imm = (InputMethodManager) MainActivity.ma.getSystemService( INPUT_METHOD_SERVICE);
        if (imm.isActive()) {
//如果开启
            imm.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT, InputMethodManager.HIDE_NOT_ALWAYS);
//关闭软键盘，开启方法相同，这个方法是切换开启与关闭状态的
        }

    }


}