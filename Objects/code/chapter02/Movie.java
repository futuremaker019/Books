package chapter02;

import chapter02.discountPolicy.DefaultDiscountPolicy;
import chapter02.discountPolicy.DiscountPolicy;

import java.time.Duration;

public class Movie {
    private String title;
    private Duration ruingTime;
    private Money fee;
    private DiscountPolicy discountPolicy;

    public Movie(String title, Duration ruingTime, Money fee, DiscountPolicy discountPolicy) {
        this.title = title;
        this.ruingTime = ruingTime;
        this.fee = fee;
        this.discountPolicy = discountPolicy;
    }

    public void changeDiscountPolicy(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }

    public Money getFee() {
        return fee;
    }

    public Money calculateMovieFee(Screening screening) {
        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", ruingTime=" + ruingTime +
                ", fee=" + fee +
                ", discountPolicy=" + discountPolicy +
                '}';
    }
}
