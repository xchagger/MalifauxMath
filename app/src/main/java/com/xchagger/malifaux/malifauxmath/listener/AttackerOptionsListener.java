package com.xchagger.malifaux.malifauxmath.listener;

import android.widget.TextView;

import com.xchagger.malifaux.malifauxmath.domain.Values;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AttackerOptionsListener extends AbstractWinnerCalculator implements PropertyChangeListener {

    private final TextView textView;

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        calculateWinners((Values) evt.getSource(), evt.getPropertyName(), (int) evt.getNewValue());
        int difference = attackerTotal - defenderTotal;
        if (difference <= 0) {
            attackerLosing(difference);
        } else {
            attackerWinning();
        }
    }

    private void attackerLosing(int difference) {
        int toTie = defenderTotal - attackerTotal + attackerFlip;
        int singleNeg = toTie + 1;
        int noModifier = singleNeg + 5;
        int positive = noModifier + 10;

        if (defenderTotal > attackerTotal) {
            textView.setText("- - " + toTie +
                    " | - " + singleNeg +
                    " | S " + noModifier +
                    " | + " + positive);
        } else if (defenderTotal == attackerTotal) {
            textView.setText("- " + singleNeg +
                    " | S " + noModifier +
                    " | + " + positive);
        } else if (difference < 6) {
            textView.setText("S: " + noModifier +
                    " | + " + positive);
        } else if (difference < 11) {
            textView.setText("+ " + positive);
        } else if (difference > 10) {
            textView.setText("+ " + positive);
        }
    }

    private void attackerWinning() {
        int noModTarget = 6;
        int positiveModTarget = 11;

        int winningBy = attackerTotal - defenderTotal;
        int toGetNoMod = noModTarget - winningBy; // 5
        int toGetPositive = positiveModTarget - winningBy; // 10

        if (winningBy < 6) {
            textView.setText("S " + (toGetNoMod + attackerFlip) +
                    " | + " + (toGetPositive + attackerFlip));
        } else if (attackerFlip >= (toGetPositive + attackerFlip)) {
            textView.setText("BOOM");
        } else {
            textView.setText("+ " + (toGetPositive + attackerFlip));
        }

    }
}
