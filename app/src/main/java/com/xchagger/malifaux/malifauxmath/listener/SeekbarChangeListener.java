package com.xchagger.malifaux.malifauxmath.listener;

import static com.xchagger.malifaux.malifauxmath.domain.Constants.ATTACKER_FLIP;
import static com.xchagger.malifaux.malifauxmath.domain.Constants.ATTACKER_STAT;
import static com.xchagger.malifaux.malifauxmath.domain.Constants.DEFENDER_FLIP;
import static com.xchagger.malifaux.malifauxmath.domain.Constants.DEFENDER_STAT;

import android.widget.SeekBar;

import com.xchagger.malifaux.malifauxmath.domain.Values;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SeekbarChangeListener implements SeekBar.OnSeekBarChangeListener {

    private final Values values;
    private final String seekbarValueAssociation;

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        switch (seekbarValueAssociation) {
            case ATTACKER_STAT:
                values.setAttackerStat(progress);
                break;
            case ATTACKER_FLIP:
                values.setAttackerFlip(progress);
                break;
            case DEFENDER_STAT:
                values.setDefenderStat(progress);
                break;
            case DEFENDER_FLIP:
                values.setDefenderFlip(progress);
                break;
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

}
