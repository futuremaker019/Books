package chapter02;

import chapter02.discountCondition.PeriodCondition;
import chapter02.discountCondition.SequenceCondition;
import chapter02.discountPolicy.AmountDiscountPolicy;
import chapter02.discountPolicy.NoneDiscountPolicy;
import chapter02.discountPolicy.PercentDiscountPolicy;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;

public class Execution {
    public static void main(String[] args) {
        Movie avatar = new Movie("아바타",
                Duration.ofMinutes(120),
                Money.wons(10000),
                new AmountDiscountPolicy(Money.wons(800),
                        new SequenceCondition(1),
                        new SequenceCondition(10),
                        new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)),
                        new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(20, 59))
                )
        );

        System.out.println("avatar = " + avatar);

        // changeDiscountPolicy를 이용하여 간단히 할인 정책을 변경할 수 있다.
        avatar.changeDiscountPolicy(new PercentDiscountPolicy(0.1));

        // 스타워즈는 할인 정책이 없다.
        Movie starWars = new Movie("스타워즈",
                Duration.ofMinutes(210),
                Money.wons(10000),
                new NoneDiscountPolicy()
                );
    }
}
