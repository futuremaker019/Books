import fly.FlyWithWings;
import quack.RealQuack;

public class MallardDuck extends Duck{

    /*
        추상클래스에서 정의된 인터페이스 필드를 원하는 기능으로 초기화 시킨다.
     */
    public MallardDuck() {
        this.fly = new FlyWithWings();
        this.quack = new RealQuack();
    }

    @Override
    public void display() {
        System.out.println("mallard duck display");
    }

}
