package strategy;

import strategy.fly.FlyBehaviorWithWings;
import strategy.quack.RealQuackBehavior;

public class MallardDuck extends Duck{

    /*
        추상클래스에서 정의된 인터페이스 필드를 원하는 기능으로 초기화 시킨다.
     */
    public MallardDuck() {
        this.flyBehavior = new FlyBehaviorWithWings();
        this.quackBehavior = new RealQuackBehavior();
    }

    @Override
    public void display() {
        System.out.println("mallard duck display");
    }

}
