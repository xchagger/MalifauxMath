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


    @Setter
    private Integer defenderStat = 5;
    @Setter
    private Integer defenderFlip = 5;

    public String getDefenderTotal() {
        return "Total: " + (defenderStat + defenderFlip);
    }

    public String getDefenderStat() {
        return "Stat: " + defenderStat;
    }

    public String getDefenderFlip() {
        return "Flip: " + defenderFlip;
    }

}
