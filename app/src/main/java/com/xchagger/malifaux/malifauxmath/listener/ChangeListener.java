package com.xchagger.malifaux.malifauxmath.listener;

import static com.xchagger.malifaux.malifauxmath.domain.Constants.ATTACKER_FLIP;
import static com.xchagger.malifaux.malifauxmath.domain.Constants.ATTACKER_STAT;
import static com.xchagger.malifaux.malifauxmath.domain.Constants.DEFENDER_FLIP;
import static com.xchagger.malifaux.malifauxmath.domain.Constants.DEFENDER_STAT;

import android.widget.TextView;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ChangeListener implements PropertyChangeListener {

    private final String seekbarValueAssociation;
    private final TextView textView;

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (!seekbarValueAssociation.equals(evt.getPropertyName())) {
            return;
        }
        switch (seekbarValueAssociation) {
            case ATTACKER_STAT:
                textView.setText("Stat: " + evt.getNewValue());
                break;
            case ATTACKER_FLIP:
                textView.setText("Flip: " + evt.getNewValue());
                break;
            case DEFENDER_STAT:
                textView.setText("Stat: " + evt.getNewValue());
                break;
            case DEFENDER_FLIP:
                textView.setText("Flip: " + evt.getNewValue());
                break;
        }

    }

}
