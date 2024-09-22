package strategy.quack;

public class MuteQuack implements Quack {

    @Override
    public void makeSound() {
        System.out.println("mute");
    }

}
