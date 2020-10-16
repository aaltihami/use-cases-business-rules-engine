package org.ucbre.usecases.api;

import org.ucbre.usecases.api.rules.BusinessRule;

import java.util.List;
import java.util.function.Consumer;

public interface BusinessUseCaseExecutor {
    UseCaseContext createUseCaseContext();

    default UseCaseContext execute(Consumer<UseCaseContext> useCaseContextConsumer) {
        UseCaseContext useCaseContext = createUseCaseContext();
        useCaseContextConsumer.accept(useCaseContext);
        Facts facts = useCaseContext.getFacts();

        List<BusinessRule> businessRules = useCaseContext.getBusinessRules();
        for(BusinessRule businessRule : businessRules) {
            if(!businessRule.isApplicable(facts)){
                continue;
            }
            businessRule.validate(facts);
        }

        List<Action> actions = useCaseContext.getActions();
        for(Action action : actions) {
            action.perform(useCaseContext);
        }

        return useCaseContext;
    }

}
