package strategy;

import strategy.fly.Fly;
import strategy.quack.Quack;

public abstract class Duck {

    Fly fly;
    Quack quack;

    public Duck() {}

    public abstract void display();

    // ㅇ
    public void performFly() {
        fly.fly();
    }

    public void performQuack() {
        quack.makeSound();
    }

    public void swim() {
        System.out.println("수영함");
    }

    // 특정 오리 객체가 생성 후 `날기` 기능을 다시 정의해주는 메서드
    public void setFly(Fly fly) {
        this.fly = fly;
    }

    // 특정 오리 객체가 생성 후 `소리내기` 기능을 다시 정의해주는 메서드
    public void setQuack(Quack quack) {
        this.quack = quack;
    }

}
