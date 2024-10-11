package strategy;

import strategy.fly.FlyBehavior;
import strategy.quack.QuackBehavior;

public abstract class Duck {

    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public Duck() {}

    public abstract void display();

    // ㅇ
    public void performFly() {
        flyBehavior.fly();
    }

    public void performQuack() {
        quackBehavior.makeSound();
    }

    public void swim() {
        System.out.println("수영함");
    }

    // 특정 오리 객체가 생성 후 `날기` 기능을 다시 정의해주는 메서드
    public void setFly(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    // 특정 오리 객체가 생성 후 `소리내기` 기능을 다시 정의해주는 메서드
    public void setQuack(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

}
