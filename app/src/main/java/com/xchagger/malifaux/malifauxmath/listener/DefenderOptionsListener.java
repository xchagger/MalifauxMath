package com.xchagger.malifaux.malifauxmath.listener;

import android.widget.TextView;

import com.xchagger.malifaux.malifauxmath.domain.Values;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DefenderOptionsListener extends AbstractWinnerCalculator implements PropertyChangeListener {

    private final TextView textView;

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        calculateWinners((Values) evt.getSource(), evt.getPropertyName(), (int) evt.getNewValue());
        int difference = attackerTotal - defenderTotal;
        if (difference < 0) {
            defenderWinning();
        } else {
            defenderLosing(difference);
        }
    }

    private void defenderLosing(int difference) {
        int toTie = attackerTotal - defenderTotal + defenderFlip;
        int toWin = toTie + 1;

        if (difference == 0) {
            textView.setText("Win: " + toWin);
        } else {
            textView.setText("Tie: " + toTie + " | Win: " + toWin);
        }
    }

    private void defenderWinning() {
        textView.setText("Winning");
    }
}
