package org.arzije.ziberovska;

import org.arzije.ziberovska.main.Triangle;

public class Main {
    public static void main(String[] args) {
//        Triangle triangle = new Triangle(1,2,3);// vf går det inte att sätta 1,2,3??
        Triangle triangle = new Triangle();
        triangle.getUserInput();
        triangle.getCurrent_type();
    }
}