package com.action.fb.event;

import android.app.Instrumentation;
import android.os.SystemClock;
import android.view.MotionEvent;

import com.tools.AppTools;

public class Click extends Thread {

    public boolean isEnd = false;
    int left;
    int top;
    int time;

    public Click(int left, int top, int time) {
        this.left = left;
        this.top = top;
        this.time = time;
    }

    @Override
    public void run() {
        int i = 0;
        while (i < time) {
            Instrumentation inst = new Instrumentation();
            //发送Down
            inst.sendPointerSync(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(),
                    MotionEvent.ACTION_DOWN, left, top, 0));
            AppTools.stop(100);
            //发送Up
            inst.sendPointerSync(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(),
                    MotionEvent.ACTION_UP, left, top, 0));

            i++;
            AppTools.stop(500);
        }



        isEnd = true;

//不能在子线程运行

    }












}
