package com.darby.graphics;

public class Font {

    private static String chars = ""+"ABCDEFGHIJKLMNOPQRSTUVWXYZ      ";

    public static void render(String msg,Screen screen,int x,int y, int colour){
        msg = msg.toUpperCase();

        for(int i = 0;i<msg.length();i++ ){
            int charIndex = chars.indexOf(msg.charAt(i));

            if(charIndex>=0){
                screen.render(x+i*8, y, charIndex+31*32, colour);
            }
        }
    }
}