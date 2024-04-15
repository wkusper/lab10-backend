package edu.iu.habahram.ducksservice.model;

public class Quack implements QuackBehavior {
    private String quackFileName;

    public Quack(String quackFileName) {
        this.quackFileName = quackFileName;
    }

    @Override
    public void quack() {

    }
}
