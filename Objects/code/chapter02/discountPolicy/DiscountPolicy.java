package chapter02.discountPolicy;

import chapter02.Money;
import chapter02.Screening;

public interface DiscountPolicy {
    Money calculateDiscountAmount(Screening screening);
}
