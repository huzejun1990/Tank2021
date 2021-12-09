package com.dream.tank;

/**
 * @Author : huzejun
 * @Date: 2021/12/10-1:55
 */
public class Main {
    /*    public static void main(String[] args) throws InterruptedException {
            TankFrame tf = new TankFrame();
             int tankCount =  Integer.parseInt((String) PropertyMgr.getVaule("initTankCount"));

            for (int i = 0; i < tankCount; i++) {
                Tank t = new Tank(235 + i * 70, 150,Dir.DOWN,Group.BAD,tf);
                tf.enemys.add(t);
            }

            while (true){
                Thread.sleep(50);
                tf.repaint();
            }

        }*/
    public static void main(String[] args) throws InterruptedException {

        TankFrame tf = new TankFrame();

        int tankCount = Integer.parseInt((String) PropertyMgr.getValue("initTankCount"));

        for (int i = 0; i < tankCount; i++) {
            Tank t = new Tank(235 + i * 70, 150, Dir.DOWN, Group.BAD, tf);
            tf.enemys.add(t);
        }

        while (true) {
            Thread.sleep(50);
            tf.repaint();
        }
    }
}
