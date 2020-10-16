
package org.ucbre.usecases.api;

public interface Facts{
    <T> T getFact(Enum id);
    <T> void addFact(Enum id, T object);
    void removeFact(Enum id);
}

