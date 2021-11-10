package com.xchagger.malifaux.malifauxmath.listener;

import static com.xchagger.malifaux.malifauxmath.domain.Constants.ATTACKER_FLIP;
import static com.xchagger.malifaux.malifauxmath.domain.Constants.ATTACKER_STAT;
import static com.xchagger.malifaux.malifauxmath.domain.Constants.DEFENDER_FLIP;
import static com.xchagger.malifaux.malifauxmath.domain.Constants.DEFENDER_STAT;

import android.widget.SeekBar;

import com.warkiz.widget.IndicatorSeekBar;
import com.warkiz.widget.OnSeekChangeListener;
import com.warkiz.widget.SeekParams;
import com.xchagger.malifaux.malifauxmath.domain.Values;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SeekbarChangeListener implements OnSeekChangeListener {

    private final Values values;
    private final String seekbarValueAssociation;

    @Override
    public void onSeeking(SeekParams seekParams) {
        switch (seekbarValueAssociation) {
            case ATTACKER_STAT:
                values.setAttackerStat(seekParams.progress);
                break;
            case ATTACKER_FLIP:
                values.setAttackerFlip(seekParams.progress);
                break;
            case DEFENDER_STAT:
                values.setDefenderStat(seekParams.progress);
                break;
            case DEFENDER_FLIP:
                values.setDefenderFlip(seekParams.progress);
                break;
        }
    }

    @Override
    public void onStartTrackingTouch(IndicatorSeekBar seekBar) {
    }

    @Override
    public void onStopTrackingTouch(IndicatorSeekBar seekBar) {
    }

}
