package strategy.fly;

public class FlyBehaviorNoWay implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("no fly");
    }

}
