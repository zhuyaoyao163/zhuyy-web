package com.zhuyy.demo.service;

import java.util.Observable;

/**
 * Created by zhuyy on 2017/2/20.
 */

public class Test2 {
    public static void main(String[] args) {
        Subject subject = new Subject();
        subject.addObserver(new Subscriber());
        subject.setMsg("change");

        int a = 2;
        System.out.println(a==1 ? 2 : "");
    }

}


class Subject extends Observable {

    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
        setChanged();
        notifyObservers();
    }
}

class Subscriber implements java.util.Observer {

    @Override
    public void update(Observable o, Object arg) {
        Subject subject = (Subject) o;
        System.out.println(subject.getMsg());
    }
}

