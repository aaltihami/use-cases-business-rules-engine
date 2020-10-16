package org.ucbre.usecases.impl;


import org.ucbre.usecases.api.Action;
import org.ucbre.usecases.api.Facts;
import org.ucbre.usecases.api.UseCaseContext;
import org.ucbre.usecases.api.rules.BusinessRule;

import java.util.ArrayList;
import java.util.List;

public class DefaultUseCaseContext implements UseCaseContext {

    private List<BusinessRule> businessRules = new ArrayList<>();
    private List<Action> actions = new ArrayList<>();
    private Facts facts = new DefaultFacts();
    private Object result;

    public DefaultUseCaseContext() {
        super();
    }

    public DefaultUseCaseContext addBusinessRule(BusinessRule businessRule) {
        this.businessRules.add(businessRule);
        return this;
    }

    public List<BusinessRule> getBusinessRules() {
        return businessRules;
    }

    @Override
    public List<Action> getActions() {
        return actions;
    }

    @Override
    public Facts getFacts() {
        return this.facts;
    }

    @Override
    public <T> T getFact(Enum id) {
        return this.facts.getFact(id);
    }

    @Override
    public <T> UseCaseContext addFact(Enum id, T object) {
        this.facts.addFact(id, object);
        return this;
    }

    @Override
    public UseCaseContext addAction(Action action) {
        this.actions.add(action);
        return this;
    }

    @Override
    public <R> void setResult(R result) {
        this.result = result;
    }

    @Override
    public <R> R getResult() {
        return (R) result;
    }

    @Override
    public void removeFact(Enum id) {
        this.facts.removeFact(id);
    }

}
