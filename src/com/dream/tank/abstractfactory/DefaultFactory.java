package com.dream.tank.abstractfactory;

import com.dream.tank.Bullet;
import com.dream.tank.Dir;
import com.dream.tank.Explode;
import com.dream.tank.Group;
import com.dream.tank.Tank;
import com.dream.tank.TankFrame;

/**
 * @Author : huzejun
 * @Date: 2021/12/9-21:24
 */
public class DefaultFactory extends GameFactory {
    @Override
    public Tank createTank(int x, int y, Dir dir, Group group, TankFrame tf) {
        return new Tank(x,y,dir,group,tf);
    }

    @Override
    public Bullet createBullet(int x, int y, Dir dir, Group group, TankFrame tf) {
        return new Bullet(x, y, dir, group, tf);
    }

    @Override
    public Explode createExplode(int x, int y, TankFrame tf) {
        return new Explode(x,y,tf);
    }
}
