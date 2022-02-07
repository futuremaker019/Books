package chapter02;

import java.time.Duration;

public class Movie {
    private String title;
    private Duration runingtime;
    private Money fee;
    private DiscountPolicy discountPolicy;

    public Movie(String title, Duration runingtime, Money fee, DiscountPolicy discountPolicy) {
        this.title = title;
        this.runingtime = runingtime;
        this.fee = fee;
        this.discountPolicy = discountPolicy;
    }

    public Money getFee() {
        return fee;
    }

    public Money calculateMovieFee(Screening screening) {
        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }
}
