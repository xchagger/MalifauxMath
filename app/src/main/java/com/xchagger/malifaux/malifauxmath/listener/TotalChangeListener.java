package com.xchagger.malifaux.malifauxmath.listener;

import static com.xchagger.malifaux.malifauxmath.domain.Constants.ATTACKER_FLIP;
import static com.xchagger.malifaux.malifauxmath.domain.Constants.ATTACKER_STAT;
import static com.xchagger.malifaux.malifauxmath.domain.Constants.DEFENDER_FLIP;
import static com.xchagger.malifaux.malifauxmath.domain.Constants.DEFENDER_STAT;

import android.widget.TextView;

import com.xchagger.malifaux.malifauxmath.domain.Values;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TotalChangeListener implements PropertyChangeListener {

    private final String seekbarValueAssociation;
    private final TextView textView;

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        String assShortName = seekbarValueAssociation.substring(0, 4);
        String evtShortName = evt.getPropertyName().substring(0, 4);

        if (!assShortName.equals(evtShortName)) {
            return;
        }
        Values values = (Values) evt.getSource();
        switch (evt.getPropertyName()) {
            case ATTACKER_STAT:
                textView.setText("Total: " + (values.getAttackerFlip() + (int) evt.getNewValue()));
                break;
            case ATTACKER_FLIP:
                textView.setText("Total: " + (values.getAttackerStat() + (int) evt.getNewValue()));
                break;
            case DEFENDER_STAT:
                textView.setText("Total: " + (values.getDefenderFlip() + (int) evt.getNewValue()));
                break;
            case DEFENDER_FLIP:
                textView.setText("Total: " + (values.getDefenderStat() + (int) evt.getNewValue()));
                break;
        }
    }

}
