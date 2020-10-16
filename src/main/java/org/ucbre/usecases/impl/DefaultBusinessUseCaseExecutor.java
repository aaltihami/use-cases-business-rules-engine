package org.ucbre.usecases.impl;

import org.ucbre.usecases.api.BusinessUseCaseExecutor;
import org.ucbre.usecases.api.UseCaseContext;

public class DefaultBusinessUseCaseExecutor implements BusinessUseCaseExecutor {
    @Override
    public UseCaseContext createUseCaseContext() {
        return new DefaultUseCaseContext();
    }
}
