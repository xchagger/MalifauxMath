package com.xchagger.malifaux.malifauxmath.listener;

import static com.xchagger.malifaux.malifauxmath.domain.Constants.ATTACKER_FLIP;
import static com.xchagger.malifaux.malifauxmath.domain.Constants.ATTACKER_STAT;
import static com.xchagger.malifaux.malifauxmath.domain.Constants.DEFENDER_FLIP;
import static com.xchagger.malifaux.malifauxmath.domain.Constants.DEFENDER_STAT;

import com.xchagger.malifaux.malifauxmath.domain.Values;

public abstract class AbstractWinnerCalculator {



    protected int attackerTotal = 0;
    protected int defenderTotal = 0;
    protected int attackerStat = 0;
    protected int attackerFlip = 0;
    protected int defenderStat = 0;
    protected int defenderFlip = 0;

    public void calculateWinners(Values values, String stat, int newValue) {
        attackerStat = values.getAttackerStat();
        attackerFlip = values.getAttackerFlip();
        defenderStat = values.getDefenderStat();
        defenderFlip = values.getDefenderFlip();
        switch (stat) {
            case ATTACKER_STAT:
                defenderTotal = values.getDefenderStat() + values.getDefenderFlip();
                attackerTotal = values.getAttackerFlip() + newValue;
                attackerStat = newValue;
                break;
            case ATTACKER_FLIP:
                defenderTotal = values.getDefenderStat() + values.getDefenderFlip();
                attackerTotal = values.getAttackerStat() + newValue;
                attackerFlip = newValue;
                break;
            case DEFENDER_STAT:
                defenderTotal = values.getDefenderFlip() + newValue;
                attackerTotal = values.getAttackerFlip() + values.getAttackerStat();
                defenderStat = newValue;
                break;
            case DEFENDER_FLIP:
                defenderTotal = values.getDefenderStat() + newValue;
                attackerTotal = values.getAttackerFlip() + values.getAttackerStat();
                defenderFlip = newValue;
                break;
        }
    }
}
