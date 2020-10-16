package org.ucbre.usecases.api;

public final class BusinessUseCaseExecutorFactory {

    public static BusinessUseCaseExecutor newInstance(String implClassFullyQualifiedName) {
        try {
            Class clazz = Class.forName(implClassFullyQualifiedName);

            if(!BusinessUseCaseExecutor.class.isAssignableFrom(clazz)){
                throw new InvalidBusinessUseCaseExecutorImplementationException(implClassFullyQualifiedName  + " :  is not implementing " + BusinessUseCaseExecutor.class);
            }

            Object context = clazz.getDeclaredConstructor().newInstance();
            return (BusinessUseCaseExecutor) context;
        } catch (Throwable e) {
            throw new BusinessUseCaseExecutorCreationFailedException(" creation of " + implClassFullyQualifiedName + " failed" , e );
        }
    }
}
