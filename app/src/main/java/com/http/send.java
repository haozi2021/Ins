package com.http;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.http.bean.EmailVo;
import com.http.bean.LastNameVo;
import com.http.bean.ResultVo;
import com.http.bean.TtUserVo;
import com.tools.AppTools;

import java.util.List;

public class send {

    public static String server_queryEmailVcode = "queryEmailVcode";
    public static String server_getLastName = "getLastName";
    public static String server_queryEmail = "queryEmail";
    public static String server_saveTtUser = "saveTtUser";
    public static String server_saveEmail = "saveEmail";


//    String msg = "phoneId="+user.phoneId+"&status="+ user.user_id+":"+status;
//    String json = sendMsg_Th(url, msg);


    public static ResultVo<String> queryEmailVcode(String email, String pwd) {
        String url = AppTools.server + server_queryEmailVcode;
        String msg = "email=" + email + "&pwd=" + pwd;
        String json = sendMsg_Th(url, "");
        ResultVo<String> result = new Gson().fromJson(json, new TypeToken<ResultVo<String>>() {
        }.getType());
        return result;
    }


    public static ResultVo<String> saveTtUser(TtUserVo user) {
        String url = AppTools.server + server_saveTtUser;
        String msg = "userId=" + user.userId + "&userType=" + user.userType + "&firstName=" + user.firstName
                + "&lastName=" + user.lastName + "&gender=" + user.gender + "&pwd=" + user.pwd + "&phoneId=" + user.phoneId;
        String json = sendMsg_Th(url, msg);
        ResultVo<String> result = new Gson().fromJson(json, new TypeToken<ResultVo<String>>() {
        }.getType());
        return result;
    }


    public static ResultVo<String> saveEmail(EmailVo emailVo) {
        String url = AppTools.server + server_saveEmail;
        String msg = "id=" + emailVo.id + "&status=" + emailVo.status + "&email=" + emailVo.email + "&pwd=" + emailVo.pwd;
        String json = sendMsg_Th(url, msg);
        ResultVo<String> result = new Gson().fromJson(json, new TypeToken<ResultVo<String>>() {
        }.getType());
        return result;
    }


    public static ResultVo<EmailVo> queryEmail() {
        String url = AppTools.server + server_queryEmail;
        String json = sendMsg_Th(url, "");
        ResultVo<EmailVo> result = new Gson().fromJson(json, new TypeToken<ResultVo<EmailVo>>() {
        }.getType());
        return result;
    }

    public static ResultVo<List<LastNameVo>> getLastName() {
        String url = AppTools.server + server_getLastName;
        String json = sendMsg_Th(url, "");
        ResultVo<List<LastNameVo>> result = new Gson().fromJson(json, new TypeToken<ResultVo<List<LastNameVo>>>() {
        }.getType());
        return result;
    }


    public static String sendMsg(String url, String msg) {
        String httpString = "";
        try {
//            Map<String, String> header = new HashMap<>();
//            header.put("xx", msg);
            boolean isPost = true;
            httpString = HttpHelper.httpString(url, null, isPost, msg);
            AppTools.show(":::::" + httpString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return httpString;
    }


    public static String sendMsg_Th(String url, String msg) {

        SendTask st = new SendTask(url, msg);
        st.start();
        while (true) {
            if (st.json != null)
                break;

            AppTools.stop(1000);
        }
        return st.json;
    }


}
