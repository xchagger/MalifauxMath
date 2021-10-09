package com.xchagger.malifaux.malifauxmath.domain;

import lombok.Setter;

public class Values {

    @Setter
    private Integer attackerStat = 5;
    @Setter
    private Integer attackerFlip = 5;


    public String getAttackerTotal() {
        return "Total: " + (attackerStat + attackerFlip);
    }

    public String getAttackerStat() {
        return "Stat: " + attackerStat;
    }

    public String getAttackerFlip() {
        return "Flip: " + attackerFlip;
    }

}
