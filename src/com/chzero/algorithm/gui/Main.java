package com.chzero.algorithm.gui;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author CHZERO
 * @version 1.0
 * @date 2018-06-21 17:25
 * @email 827348260@qq.com
 * @description Swing 算法可视化
 */
public class Main{

    public static void main(String[] args){

        int screenWidth = 800;
        int screenheigth = 800;

        int radii = 50;
        int number = 20;
        List<Circle> circleList = new ArrayList<>(number);
        for (int i = 0; i < number; i++){
            int x = new Random().nextInt(screenWidth - 2 * radii) + radii;
            int y = new Random().nextInt(screenheigth - 2 * radii) + radii;
            int speedX = new Random().nextInt(5);
            int speedY = new Random().nextInt(5);
            circleList.add(new Circle(x, y, radii, speedX, speedY));
        }


        //事件分发线程
        EventQueue.invokeLater(() -> {
            AlgoFrame window = new AlgoFrame("算法可视化", screenWidth, screenheigth);

            new Thread(() -> {
                while (true){
                    //绘制数据
                    window.render(circleList);
                    AlgoVisHelper.pause(5);
                    //更新数据
                    for (Circle circle : circleList){
                        circle.move(0, 0, screenWidth, screenheigth);
                    }
                }
            }).start();
        });
    }
}
