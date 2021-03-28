package com.action.fb;

import android.os.Build;
import android.view.inputmethod.InputMethodManager;
import android.webkit.ValueCallback;
import android.webkit.WebView;

import com.MainActivity;
import com.action.Action;
import com.action.event.Click;
import com.action.event.SendKeycode;
import com.action.fb.js.FbJs;
import com.action.event.LongClick;
import com.http.bean.EmailVo;
import com.http.bean.LastNameVo;
import com.http.bean.ResultVo;
import com.http.bean.TtUserVo;
import com.http.send;
import com.tools.AppTools;
import com.tools.Utf7ImeHelper;

import java.util.List;
import java.util.Random;

import androidx.annotation.RequiresApi;

import static android.content.Context.INPUT_METHOD_SERVICE;


public class ActionCreateAccount implements Action {


//    String url = "https://m.facebook.com/";

    WebView wv;

    public ActionCreateAccount(WebView wv) {
        this.wv = wv;
    }

    final String step_hasCreate = "step_hasCreate";
    final String step_clickCreate = "step_clickCreate";


    final String step_findName = "step_findName";


    final String step_setFirstName = "step_setFirstName";

    final String step_setLastName = "step_setLastName";

    final String step_clickNext = "step_clickNext";
    final String step_hasMonth = "step_hasMonth";

    final String step_selectMonth = "step_selectMonth";

    final String step_selectDay = "step_selectDay";

    final String step_selectYear = "step_selectYear";
    final String step_clickNext2 = "step_clickNext2";

    final String step_clickEmailSignUp = "step_clickEmailSignUp";

    final String step_hasEmail = "step_hasEmail";

    final String step_setEmail = "step_setEmail";


    final String step_clickNext3 = "step_clickNext3";

    final String step_hasGender = "step_hasGender";
    final String step_clickGender = "step_clickGender";

    final String step_clickNext4 = "step_clickNext4";

    final String step_hasPwd = "step_hasPwd";
    final String step_setPwd = "step_setPwd";


    final String step_SignUp = "step_SignUp";

    final String step_getVcode = "step_getVcode";


    final String step_hasLogIn = "step_hasLogIn";


    final String step_clickOk = "step_clickOk";

    final String step_setVcode = "step_setVcode";
    final String step_clickConfirm = "step_clickConfirm";

    final String step_last = "step_last";



    final String step_clickEmail = "step_clickEmail";

    final String step_test = "step_test";

    final String step_test2 = "step_test2";

    final String step_test3 = "step_test3";

    String[] hasCreate = {"-1"};

    String[] hasEmail = {"-1"};

    String[] selectMonth = {"-1"};

    String[] selectDay = {"-1"};

    String[] selectYear = {"-1"};

    String[] hasMonth = {"-1"};

    String[] clickNext = {"-1"};

    String[] clickEmail = {"-1"};

    String[] clickCreate = {"-1"};

    String[] findName = {"-1"};

    String[] setFirstname = {"-1"};

    String[] setLastname = {"-1"};

    String[] hasGender = {"-1"};

    String[] hasPwd = {"-1"};

    String[] setEmail = {"-1"};

    String[] setPwd = {"-1"};
    String[] SignUp = {"-1"};

    String[] hasLogIn = {"-1"};

    String[] clickOk = {"-1"};

    String[] hasFB = {"-1"};

    String[] clickConfirm = {"-1"};
    String[] setVcode = {"-1"};


    public LastNameVo lastName = null;

    public EmailVo email = null;

    String step = "step_hasCreate";
    public TtUserVo userVo = new TtUserVo();

//    String step = step_test;

