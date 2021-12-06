package com.xchagger.malifaux.malifauxmath.listener;

import android.widget.TextView;

import com.xchagger.malifaux.malifauxmath.domain.Values;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DefenderMitigationListener extends AbstractWinnerCalculator implements PropertyChangeListener {

    private final TextView textView;

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        calculateWinners((Values) evt.getSource(), evt.getPropertyName(), (int) evt.getNewValue());
        int winningBy = attackerTotal - defenderTotal;
        int targetForStraight = attackerTotal - 10;
        int mitigateToStraight = targetForStraight - defenderStat;
        int targetForNeg = attackerTotal - 5;
        int mitigateToNeg = targetForNeg - defenderStat;
        int targetForTie = attackerTotal - 0;
        int mitigateToTie = targetForTie - defenderStat;


        System.out.println("AT" + attackerTotal + " DT" + defenderTotal + " WB" + winningBy + " TFS" + targetForStraight + " MTS" + mitigateToStraight);
        String output = "";
        if (defenderFlip < mitigateToStraight) {
            output = output + "S: " + mitigateToStraight;
        }
        if (defenderFlip < mitigateToNeg) {
            output = output.length() == 0 ? output + "- " + mitigateToNeg : output + " | - " + mitigateToNeg;
        }
        if (defenderFlip < mitigateToTie) {
            output = output.length() == 0 ? output + "- - " + mitigateToTie : output + " | - - " + mitigateToTie;
        }
        textView.setText(output);
    }

}

