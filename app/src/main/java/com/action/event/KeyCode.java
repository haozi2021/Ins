package com.action.event;

import android.view.KeyEvent;

import java.util.HashMap;
import java.util.Map;

public class KeyCode {

    Map<String, Integer> ks = new HashMap<>();

    public KeyCode() {

        ks.put("0", KeyEvent.KEYCODE_0);
        ks.put("1", KeyEvent.KEYCODE_1);
        ks.put("2", KeyEvent.KEYCODE_2);
        ks.put("3", KeyEvent.KEYCODE_3);
        ks.put("4", KeyEvent.KEYCODE_4);
        ks.put("5", KeyEvent.KEYCODE_5);
        ks.put("6", KeyEvent.KEYCODE_6);
        ks.put("7", KeyEvent.KEYCODE_7);
        ks.put("8", KeyEvent.KEYCODE_8);
        ks.put("9", KeyEvent.KEYCODE_9);
        ks.put("A", KeyEvent.KEYCODE_A);
        ks.put("B", KeyEvent.KEYCODE_B);
        ks.put("C", KeyEvent.KEYCODE_C);
        ks.put("D", KeyEvent.KEYCODE_D);
        ks.put("E", KeyEvent.KEYCODE_E);
        ks.put("F", KeyEvent.KEYCODE_F);
        ks.put("G", KeyEvent.KEYCODE_G);
        ks.put("H", KeyEvent.KEYCODE_H);
        ks.put("I", KeyEvent.KEYCODE_I);
        ks.put("J", KeyEvent.KEYCODE_J);
        ks.put("K", KeyEvent.KEYCODE_K);
        ks.put("L", KeyEvent.KEYCODE_L);
        ks.put("M", KeyEvent.KEYCODE_M);
        ks.put("N", KeyEvent.KEYCODE_N);
        ks.put("O", KeyEvent.KEYCODE_O);
        ks.put("P", KeyEvent.KEYCODE_P);
        ks.put("Q", KeyEvent.KEYCODE_Q);
        ks.put("R", KeyEvent.KEYCODE_R);
        ks.put("D", KeyEvent.KEYCODE_S);
        ks.put("T", KeyEvent.KEYCODE_T);
        ks.put("U", KeyEvent.KEYCODE_U);
        ks.put("V", KeyEvent.KEYCODE_V);
        ks.put("W", KeyEvent.KEYCODE_W);
        ks.put("X", KeyEvent.KEYCODE_X);
        ks.put("Y", KeyEvent.KEYCODE_Y);
        ks.put("Z", KeyEvent.KEYCODE_Z);

        ks.put("+", KeyEvent.KEYCODE_PLUS);
        ks.put("-", KeyEvent.KEYCODE_MINUS);
        ks.put("*", KeyEvent.KEYCODE_STAR);
        ks.put("/", KeyEvent.KEYCODE_SLASH);
        ks.put("=", KeyEvent.KEYCODE_EQUALS);
        ks.put("@", KeyEvent.KEYCODE_AT);
        ks.put("#", KeyEvent.KEYCODE_POUND);
        ks.put("'", KeyEvent.KEYCODE_APOSTROPHE);
        ks.put("\\", KeyEvent.KEYCODE_BACKSLASH);
        ks.put(",", KeyEvent.KEYCODE_COMMA);
        ks.put(".", KeyEvent.KEYCODE_PERIOD);
        ks.put("[", KeyEvent.KEYCODE_LEFT_BRACKET);
        ks.put("]", KeyEvent.KEYCODE_RIGHT_BRACKET);
        ks.put(";", KeyEvent.KEYCODE_SEMICOLON);
        ks.put("`", KeyEvent.KEYCODE_GRAVE);
        ks.put(" ", KeyEvent.KEYCODE_SPACE);


    }
}