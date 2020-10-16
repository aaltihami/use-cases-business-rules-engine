
package org.ucbre.usecases.impl;

import org.ucbre.usecases.api.Facts;

import java.util.HashMap;
import java.util.Map;

public class DefaultFacts implements Facts{

    private Map<Enum<?>, Object> facts;

    public DefaultFacts(){
        facts = new HashMap<>();
    }

    public <T> T getFact(Enum factId){
        Object fact = this.facts.get(factId);
        return (T) fact;
    }

    public <T> void addFact(Enum factId, T object){
        if(this.facts.containsKey(factId)){
            removeFact(factId);
        }

        this.facts.put(factId, object);
    }

    public void removeFact(Enum factId) {
        this.facts.remove(factId);
    }
}

