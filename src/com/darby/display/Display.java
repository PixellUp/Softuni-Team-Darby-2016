package com.darby.display;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Arrays;

public abstract class Display {
    private static  boolean created = false;
    private static JFrame frame;
    private static Canvas content;

    private static BufferedImage buffer;
    private static int[] bufferedData;
    private static Graphics bufferGraphics;
    private static int cleanColor;

    public static void create(int width, int height, int _clearColor){
        if (created)
            return;
        frame = new JFrame("Tanks");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        content = new Canvas();
        Dimension size = new Dimension(width, height);
        content.setPreferredSize(size);
        content.setBackground(Color.black);

        frame.setResizable(false);
        frame.getContentPane().add(content);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setAlwaysOnTop(false);

        buffer = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
        bufferedData = ((DataBufferInt) buffer.getRaster().getDataBuffer()).getData();
        bufferGraphics = buffer.getGraphics();
        cleanColor = _clearColor;

        created = true;

    }

  public static void clear(){
      Arrays.fill(bufferedData,cleanColor);
  }

  public static void render(){

  }

  public static void swapBuffers(){
     Graphics g = content.getGraphics();
      g.drawImage(buffer,0,0,null);
  }
}
