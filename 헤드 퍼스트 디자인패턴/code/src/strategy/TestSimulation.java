package strategy;

import strategy.fly.FlyBehaviorNoWay;
import strategy.quack.MuteQuackBehavior;

public class TestSimulation {

    public static void main(String[] args) {
        Duck duck = new MallardDuck();
        duck.performFly();
        duck.performQuack();

        System.out.println();

        duck.setFly(new FlyBehaviorNoWay());
        duck.setQuack(new MuteQuackBehavior());
        duck.performFly();
        duck.performQuack();
    }

}
