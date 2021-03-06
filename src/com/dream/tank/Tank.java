package com.dream.tank;

import com.dream.tank.abstractfactory.BaseTank;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

/**
 * @Author : huzejun
 * @Date: 2021/12/8-18:43
 */
public class Tank extends BaseTank {

    private static final int WIDTH = 50,HEIGHT = 50;
    private int x,y;
    private Dir dir;
    private final int SPEED = 5;
    private boolean moving = true;
    private TankFrame tf;
    private boolean living = true;
    private Group group;
    Random random = new Random();
    public Rectangle rect = new Rectangle(WIDTH,HEIGHT);

    public Tank(int x, int y, Dir dir,Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;

        rect.x = this.x;
        rect.y = this.y;
    }

    @Override
    public void paint(Graphics g) {
        if (!living) tf.enemys.remove(this);

        switch (dir){
            case UP:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankU : ResourceMgr.badTankU,x,y,null);
                break;
            case DOWN:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankD : ResourceMgr.badTankD,x,y,null);
                break;
            case LEFT:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankL : ResourceMgr.badTankL,x,y,null);
                break;
            case RIGHT:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankR : ResourceMgr.badTankR,x,y,null);
                break;

            default:
                break;
        }
        move();
    }


    private void move(){
        if (!moving) return;

        switch (dir) {
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;

            default:
                break;
        }

        if (this.group == Group.BAD && random.nextInt(200)>195)
            fire();
        if (this.group == Group.BAD && random.nextInt(200)>195)
            randomDir();

        if (this.group == Group.GOOD)
            new Thread(()->new Audio("audio/tank_move.wav").play()).start();

        boundaryCheck();

        rect.x = this.x;
        rect.y = this.y;

    }


    private void boundaryCheck() {
        if (x < 2) this.x = 2;
        if (y < 27) this.y = 27;
        if (x>(tf.GAME_WIDTH - this.WIDTH - 2)) this.x = tf.GAME_WIDTH - this.WIDTH - 2;
        if (y>(tf.GAME_HEIGHT - this.HEIGHT - 2)) this.y = tf.GAME_HEIGHT - this.HEIGHT - 2;
    }

    public void randomDir(){
        this.dir = Dir.values()[random.nextInt(4)];
    }
    public void fire(){
        int bulletX = getBulletPositionX();
        int bulletY = getBulletPositionY();

        int fireX = getFirePositionX();
        int fireY = getFirePositionY();

        Fire e = new Fire(fireX,fireY,tf);
        tf.fires.add(e);
        if (this.group == Group.GOOD)
            new Thread(()->new Audio("audio/fire1.wav").play()).start();

        Bullet b = tf.df.createBullet(bulletX,bulletY,dir,this.group,tf);
        tf.bullets.add(b);


    }


    private int getFirePositionX(){
        int firePositionX = 0;
        switch (dir) {
            case UP:
                firePositionX = this.x + ResourceMgr.goodTankU.getWidth()/2 - ResourceMgr.fire[0].getWidth()/2;
                break;
            case DOWN:
                firePositionX = this.x + ResourceMgr.goodTankD.getWidth()/2 - ResourceMgr.fire[0].getWidth()/2;
                break;
            case LEFT:
                firePositionX = this.x - ResourceMgr.fire[0].getWidth()/2;
                break;
            case RIGHT:
                firePositionX = this.x + ResourceMgr.goodTankD.getWidth() - ResourceMgr.fire[0].getWidth()/2;
                break;

            default:
                break;
        }
        return firePositionX;
    }

    private int getFirePositionY(){
        int firePositionY = 0;
        switch (dir){
            case UP:
                firePositionY = this.y - ResourceMgr.fire[0].getHeight()/2;
                break;
            case DOWN:
                firePositionY = this.y + ResourceMgr.goodTankD.getHeight() - ResourceMgr.fire[0].getHeight()/2;
                break;
            case LEFT:
                firePositionY = this.y + ResourceMgr.goodTankL.getHeight()/2 - ResourceMgr.fire[0].getHeight()/2;
                break;
            case RIGHT:
                firePositionY = this.y + ResourceMgr.goodTankR.getHeight()/2 - ResourceMgr.fire[0].getHeight()/2;
                break;

            default:
                break;
        }
        return firePositionY;
    }


    private int getBulletPositionY(){
        int bulletPositionY = 0;
        switch (dir) {
            case UP:
                bulletPositionY = this.y - ResourceMgr.bU.getHeight();
                break;
            case DOWN:
                bulletPositionY = this.y +  ResourceMgr.goodTankD.getHeight();
                break;
            case LEFT:
                bulletPositionY = this.y + ResourceMgr.goodTankL.getHeight()/2 - ResourceMgr.bL.getHeight()/2;
                break;
            case RIGHT:
                bulletPositionY = this.y + ResourceMgr.goodTankR.getHeight()/2 - ResourceMgr.bR.getHeight()/2;
                break;

            default:
                break;
        }
        return bulletPositionY;
    }

    private int getBulletPositionX(){
        int bulletPositionX = 0;
        switch (dir) {
            case UP:
                bulletPositionX = this.x + ResourceMgr.goodTankU.getWidth()/2 - ResourceMgr.bU.getWidth()/2;
                break;
            case DOWN:
                bulletPositionX = this.x + ResourceMgr.goodTankD.getWidth()/2 - ResourceMgr.bD.getWidth()/2;
                break;
            case LEFT:
                bulletPositionX = this.x - ResourceMgr.bL.getWidth();
                break;
            case RIGHT:
                bulletPositionX = this.x + ResourceMgr.goodTankR.getHeight();
                break;

            default:
                break;
        }
        return bulletPositionX;
    }



    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public boolean isLiving() {
        return living;
    }

    public void setLiving(boolean living) {
        this.living = living;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void die(){
        this.living = false;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

}
