package com.utf7ime2;

import android.os.Message;

import com.MainActivity;

public class test extends Thread {
    @Override
    public void run() {

//        while (true)
        {

            Message message = Message.obtain();
            MainActivity.ma.tt3.sendMessage(message);


        }




    }
}