    public LastNameVo name;
    long getVcodeTime = 0;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public long action() {
        long sleep = 0;
        String nowUrl = wv.getUrl();


        switch (step) {

//            case step_test:
//                String test1 = FbJs.getXy_Element("input", "type", "email");
//                wv.evaluateJavascript(test1, new ValueCallback<String>() {
//                    @Override
//                    public void onReceiveValue(String value) {
//                        clickCreate[0] = value.replaceAll("\"", "");
//                        if (AppTools.event == null || AppTools.event.isEnd()) {
//                            float[] xy = null;
//                            if (clickCreate[0].indexOf("_") != -1) {
//                                xy = AppTools.getLeft(clickCreate[0]);
//                                xy[0] = xy[0] + AppTools.statusBarHeight + 10;
//                                xy[1] = xy[1] + 10;
////                                String dd = AppTools.width + "  " + AppTools.height;
//                                AppTools.event = new Click((int) xy[0], (int) xy[1], 1);
//
//                                step = step_test2;
//                            }
//                        }
//                    }
//                });
//                break;
//
//
//            case step_test2:
//                if (AppTools.event == null || AppTools.event.isEnd()) {
//
//                    String dd = Utf7ImeHelper.e("的士速");
//                    AppTools.event = new SendKeycode(dd);
//                    AppTools.show(dd);
//
////                    step = step_test3;
//
//                }
//
//                break;
            case step_hasCreate:
                if (hasCreate[0].equals("1")) {
                step = step_clickCreate;
            }
//                else if (hasCreate[0].equals("0")) {
//                    step = step_findName;
//                }
                else {
                    String findCreate = FbJs.hasElement("a", "innerText", "Create New Account");
                    wv.evaluateJavascript(findCreate, new ValueCallback<String>() {
                        @Override
                        public void onReceiveValue(String value) {
                            hasCreate[0] = value;
                        }
                    });
                }
                break;
            case step_clickCreate:
                final String clickCreatejs = FbJs.getXy_Element("a", "innerText", "Create New Account");
                wv.evaluateJavascript(clickCreatejs, new ValueCallback<String>() {
                    @Override
                    public void onReceiveValue(String value) {
                        clickCreate[0] = value.replaceAll("\"", "");
                        if (AppTools.event == null || AppTools.event.isEnd()) {
                            float[] xy = null;
                            if (clickCreate[0].indexOf("_") != -1) {
                                xy = AppTools.getLeft(clickCreate[0]);
                                xy[0] = xy[0] + AppTools.statusBarHeight + 10;
                                xy[1] = xy[1] + 10;
//                                String dd = AppTools.width + "  " + AppTools.height;
                                AppTools.event = new Click((int) xy[0], (int) xy[1], 1);
                            } else if (clickCreate[0].equals("0")) {
                                step = step_findName;
                            }
                        }
                    }
                });
                break;
            case step_findName:
                if (findName[0].equals("1")) {

                    ResultVo<List<LastNameVo>> rs = send.getLastName();
                    if (rs != null && rs.code == 0) {
                        lastName = rs.data.get(0);
                        step = step_setFirstName;

                        userVo.firstName = lastName.firstName;
                        userVo.lastName = lastName.lastName;
                        userVo.gender = lastName.gender;
                        userVo.userType = 2;
                    }

                } else {
                    String findFirst = FbJs.hasElement("input", "id", "firstname_input");
                    wv.evaluateJavascript(findFirst, new ValueCallback<String>() {
                        @Override
                        public void onReceiveValue(String value) {
                            findName[0] = value;
                        }
                    });
                }
                break;
            case step_setFirstName:
                String clickname = FbJs.getXy_Element_long("input", "id", "firstname_input");
                wv.evaluateJavascript(clickname, new ValueCallback<String>() {
                    @Override
                    public void onReceiveValue(String value) {
                        setFirstname[0] = value.replaceAll("\"", "");
                        if (AppTools.event == null || AppTools.event.isEnd()) {
                            float[] xy = null;
                            if (setFirstname[0].indexOf("_") != -1) {
                                xy = AppTools.getLeft(setFirstname[0]);
                                xy[0] = xy[0] + AppTools.statusBarHeight + 10;
                                xy[1] = xy[1] + 10;
                                AppTools.putTextIntoClip(lastName.firstName);
                                setFirstNameTiem = System.currentTimeMillis();
                                AppTools.event = new LongClick((int) xy[0], (int) xy[1]);
                            } else if (setFirstname[0].equals("@" + lastName.firstName)) {
                                step = step_setLastName;
                            } else if (setFirstname[0].contains("@") && setFirstname[0].length() > 2) {
                                step = step_hasMonth;
                            }


                        }
                    }
                });
                break;
            case step_setLastName:
                clickname = FbJs.getXy_Element_long("input", "id", "lastname_input");
                wv.evaluateJavascript(clickname, new ValueCallback<String>() {
                    @Override
                    public void onReceiveValue(String value) {
                        setLastname[0] = value.replaceAll("\"", "");
                        if (AppTools.event == null || AppTools.event.isEnd()) {
                            float[] xy = null;
                            if (setLastname[0].indexOf("_") != -1) {
                                xy = AppTools.getLeft(setLastname[0]);
                                xy[0] = xy[0] + AppTools.statusBarHeight + 10;
                                xy[1] = xy[1] + 10;
                                AppTools.putTextIntoClip(lastName.lastName);
                                AppTools.event = new LongClick((int) xy[0], (int) xy[1]);
                            } else if (setLastname[0].equals("@" + lastName.lastName)) {
                                step = step_clickNext;
                            }
                        }
                    }
                });
                break;

            case step_clickNext:
                String clickNextjs = FbJs.getXy_Element("button", "value", "Next");
                wv.evaluateJavascript(clickNextjs, new ValueCallback<String>() {
                    @Override
                    public void onReceiveValue(String value) {
                        clickCreate[0] = value.replaceAll("\"", "");
                        if (AppTools.event == null || AppTools.event.isEnd()) {
                            float[] xy = null;
                            if (clickCreate[0].indexOf("_") != -1) {
                                xy = AppTools.getLeft(clickCreate[0]);
                                xy[0] = xy[0] + AppTools.statusBarHeight + 10;
                                xy[1] = xy[1] + 10;
//                                String dd = AppTools.width + "  " + AppTools.height;
                                AppTools.event = new Click((int) xy[0], (int) xy[1], 1);
                                step = step_hasMonth;
                            } else if (clickCreate[0].equals("0")) {

                            }
                        }
                    }
                });
                break;
            case step_hasMonth:
                if (hasMonth[0].equals("1")) {
                    step = step_selectMonth;
                } else {
                    String selectMonth = FbJs.hasElement("select", "id", "month");
                    wv.evaluateJavascript(selectMonth, new ValueCallback<String>() {
                        @Override
                        public void onReceiveValue(String value) {
                            hasMonth[0] = value;
                        }
                    });
                }
                break;
            case step_selectMonth:
                if (selectMonth[0].equals("1")) {
                    step = step_selectDay;
//                    step = step_selectMonth;
                } else {
                    String selectMonthjs = FbJs.setSelect("select", "id", "month");
                    wv.evaluateJavascript(selectMonthjs, new ValueCallback<String>() {
                        @Override
                        public void onReceiveValue(String value) {
                            selectMonth[0] = value;
                        }
                    });
                }
                break;

            case step_selectDay:

                if (selectDay[0].equals("1")) {
                    step = step_selectYear;
                } else {
                    String selectMonth = FbJs.setSelect("select", "id", "day");
                    wv.evaluateJavascript(selectMonth, new ValueCallback<String>() {
                        @Override
                        public void onReceiveValue(String value) {
                            selectDay[0] = value;
                        }
                    });
                }
                break;
            case step_selectYear:
                if (selectYear[0].equals("1")) {
                    step = step_clickNext2;
                } else {
                    int sz = new Random().nextInt(10);
                    String year = "199" + sz;

                    String selectMonth = FbJs.setSelect_var("select", "id", "year", year);
                    wv.evaluateJavascript(selectMonth, new ValueCallback<String>() {
                        @Override
                        public void onReceiveValue(String value) {
                            selectYear[0] = value;
                        }
                    });
                }
                break;

            case step_clickNext2:
                String clickNextjs2 = FbJs.getXy_Element("button", "value", "Next");
                wv.evaluateJavascript(clickNextjs2, new ValueCallback<String>() {
                    @Override
                    public void onReceiveValue(String value) {
                        clickNext[0] = value.replaceAll("\"", "");
                        if (AppTools.event == null || AppTools.event.isEnd()) {
                            float[] xy = null;
                            if (clickNext[0].indexOf("_") != -1) {
                                xy = AppTools.getLeft(clickNext[0]);
                                xy[0] = xy[0] + AppTools.statusBarHeight + 10;
                                xy[1] = xy[1] + 10;
//                                String dd = AppTools.width + "  " + AppTools.height;
                                AppTools.event = new Click((int) xy[0], (int) xy[1], 1);
                                step = step_clickEmailSignUp;
                            } else if (clickNext[0].equals("0")) {

                            }
                        }
                    }
                });
                break;
            case step_clickEmailSignUp:
                if (clickEmail[0].equals("1")) {
                    step = step_hasEmail;
                } else {
                    String clickEmailjs = FbJs.clickXy_Element("a", "innerText", "Sign Up With Email");
                    wv.evaluateJavascript(clickEmailjs, new ValueCallback<String>() {
                        @Override
                        public void onReceiveValue(String value) {
                            clickEmail[0] = value;
                        }
                    });
                }
                break;


            case step_hasEmail:
                if (hasCreate[0].equals("1")) {
                    if (email == null) {
                        ResultVo<EmailVo> rs = send.queryEmail();
                        if (rs != null && rs.code == 0) {
                            email = rs.data;
                            userVo.userId = email.email;
                            userVo.pwd = email.pwd;
                            if (userVo.pwd.length() < 6)
                                userVo.pwd = "a123456";
                        }
                    }
                    if (email != null) {
                        step = step_setEmail;
                    }
                } else {
                    String findCreate = FbJs.hasElement("div", "innerText", "Email");
                    wv.evaluateJavascript(findCreate, new ValueCallback<String>() {
                        @Override
                        public void onReceiveValue(String value) {
                            hasCreate[0] = value;
                        }
                    });
                }
                break;

            case step_setEmail:
                clickname = FbJs.getXy_Element_long("input", "name", "reg_email__");
                wv.evaluateJavascript(clickname, new ValueCallback<String>() {
                    @Override
                    public void onReceiveValue(String value) {
                        setEmail[0] = value.replaceAll("\"", "");
                        if (AppTools.event == null || AppTools.event.isEnd()) {
                            float[] xy = null;
                            if (setEmail[0].indexOf("_") != -1) {
                                xy = AppTools.getLeft(setEmail[0]);
                                xy[0] = xy[0] + AppTools.statusBarHeight + 10;
                                xy[1] = xy[1] + 10;
                                AppTools.putTextIntoClip(email.email);
                                AppTools.event = new LongClick((int) xy[0], (int) xy[1]);
                            } else if (setEmail[0].equals("@" + email.email)) {
                                step = step_clickNext3;
                            }
                        }
                    }
                });
                break;

            case step_clickNext3:
                String clickNextjs3 = FbJs.getXy_Element("button", "value", "Next");
                wv.evaluateJavascript(clickNextjs3, new ValueCallback<String>() {
                    @Override
                    public void onReceiveValue(String value) {
                        clickNext[0] = value.replaceAll("\"", "");
                        if (AppTools.event == null || AppTools.event.isEnd()) {
                            float[] xy = null;
                            if (clickNext[0].indexOf("_") != -1) {
                                xy = AppTools.getLeft(clickNext[0]);
                                xy[0] = xy[0] + AppTools.statusBarHeight + 10;
                                xy[1] = xy[1] + 10;
//                                String dd = AppTools.width + "  " + AppTools.height;
                                AppTools.event = new Click((int) xy[0], (int) xy[1], 1);
                                step = step_clickGender;
                            } else if (clickNext[0].equals("0")) {

                            }
                        }
                    }
                });
                break;
            case step_hasGender:
                if (hasGender[0].equals("1")) {
                    step = step_clickGender;
                }
//                else if (hasGender[0].equals("0")) {
//                    step = step_hasPwd;
//                }
                else {
                    String selectMonth = FbJs.hasElement("span", "innerText", "Female");
                    wv.evaluateJavascript(selectMonth, new ValueCallback<String>() {
                        @Override
                        public void onReceiveValue(String value) {
                            hasGender[0] = value;
                        }
                    });
                }
                break;


            case step_clickGender:
                String clickFemale = FbJs.getXy_Element("span", "innerText", "Female");
                wv.evaluateJavascript(clickFemale, new ValueCallback<String>() {
                    @Override
                    public void onReceiveValue(String value) {
                        clickNext[0] = value.replaceAll("\"", "");
                        if (AppTools.event == null || AppTools.event.isEnd()) {
                            float[] xy = null;
                            if (clickNext[0].indexOf("_") != -1) {
                                xy = AppTools.getLeft(clickNext[0]);
                                xy[0] = xy[0] + AppTools.statusBarHeight + 10;
                                xy[1] = xy[1] + 10;
//                                String dd = AppTools.width + "  " + AppTools.height;
                                AppTools.event = new Click((int) xy[0], (int) xy[1], 1);
                                step = step_clickNext4;
                            } else if (clickNext[0].equals("0")) {

                            }
                        }
                    }
                });
                break;
            case step_clickNext4:
                String clickNextjs4 = FbJs.getXy_Element("button", "value", "Next");
                wv.evaluateJavascript(clickNextjs4, new ValueCallback<String>() {
                    @Override
                    public void onReceiveValue(String value) {
                        clickNext[0] = value.replaceAll("\"", "");
                        if (AppTools.event == null || AppTools.event.isEnd()) {
                            float[] xy = null;
                            if (clickNext[0].indexOf("_") != -1) {
                                xy = AppTools.getLeft(clickNext[0]);
                                xy[0] = xy[0] + AppTools.statusBarHeight + 10;
                                xy[1] = xy[1] + 10;
//                                String dd = AppTools.width + "  " + AppTools.height;
                                AppTools.event = new Click((int) xy[0], (int) xy[1], 1);
                                step = step_setPwd;
                            } else if (clickNext[0].equals("0")) {

                            }
                        }
                    }
                });
                break;
            case step_hasPwd:
                if (hasPwd[0].equals("1")) {
                    step = step_setPwd;
                } else {
                    String selectMonth = FbJs.hasElement("input", "name", "reg_passwd__");
                    wv.evaluateJavascript(selectMonth, new ValueCallback<String>() {
                        @Override
                        public void onReceiveValue(String value) {
                            hasPwd[0] = value;
                        }
                    });
                }
                break;
            case step_setPwd:
                clickname = FbJs.getXy_Element_long("input", "name", "reg_passwd__");
                wv.evaluateJavascript(clickname, new ValueCallback<String>() {
                    @Override
                    public void onReceiveValue(String value) {
                        setPwd[0] = value.replaceAll("\"", "");
                        if (AppTools.event == null || AppTools.event.isEnd()) {
                            float[] xy = null;
                            if (setPwd[0].indexOf("_") != -1) {
                                xy = AppTools.getLeft(setPwd[0]);
                                xy[0] = xy[0] + AppTools.statusBarHeight + 10;
                                xy[1] = xy[1] + 10;
                                AppTools.putTextIntoClip(userVo.pwd);
                                AppTools.event = new LongClick((int) xy[0], (int) xy[1]);
                            } else if (setPwd[0].equals("@" + userVo.pwd)) {
                                step = step_SignUp;
                            }
                        }
                    }
                });
                break;
            case step_SignUp:
//                send.saveTtUser(userVo);
                String clickSignUpjs = FbJs.getXy_Element("button", "value", "Sign Up");
                wv.evaluateJavascript(clickSignUpjs, new ValueCallback<String>() {
                    @Override
                    public void onReceiveValue(String value) {
                        SignUp[0] = value.replaceAll("\"", "");
                        if (AppTools.event == null || AppTools.event.isEnd()) {
                            float[] xy = null;
                            if (SignUp[0].indexOf("_") != -1) {
                                xy = AppTools.getLeft(SignUp[0]);
                                xy[0] = xy[0] + AppTools.statusBarHeight + 10;
                                xy[1] = xy[1] + 10;
                                AppTools.event = new Click((int) xy[0], (int) xy[1], 1);
                                step = step_hasLogIn;
                            } else if (SignUp[0].equals("0")) {

                            }
                        }
                    }
                });
                break;

            case step_hasLogIn:
                if (hasLogIn[0].equals("1")) {
                    step = step_clickOk;
                } else {
                    String selectMonth = FbJs.hasElement("h3", "innerText", "Log In With One Tap");
                    wv.evaluateJavascript(selectMonth, new ValueCallback<String>() {
                        @Override
                        public void onReceiveValue(String value) {
                            hasLogIn[0] = value;
                        }
                    });
                }
                break;

            case step_clickOk:
//                send.saveTtUser(userVo);
                String clickOkjs = FbJs.getXy_Element("button", "value", "Ok");
                wv.evaluateJavascript(clickOkjs, new ValueCallback<String>() {
                    @Override
                    public void onReceiveValue(String value) {
                        clickOk[0] = value.replaceAll("\"", "");
                        if (AppTools.event == null || AppTools.event.isEnd()) {
                            float[] xy = null;
                            if (clickOk[0].indexOf("_") != -1) {
                                xy = AppTools.getLeft(clickOk[0]);
                                xy[0] = xy[0] + AppTools.statusBarHeight + 10;
                                xy[1] = xy[1] + 10;
                                AppTools.event = new Click((int) xy[0], (int) xy[1], 1);
                                step = step_getVcode;
                                getVcodeTime = System.currentTimeMillis();
                            } else if (clickOk[0].equals("0")) {

                            }
                        }
                    }
                });
                break;

            case step_getVcode:
                if (hasFB[0].equals("1")) {
                    if (System.currentTimeMillis() - getVcodeTime > 30000) {
                        ResultVo<String> rs = send.queryEmailVcode(email.email, email.pwd);
                        if (rs.code == 0) {
                            vcode = rs.data;
                            step = step_setVcode;
                        } else if (System.currentTimeMillis() - getVcodeTime > 180000) {
                            email.status = 4;
                            send.saveEmail(email);
                            isFinish = true;
                        }
                    }

                } else {
                    String selectMonth = FbJs.hasElement("label", "innerText", "FB- ");
                    wv.evaluateJavascript(selectMonth, new ValueCallback<String>() {
                        @Override
                        public void onReceiveValue(String value) {
                            hasFB[0] = value;
                        }
                    });
                }
                break;
            case step_setVcode:
                clickname = FbJs.getXy_Element_long("input", "name", "c");
                wv.evaluateJavascript(clickname, new ValueCallback<String>() {
                    @Override
                    public void onReceiveValue(String value) {
                        setVcode[0] = value.replaceAll("\"", "");
                        if (AppTools.event == null || AppTools.event.isEnd()) {
                            float[] xy = null;
                            if (setVcode[0].indexOf("_") != -1) {
                                xy = AppTools.getLeft(setVcode[0]);
                                xy[0] = xy[0] + AppTools.statusBarHeight + 10;
                                xy[1] = xy[1] + 10;
                                AppTools.putTextIntoClip(vcode);
                                AppTools.event = new LongClick((int) xy[0], (int) xy[1]);
                            } else if (setVcode[0].equals("@" + vcode)) {
                                step = step_clickConfirm;
                            }
                        }
                    }
                });
                break;
            case step_clickConfirm:
                String clickConfirmjs = FbJs.getXy_Element("button", "value", "Confirm");
                wv.evaluateJavascript(clickConfirmjs, new ValueCallback<String>() {
                    @Override
                    public void onReceiveValue(String value) {
                        clickConfirm[0] = value.replaceAll("\"", "");
                        if (AppTools.event == null || AppTools.event.isEnd()) {
                            float[] xy = null;
                            if (clickConfirm[0].indexOf("_") != -1) {
                                xy = AppTools.getLeft(clickConfirm[0]);
                                xy[0] = xy[0] + AppTools.statusBarHeight + 10;
                                xy[1] = xy[1] + 10;
                                AppTools.event = new Click((int) xy[0], (int) xy[1], 1);
                                step = step_last;
                            } else if (clickConfirm[0].equals("0")) {

                            }
                        }
                    }
                });
                break;


        }

        AppTools.show(step);
        return sleep;
    }





    public String vcode = "";
    long setFirstNameTiem = 0;

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
        return AppTools.type_fb;
    }


}
