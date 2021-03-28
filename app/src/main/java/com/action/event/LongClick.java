package com.action.event;

import android.app.Instrumentation;
import android.os.SystemClock;
import android.view.InputDevice;
import android.view.MotionEvent;

import com.tools.AppTools;

public class LongClick extends Thread implements Event {

    public boolean isEnd = false;
    int left;
    int top;

    public boolean isCheck = false;

    public LongClick(int top, int left) {
        this.left = left;
        this.top = top;
        this.start();
    }

    Instrumentation inst = new Instrumentation();

    @Override
    public void run() {

        action();
        isEnd = true;

//不能在子线程运行

    }


    private void longClickOnScreen(int x, int y) {
        try {

            long downTime = SystemClock.uptimeMillis();

            long eventTime = SystemClock.uptimeMillis();

            final MotionEvent eventDown = MotionEvent.obtain(downTime,

                    eventTime, MotionEvent.ACTION_DOWN, x, y, 0);

            eventDown.setSource(InputDevice.SOURCE_TOUCHSCREEN);

            final MotionEvent eventMove = MotionEvent.obtain(downTime, eventTime,

                    MotionEvent.ACTION_MOVE, x, y + 1, 0);

            eventMove.setSource(InputDevice.SOURCE_TOUCHSCREEN);

            final MotionEvent eventUp = MotionEvent.obtain(downTime, eventTime,

                    MotionEvent.ACTION_UP, x, y, 0);

            eventUp.setSource(InputDevice.SOURCE_TOUCHSCREEN);

            inst.sendPointerSync(eventDown);

            inst.sendPointerSync(eventMove);

            try {

                Thread.sleep(2650);

            } catch (InterruptedException e) {

                e.printStackTrace();

            }

            inst.sendPointerSync(eventUp);

        } catch (NullPointerException e) {

            e.printStackTrace();

        }

    }


    @Override
    public boolean isEnd() {
        return isEnd;
    }

    @Override
    public boolean action() {

        try {
            longClickOnScreen(left, top);

            //发送Down
            inst.sendPointerSync(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(),
                    MotionEvent.ACTION_DOWN, left, top - 50, 0));
            AppTools.stop(500);
            //发送Up
            inst.sendPointerSync(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(),
                    MotionEvent.ACTION_UP, left, top - 50, 0));
        } catch (Exception e) {

        }
        return true;
    }
}
