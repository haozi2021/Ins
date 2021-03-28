package com.action;

import android.os.Message;

import com.MainActivity;
import com.action.fb.FbAction;
import com.tools.AppTools;

import java.util.ArrayList;
import java.util.List;

public class WorkLine extends Thread {

    List<Action> actions = new ArrayList<>();

    public WorkLine() {

        FbAction fba = new FbAction();
        fba.action = fba.action_create;
        addAction(fba);
    }

    public void addAction(Action action) {
        actions.add(action);

    }

    @Override
    public void run() {

        while (true) {
            if(AppTools.event != null && !AppTools.event.isEnd()){
                AppTools.stop(1000);
            }
            else {
                for (int i = actions.size() - 1; i >= 0; i--) {
                    if (actions.get(i).isFinish()) {
                        actions.remove(i);
                    } else {
                        actions.get(i).step();
                    }
                }
            }




//            Message message = Message.obtain();
//            message.obj = this;
//            MainActivity.ma.hintInpu.sendMessage(message);
            AppTools.stop(1000);
        }
    }








}
