package com.xchagger.malifaux.malifauxmath.listener;

import android.widget.SeekBar;
import android.widget.TextView;

import com.xchagger.malifaux.malifauxmath.domain.Values;

import lombok.Builder;

@Builder
public class StatChangedListener extends AbstractSeekBarListener {

    private TextView statText;
    private TextView total;
    private Values values;

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        this.values.setAttackerStat(progress);
        statText.setText(values.getAttackerStat());
        total.setText(values.getAttackerTotal());
    }

}
