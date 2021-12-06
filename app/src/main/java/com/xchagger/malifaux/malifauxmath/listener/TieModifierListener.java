package com.xchagger.malifaux.malifauxmath.listener;

import android.widget.TextView;

import com.xchagger.malifaux.malifauxmath.domain.Values;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TieModifierListener extends AbstractWinnerCalculator implements PropertyChangeListener {

    private final TextView textView;


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        calculateWinners((Values) evt.getSource(), evt.getPropertyName(), (int) evt.getNewValue());

        int difference = attackerTotal - defenderTotal;
        if (defenderTotal > attackerTotal) {
            textView.setText("None - Defender wins");
        } else if (defenderTotal == attackerTotal) {
            textView.setText("Double Neg");
        } else if (difference < 6) {
            textView.setText("Single Neg");
        } else if (difference < 11) {
            textView.setText("No modifier");
        } else if (difference > 10) {
            textView.setText("Positive modifier");
        } else {
            textView.setText("Unexpected: " + attackerTotal + " | " + defenderTotal + " | " + difference);
        }
    }
}
