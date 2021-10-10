package com.xchagger.malifaux.malifauxmath.listener;

import android.widget.TextView;

import com.xchagger.malifaux.malifauxmath.domain.Values;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class WinnerListener extends AbstractWinnerCalculator implements PropertyChangeListener {

    private final TextView textView;

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        calculateWinners((Values) evt.getSource(), evt.getPropertyName(), (int) evt.getNewValue());
        if (defenderTotal == attackerTotal) {
            textView.setText("Tie");
        } else if (attackerTotal > defenderTotal) {
            textView.setText("Attacker wins by " + (attackerTotal - defenderTotal));
        } else {
            textView.setText("Defender wins by " + (defenderTotal - attackerTotal));
        }
    }
}
