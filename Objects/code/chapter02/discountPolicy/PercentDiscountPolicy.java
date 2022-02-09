package chapter02.discountPolicy;

import chapter02.Money;
import chapter02.Screening;
import chapter02.discountCondition.DiscountCondition;
import chapter02.discountPolicy.DiscountPolicy;

public class PercentDiscountPolicy extends DiscountPolicy {
    private double percent;

    public PercentDiscountPolicy(double percent, DiscountCondition... conditions) {
        super(conditions);
        this.percent = percent;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return screening.getMovieFee().times(percent);
    }
}
