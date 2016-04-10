package com.darby.main;

import com.darby.display.Display;

public class Main {
    public static void main(String[] args) {

        Display.create(1200,800,0xffff); // black background

        Display.render();
    }
}
