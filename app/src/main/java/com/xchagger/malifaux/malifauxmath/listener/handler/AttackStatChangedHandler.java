package com.xchagger.malifaux.malifauxmath.listener.handler;

import android.widget.SeekBar;
import android.widget.TextView;

import com.xchagger.malifaux.malifauxmath.domain.Values;
import com.xchagger.malifaux.malifauxmath.listener.AbstractSeekBarListener;

import lombok.Builder;

@Builder
public class AttackStatChangedHandler extends AbstractSeekBarListener {

    private TextView attackerStatText;
    private TextView attackerTotal;
    private Values values;

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        this.values.setAttackerStat(progress);
        attackerStatText.setText(values.getAttackerStat());
        attackerTotal.setText(values.getAttackerTotal());
    }

}
