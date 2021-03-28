package com.http;

public class SendTask extends Thread {

    String msg;
    String url;

    public SendTask(String url, String msg) {
        this.msg = msg;
        this.url = url;
    }

    String json = null;

    public void run() {

//        Gson gson = new Gson();
//        String msgstr = gson.toJson(msg);


        while (true) {
            json = send.sendMsg(url, msg);
            if (json != null) {

                break;
            }
//            AppTools.show(msg.action+"请求失败");
        }

    }


}
