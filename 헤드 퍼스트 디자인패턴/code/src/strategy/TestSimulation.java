package strategy;

import strategy.fly.FlyNoWay;
import strategy.quack.MuteQuack;

public class TestSimulation {

    public static void main(String[] args) {
        Duck duck = new MallardDuck();
        duck.performFly();
        duck.performQuack();

        System.out.println();

        duck.setFly(new FlyNoWay());
        duck.setQuack(new MuteQuack());
        duck.performFly();
        duck.performQuack();
    }

}
