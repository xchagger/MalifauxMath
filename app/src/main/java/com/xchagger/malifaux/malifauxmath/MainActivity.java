package com.xchagger.malifaux.malifauxmath;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.xchagger.malifaux.malifauxmath.domain.Values;
import com.xchagger.malifaux.malifauxmath.listener.FlipChangedListener;
import com.xchagger.malifaux.malifauxmath.listener.StatChangedListener;

public class MainActivity extends AppCompatActivity {

    private Values values = new Values();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initAttacker();
        initDefender();
    }

    private void initAttacker() {
        TextView attackerTotal = findViewById(R.id.textAttackerTotal);
        TextView attackerStatText = findViewById(R.id.textAttackerStat);
        SeekBar attackerStatSeekBar = findViewById(R.id.seekBarAttackerStat);
        TextView attackerFlipText = findViewById(R.id.textAttackerFlip);
        SeekBar attackerFlipSeekBar = findViewById(R.id.seekBarAttackerFlip);

        // set defaults:
        attackerStatText.setText(values.getAttackerStat());
        attackerFlipText.setText(values.getAttackerFlip());
        attackerTotal.setText(values.getAttackerTotal());

        // sliders
        attackerStatSeekBar.setOnSeekBarChangeListener(StatChangedListener.builder()
                .statText(attackerStatText)
                .total(attackerTotal)
                .values(values)
                .build());
        attackerFlipSeekBar.setOnSeekBarChangeListener(FlipChangedListener.builder()
                .flipText(attackerFlipText)
                .total(attackerTotal)
                .values(values)
                .build());
    }

    private void initDefender() {
        TextView DefenderTotal = findViewById(R.id.textDefenderTotal);
        TextView DefenderStatText = findViewById(R.id.textDefenderStat);
        SeekBar DefenderStatSeekBar = findViewById(R.id.seekBarDefenderStat);
        TextView DefenderFlipText = findViewById(R.id.textDefenderFlip);
        SeekBar DefenderFlipSeekBar = findViewById(R.id.seekBarDefenderFlip);

        // set defaults:
        DefenderStatText.setText(values.getDefenderStat());
        DefenderFlipText.setText(values.getDefenderFlip());
        DefenderTotal.setText(values.getDefenderTotal());

        // sliders
        DefenderStatSeekBar.setOnSeekBarChangeListener(StatChangedListener.builder()
                .statText(DefenderStatText)
                .total(DefenderTotal)
                .values(values)
                .build());
        DefenderFlipSeekBar.setOnSeekBarChangeListener(FlipChangedListener.builder()
                .flipText(DefenderFlipText)
                .total(DefenderTotal)
                .values(values)
                .build());
    }


}