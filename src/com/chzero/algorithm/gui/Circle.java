package com.chzero.algorithm.gui;

/**
 * @author CHZERO
 * @version 1.0
 * @date 2018-06-21 22:25
 * @email 827348260@qq.com
 * @description
 */
public class Circle{

    private int x;
    private int y;
    private int radii;
    private int speedX;
    private int speedY;

    public Circle(int x, int y, int radii, int speedX, int speedY){
        this.x = x;
        this.y = y;
        this.radii = radii;
        this.speedX = speedX;
        this.speedY = speedY;
    }

    public void move(int minX, int minY, int maxX, int maxY){
        this.x += this.speedX;
        this.y += this.speedY;
        this.checkCollision(minX, minY, maxX, maxY);
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getRadii(){
        return radii;
    }

    public int getSpeedX(){
        return speedX;
    }

    public int getSpeedY(){
        return speedY;
    }

    private void checkCollision(int minX, int minY, int maxX, int maxY){
        if (this.x - this.radii <  minX){ this.x = this.radii;        this.speedX = -this.speedX; }
        if (this.x + this.radii >= maxX){ this.x = maxX - this.radii; this.speedX = -this.speedX; }
        if (this.y - this.radii <  minY){ this.y = this.radii;        this.speedY = -this.speedY; }
        if (this.y + this.radii >= maxY){ this.y = maxY - this.radii; this.speedY = -this.speedY; }
    }

}
