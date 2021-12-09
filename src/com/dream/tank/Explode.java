package com.dream.tank;

import com.dream.tank.abstractfactory.BaseExplode;
import java.awt.Graphics;

/**
 * @Author : huzejun
 * @Date: 2021/12/8-22:14
 */
public class Explode extends BaseExplode {

    private int x,y;
    private TankFrame tf;

    private int step = 0;

    public Explode(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;
    }

    public void paint(Graphics g) {
        g.drawImage(ResourceMgr.explode[step++],x,y,null);

        if (step >= ResourceMgr.explode.length)
            tf.explodes.remove(this);

        new Thread(()->new Audio("audio/explode.wav").play()).start();
    }
}
