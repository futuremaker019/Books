package chapter02.discountCondition;

import chapter02.Screening;

public interface DiscountCondition {
    public boolean isSatisfiedBy(Screening screening);
}
