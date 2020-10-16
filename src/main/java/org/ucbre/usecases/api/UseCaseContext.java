package org.ucbre.usecases.api;
import org.ucbre.usecases.api.rules.BusinessRule;

import java.util.List;

public interface UseCaseContext{
    List<BusinessRule> getBusinessRules();
    List<Action> getActions();
    Facts getFacts();
    <T> T getFact(Enum id);
    void removeFact(Enum id);
    UseCaseContext addBusinessRule(BusinessRule businessRule);
    <T> UseCaseContext addFact(Enum id, T object);
    UseCaseContext addAction(Action action);
    <R> void setResult(R result);
    <R> R getResult();
}
