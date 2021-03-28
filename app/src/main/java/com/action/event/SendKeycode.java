package com.action.event;

import android.app.Instrumentation;

import com.tools.AppTools;


public class SendKeycode extends Thread  implements Event{

    public boolean isEnd = false;
    String input;

    public SendKeycode(String str) {
        this.input = str;
        this.start();
    }

    @Override
    public void run() {
        action();
        isEnd = true;
    }


    @Override
    public boolean isEnd() {
        return isEnd;
    }

    @Override
    public boolean action() {

        Instrumentation inst = new Instrumentation();
        int cc = 0;
        for (int i = 0; i < input.length(); i++) {

            char c = input.charAt(i);

            if (c >= 48 && c <= 57) {

                cc = c - 41;
                inst.sendKeyDownUpSync(cc);
            } else if (c >= 97 && c <= 122) {

                cc = c - 68;
                inst.sendKeyDownUpSync(cc);
            } else if (c >= 65 && c <= 90) {
//                inst.sendKeyDownUpSync(59);
//                AppTools.stop(100);

                inst.sendKeyDownUpSync(c - 36);

            } else if (c == 32) {
                inst.sendKeyDownUpSync(62);
            } else {
            }

            AppTools.stop(200);
        }


        return true;
    }
}
