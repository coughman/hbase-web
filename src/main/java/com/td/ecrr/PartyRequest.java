package com.td.ecrr;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class PartyRequest {
    @NotNull
    //@Min(1)
    private String id;

    public String toString() {
        return "PartyRequest(" + id + ")";
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
