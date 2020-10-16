package org.ucbre.usecases.impl;

import org.junit.jupiter.api.Test;
import org.ucbre.usecases.api.BusinessUseCaseExecutor;
import org.ucbre.usecases.api.Action;
import org.ucbre.usecases.api.Facts;
import org.ucbre.usecases.api.UseCaseContext;
import org.ucbre.usecases.api.rules.BusinessRule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class DefaultBusinessUseCaseExecutorTest {

    @Test
    void createBusinessRulesContext() {
        BusinessUseCaseExecutor businessUseCaseExecutor = new DefaultBusinessUseCaseExecutor();

        UseCaseContext useCaseContext = businessUseCaseExecutor.execute(useCaseContextConsumer ->
                useCaseContextConsumer
                        .addFact(FactsTypes.A, "A")
                        .addBusinessRule(new BRA())
                        .addBusinessRule(new BRB())
                        .addBusinessRule(new BRC())
                        .addBusinessRule(new BRD())
                        .addAction(new ActionA())
                        .addAction(new ActionB()));

        String a = useCaseContext.getFact(FactsTypes.A);
        String b = useCaseContext.getFact(FactsTypes.B);
        Integer c = useCaseContext.getFact(FactsTypes.C);
        Integer d = useCaseContext.getFact(FactsTypes.D);

        assertEquals(a, "A-BRA");
        assertEquals(b, "A-BRA-BRB");
        assertNull(c);
        assertNull(d);
        assertEquals(Integer.valueOf(1), useCaseContext.getResult());
    }
}


enum FactsTypes {
    A, B, C, D
}

class BRA implements BusinessRule {

    @Override
    public boolean isApplicable(Facts facts) {
        return true;
    }

    @Override
    public void validate(Facts facts) {
        System.out.println("validate BRA");
        String a = facts.getFact(FactsTypes.A);
        facts.addFact(FactsTypes.A, a + "-BRA");
    }
}

class BRB implements BusinessRule {

    @Override
    public boolean isApplicable(Facts facts) {
        return true;
    }

    @Override
    public void validate(Facts facts) {
        System.out.println("validate BRB");
        String a = facts.getFact(FactsTypes.A);
        facts.addFact(FactsTypes.B, a + "-BRB");
    }

}

class BRC implements BusinessRule {

    @Override
    public boolean isApplicable(Facts facts) {
        return false;
    }

    @Override
    public void validate(Facts facts) {
        System.out.println("validate BRC");
        facts.addFact(FactsTypes.C, 3);
    }

}

class BRD implements BusinessRule {
    @Override
    public boolean isApplicable(Facts facts) {
        return facts.getFact(FactsTypes.C) != null;
    }

    @Override
    public void validate(Facts facts) {
        System.out.println("validate BRD");
        Integer c = facts.getFact(FactsTypes.C);
        facts.addFact(FactsTypes.D, c + 6);
    }
}

class ActionA implements Action {

    public ActionA() {
    }

    @Override
    public void perform(UseCaseContext context) {
        System.out.println("ActionA");
    }
}

class ActionB implements Action {

    public ActionB() {
    }

    @Override
    public void perform(UseCaseContext context) {
        System.out.println("ActionB");
        context.setResult(1);
    }
}