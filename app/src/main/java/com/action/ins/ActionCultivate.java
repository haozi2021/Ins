package com.action.ins;

import android.os.Build;
import android.webkit.ValueCallback;
import android.webkit.WebView;

import com.action.Action;
import com.action.event.Click;
import com.action.event.LongClick;

import androidx.annotation.RequiresApi;

import com.action.fb.js.FbJs;
import com.action.ins.js.*;
import com.tools.AppTools;

public class ActionCultivate implements Action {

    WebView wv;

    public ActionCultivate(WebView wv) {
        this.wv = wv;
    }

    String url = "https://www.instagram.com/";
    final String step_hasLogin = "step_hasLogin";
    final String step_clickLogin = "step_clickLogin";
    final String step_setName = "step_setName";
    final String step_setPwd = "step_setPwd";

    final String step_submitLogin = "step_submitLogin";


    String step = step_hasLogin;


    final String[] parameter = {"-1"};


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public long action() {

        long sleep = 0;


//        sleep = 10000;
        switch (step) {
            case step_hasLogin:
                hasLogin();
                break;
            case step_clickLogin:
                clickLogin();
                break;
            case step_setPwd:
                setName();
                break;
            case step_setPwd:
                clickPwd();
                break;



//            case step_clickPwd:
//                String clickpwd = InsJs.clickNameJs("password");
//                wv.evaluateJavascript(clickpwd, new ValueCallback<String>() {
//                    @Override
//                    public void onReceiveValue(String value) {
//                        setName[0] = value.replaceAll("\"", "");
//
//                        if (AppTools.lcl != null && AppTools.lcl.isEnd)
//                            AppTools.lcl.isCheck = true;
//
//                        if (setName[0].equals("ok")) {
//                            step = step_submitLogin;
//                        } else if (AppTools.lcl == null || AppTools.lcl.isEnd && AppTools.lcl.isCheck) {
//                            float cleft = 0;
//                            float ctop = 0;
//                            if (setName[0].indexOf("_") != -1) {
//                                String[] wzs = setName[0].split("_");
//                                float bwidth = Float.parseFloat(wzs[0]);
//                                float eleft = Float.parseFloat(wzs[1]);
//                                float bheight = Float.parseFloat(wzs[2]);
//                                float etop = Float.parseFloat(wzs[3]);
//                                float wbl = AppTools.width / bwidth;
//                                float hbl = AppTools.height / bheight;
//                                ctop = etop * hbl;
//                                cleft = eleft * wbl;
//                            }
//                            ctop = ctop + AppTools.statusBarHeight + 10;
//                            cleft = cleft + 10;
//                            String dd = AppTools.width + "  " + AppTools.height;
//
//
//                            if (AppTools.lcl == null || AppTools.lcl.isEnd) {
//
//                                AppTools.putTextIntoClip("a11271127");
//
//                                AppTools.lcl = new LongClick((int) cleft, (int) ctop);
//                                AppTools.lcl.start();
//
//                            }
//
//                        }
//
//                    }
//                });
//
//
//                sleep = 3000;
//                break;


//            case step_setName:
//                if (setName[0].equals("1")) {
//                    step = step_clickPwd;
//                } else {
//
//                    String setname = InsJs.setNameJs("username","jasmin.miller.16752");//, "a11271127"
//                    ins.evaluateJavascript(setname, new ValueCallback<String>() {
//                        @Override
//                        public void onReceiveValue(String value) {
//                            setName[0] = value;
//                        }
//                    });
//                }
//
//
//                sleep = 3000;
//                break;

//            case step_clickPwd:
//                String  clickPwd = InsJs.clickNameJs("password");
//                ins.evaluateJavascript(clickPwd, new ValueCallback<String>() {
//                    @Override
//                    public void onReceiveValue(String value) {
//                        setName[0] = value.replaceAll("\"","");
//                        float cleft = 0;
//                        float ctop = 0;
//                        if (setName[0].indexOf("_") != -1) {
//                            String[] wzs = setName[0].split("_");
//                            float bwidth = Float.parseFloat(wzs[0]);
//                            float eleft = Float.parseFloat(wzs[1]);
//                            float bheight = Float.parseFloat(wzs[2]);
//                            float etop = Float.parseFloat(wzs[3]);
//                            float wbl = AppTools.width / bwidth;
//                            float hbl = AppTools.height / bheight;
//                            ctop = etop * hbl;
//                            cleft = eleft * wbl;
//                        }
//                        ctop = ctop + AppTools.statusBarHeight + 10;
//                        cleft = cleft + 10;
//                        String dd = AppTools.width + "  " + AppTools.height;
//                        if (AppTools.cl == null || AppTools.cl.isEnd) {
//                            AppTools.cl = new Click((int) cleft, (int) ctop, 3);
//                            AppTools.cl.start();
//                            step = step_setPwd;
//                        }
//                    }
//                });
//
//                sleep = 3000;
//                break;
//
//            case step_setPwd:
//                if (setPwd[0].equals("1")) {
//                    step = step_submitLogin;
//                } else {
//                    String setname = InsJs.setNameJs("password","a11271127");//, "a11271127"
//                    ins.evaluateJavascript(setname, new ValueCallback<String>() {
//                        @Override
//                        public void onReceiveValue(String value) {
//                            setName[0] = value;
//                        }
//                    });
//                }
//                break;
//
//
//
////            ins.loadUrl(InsJs.setName);
//
        }


        return sleep;

    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    void hasLogin() {

        if (parameter[0].equals("1")) {
            setStop(step_clickLogin);
        } else {
            String findCreate = FbJs.hasElement("button", "innerText", "Log In");
            wv.evaluateJavascript(findCreate, new ValueCallback<String>() {
                @Override
                public void onReceiveValue(String value) {
                    parameter[0] = value;
                }
            });
        }

    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    void clickLogin() {
        final String clickCreatejs = FbJs.getXy_Element("button", "innerText", "Log In");
        wv.evaluateJavascript(clickCreatejs, new ValueCallback<String>() {
            @Override
            public void onReceiveValue(String value) {
                parameter[0] = value.replaceAll("\"", "");
                if (AppTools.event == null || AppTools.event.isEnd()) {
                    float[] xy = null;
                    if (parameter[0].indexOf("_") != -1) {
                        xy = AppTools.getLeft(parameter[0]);
                        xy[0] = xy[0] + AppTools.statusBarHeight + 10;
                        xy[1] = xy[1] + 10;
//                                String dd = AppTools.width + "  " + AppTools.height;
                        AppTools.event = new Click((int) xy[0], (int) xy[1], 1);
                    } else if (parameter[0].equals("0")) {
                        setStop(step_setName);
                    }
                }
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    void setName() {



        String clickname = FbJs.getXy_Element_long("input", "name", "username");
        wv.evaluateJavascript(clickname, new ValueCallback<String>() {
            @Override
            public void onReceiveValue(String value) {
                parameter[0] = value.replaceAll("\"", "");
                if (AppTools.event == null || AppTools.event.isEnd()) {
                    float[] xy = null;
                    if (parameter[0].indexOf("_") != -1) {
                        xy = AppTools.getLeft(parameter[0]);
                        xy[0] = xy[0] + AppTools.statusBarHeight + 10;
                        xy[1] = xy[1] + 10;
                        AppTools.putTextIntoClip(lastName.firstName);
                        AppTools.event = new LongClick((int) xy[0], (int) xy[1]);
                    } else if (parameter[0].equals("@" + lastName.firstName)) {
                        step = step_setLastName;
                    } else if (parameter[0].contains("@") && parameter[0].length() > 2) {
                        step = step_hasMonth;
                    }
                }
            }
        });



    }





    public void setStop(String step) {
        this.step = step;
        parameter[0] = "-1";
    }


    boolean isFinish = false;

    @Override
    public boolean isFinish() {
        return isFinish;
    }

    @Override
    public void step() {

    }

    @Override
    public int getType() {
        return AppTools.type_ins;
    }


//    public void action() {
//
//
//    }


}
