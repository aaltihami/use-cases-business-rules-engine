package org.ucbre.usecases.api.rules;

import org.ucbre.usecases.api.Facts;

public interface BusinessRule {
    boolean isApplicable(Facts facts);
    void validate(Facts facts);
}
