package edu.iu.habahram.ducksservice.model;

public class FlyWithWings implements FlyBehavior {
    private int speed = 20;

    @Override
    public int[] fly(int[] positionBefore) {
        int[] positionAfter = new int[2];
        positionAfter[0] = positionBefore[0] + (speed /60);
        positionAfter[1] = positionBefore[1] + (speed /60);
        return positionAfter;
    }
}
