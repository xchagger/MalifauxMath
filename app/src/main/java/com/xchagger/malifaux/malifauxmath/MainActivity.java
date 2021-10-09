package com.xchagger.malifaux.malifauxmath;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.xchagger.malifaux.malifauxmath.domain.Values;
import com.xchagger.malifaux.malifauxmath.listener.handler.AttackFlipChangedHandler;
import com.xchagger.malifaux.malifauxmath.listener.handler.AttackStatChangedHandler;

public class MainActivity extends AppCompatActivity {

    private Values values = new Values();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initAttacker();

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
        attackerStatSeekBar.setOnSeekBarChangeListener(AttackStatChangedHandler.builder()
                .attackerStatText(attackerStatText)
                .attackerTotal(attackerTotal)
                .values(values)
                .build());
        attackerFlipSeekBar.setOnSeekBarChangeListener(AttackFlipChangedHandler.builder()
                .attackerFlipText(attackerFlipText)
                .attackerTotal(attackerTotal)
                .values(values)
                .build());
    }


}