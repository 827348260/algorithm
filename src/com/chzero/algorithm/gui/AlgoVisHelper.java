package com.chzero.algorithm.gui;

import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * @author CHZERO
 * @version 1.0
 * @date 2018-06-21 20:39
 * @email 827348260@qq.com
 * @description 绘图工具类
 */
public class AlgoVisHelper{

    private AlgoVisHelper(){}

    /**
     * 设置画笔的线条宽度
     * @param graphics2D 绘图类
     * @param strokeWidth 宽度int
     */
    public static void setStrokeWidth(Graphics2D graphics2D, int strokeWidth){
        graphics2D.setStroke(new BasicStroke(strokeWidth, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
    }

    /**
     * 设置颜色
     * @param graphics2D 绘图类
     * @param color 颜色类
     */
    public static void setColor(Graphics2D graphics2D, Color color){
        graphics2D.setColor(color);
    }

    /**
     * 画空心圆
     * @param graphics2D 绘图类
     * @param x 圆心横坐标
     * @param y 圆心纵坐标
     * @param radii 半径
     */
    public static void strokeCircle(Graphics2D graphics2D, int x, int y, int radii){
        Ellipse2D circle = new Ellipse2D.Double(x - radii, y - radii, 2 * radii, 2 * radii);
        graphics2D.draw(circle);
    }

    /**
     * 画实心圆
     * @param graphics2D 绘图类
     * @param x 圆心横坐标
     * @param y 圆心纵坐标
     * @param radii 半径
     */
    public static void fillCircle(Graphics2D graphics2D, int x, int y, int radii){
        Ellipse2D circle = new Ellipse2D.Double(x - radii, y - radii, 2 * radii, 2 * radii);
        graphics2D.fill(circle);
    }

    public static void pause(int time){
        try{
            Thread.sleep(200);
        }catch (InterruptedException e){
            System.out.println("Error in sleeping.");
        }
    }

}
