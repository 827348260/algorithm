package com.chzero.algorithm.gui;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * @author CHZERO
 * @version 1.0
 * @date 2018-06-21 17:58
 * @email 827348260@qq.com
 * @description
 */
public class AlgoFrame extends JFrame{

    private int canvasWidth;
    private int canvasHeight;

    private List<Circle> circleList;

    public AlgoFrame(String title, int canvasWidth, int canvasHeight){
        super(title);

        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;

        AlgoCanvas canvas = new AlgoCanvas();
        super.setContentPane(canvas);
        super.pack();

        super.setResizable(false);
        super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        super.setVisible(true);
    }

    public AlgoFrame(String title){
        this(title, 1024, 768);
    }

    public void render(List<Circle> circleList){
        this.circleList = circleList;
        this.repaint();
    }

    public int getCanvasWidth(){return canvasWidth;}

    public int getCanvasHeight(){return canvasHeight;}

    /**
     * 绘板类
     */
    private class AlgoCanvas extends JPanel{

        @Override
        public Dimension getPreferredSize(){
            return new Dimension(AlgoFrame.this.canvasWidth, AlgoFrame.this.canvasHeight);
        }

        @Override
        protected void paintComponent(Graphics graphics){
            super.paintComponent(graphics);
            Graphics2D graphics2D = (Graphics2D)graphics;

            //抗锯齿
            RenderingHints renderingHints= new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            graphics2D.addRenderingHints(renderingHints);

            //具体绘制图形
            AlgoVisHelper.setStrokeWidth(graphics2D, 1);
            AlgoVisHelper.setColor(graphics2D, Color.RED);
            for (Circle circle :AlgoFrame.this.circleList){
                AlgoVisHelper.strokeCircle(graphics2D, circle.getX(), circle.getY(), circle.getRadii());
            }

        }
    }


}
