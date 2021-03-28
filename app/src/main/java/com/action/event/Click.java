package com.action.event;

import android.app.Instrumentation;
import android.os.SystemClock;
import android.view.MotionEvent;

import com.tools.AppTools;

public class Click extends Thread implements Event {

    public boolean isEnd = false;

    public boolean isCheck = false;

    int left;
    int top;
    int time;

    public Click(int top, int left, int time) {
        this.left = left;
        this.top = top;
        this.time = time;
        this.start();
    }

    Instrumentation inst = new Instrumentation();

    @Override
    public void run() {
        int i = 0;
        while (i < time) {
            action();
            i++;
            AppTools.stop(500);
        }
        isEnd = true;
    }


    @Override
    public boolean isEnd() {
        return isEnd;
    }

    @Override
    public boolean action() {
        try {
            //发送Down
            inst.sendPointerSync(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(),
                    MotionEvent.ACTION_DOWN, left, top, 0));
            //发送Up
            inst.sendPointerSync(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(),
                    MotionEvent.ACTION_UP, left, top, 0));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
