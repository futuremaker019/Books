package strategy.quack;

public class MuteQuackBehavior implements QuackBehavior {

    @Override
    public void makeSound() {
        System.out.println("mute");
    }

}
