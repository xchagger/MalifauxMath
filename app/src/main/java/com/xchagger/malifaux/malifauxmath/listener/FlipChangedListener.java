package com.xchagger.malifaux.malifauxmath.listener;

import android.widget.SeekBar;
import android.widget.TextView;

import com.xchagger.malifaux.malifauxmath.domain.Values;

import lombok.Builder;

@Builder
public class FlipChangedListener extends AbstractSeekBarListener {

    private TextView flipText;
    private TextView total;
    private Values values;

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        this.values.setAttackerFlip(progress);
        flipText.setText(values.getAttackerFlip());
        total.setText(values.getAttackerTotal());
    }

}
