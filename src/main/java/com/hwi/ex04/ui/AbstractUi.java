package com.hwi.ex04.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.hwi.ex04.exception.IORuntimeException;


public abstract class AbstractUi {

    protected String getInputedString() {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try {
            // 콘솔에 입력된 값을 취득
            return input.readLine();
        } catch (IOException e) {
            throw new IORuntimeException("콘솔에 입력을 받지 못했습니다.", e);
        }
    }

    abstract public void show();
}