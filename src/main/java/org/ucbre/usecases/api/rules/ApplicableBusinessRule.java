package org.ucbre.usecases.api.rules;

import org.ucbre.usecases.api.Facts;

public abstract  class ApplicableBusinessRule implements BusinessRule {
    @Override
    public boolean isApplicable(Facts facts) {
        return true;
    }
}
