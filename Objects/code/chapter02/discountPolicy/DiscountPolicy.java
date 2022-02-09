package chapter02.discountPolicy;

import chapter02.Money;
import chapter02.Screening;
import chapter02.discountCondition.DiscountCondition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DiscountPolicy {
    private List<DiscountCondition> conditions = new ArrayList<>();

    public DiscountPolicy(DiscountCondition ... conditions) {
        this.conditions = Arrays.asList(conditions);
    }

    public Money calculateDiscountAmount(Screening screening) {
        for(DiscountCondition each : conditions) {
            if (each.isSatisfiedBy(screening)){
                return getDiscountAmount(screening);
            }
        }

        return Money.Zero;
    }

    protected abstract Money getDiscountAmount(Screening screening);
}
