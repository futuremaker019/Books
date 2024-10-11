package strategy.quack;

public class RealQuackBehavior implements QuackBehavior {

    @Override
    public void makeSound() {
        System.out.println("Queck Queck");
    }

}
