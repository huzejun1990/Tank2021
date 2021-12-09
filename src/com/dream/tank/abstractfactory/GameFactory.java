package com.dream.tank.abstractfactory;

import com.dream.tank.Bullet;
import com.dream.tank.Dir;
import com.dream.tank.Tank;
import com.dream.tank.Explode;
import com.dream.tank.Group;
import com.dream.tank.TankFrame;

/**
 * @Author : huzejun
 * @Date: 2021/12/9-21:24
 */
public abstract class GameFactory {

    public abstract Tank createTank(int x, int y, Dir dir, Group group, TankFrame tf);

    public abstract Bullet createBullet(int x, int y,Dir dir,Group group, TankFrame tf);

    public abstract Explode createExplode(int x,int y,TankFrame tf);
}
