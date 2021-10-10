package com.xchagger.malifaux.malifauxmath.domain;

import static com.xchagger.malifaux.malifauxmath.domain.Constants.ATTACKER_FLIP;
import static com.xchagger.malifaux.malifauxmath.domain.Constants.ATTACKER_STAT;
import static com.xchagger.malifaux.malifauxmath.domain.Constants.DEFENDER_FLIP;
import static com.xchagger.malifaux.malifauxmath.domain.Constants.DEFENDER_STAT;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import lombok.AccessLevel;
import lombok.Getter;

@Getter
public class Values {

    public Values() {
        support = new PropertyChangeSupport(this);
    }

    @Getter(AccessLevel.NONE)
    private final PropertyChangeSupport support;

    private Integer attackerStat = 1; // set to 1 so that we can initialise by setting to 5
    private Integer attackerFlip = 5;
    private Integer defenderStat = 5;
    private Integer defenderFlip = 5;

    public void setAttackerStat(Integer attackerStat) {
        support.firePropertyChange(ATTACKER_STAT, this.attackerStat, attackerStat);
        this.attackerStat = attackerStat;
    }

    public void setAttackerFlip(Integer attackerFlip) {
        support.firePropertyChange(ATTACKER_FLIP, this.attackerFlip, attackerFlip);
        this.attackerFlip = attackerFlip;
    }

    public void setDefenderStat(Integer defenderStat) {
        support.firePropertyChange(DEFENDER_STAT, this.defenderStat, defenderStat);
        this.defenderStat = defenderStat;
    }

    public void setDefenderFlip(Integer defenderFlip) {
        support.firePropertyChange(DEFENDER_FLIP, this.defenderFlip, defenderFlip);
        this.defenderFlip = defenderFlip;
    }

    // events
    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

}
