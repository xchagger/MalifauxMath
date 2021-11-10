package com.xchagger.malifaux.malifauxmath;

import static com.xchagger.malifaux.malifauxmath.domain.Constants.ATTACKER_FLIP;
import static com.xchagger.malifaux.malifauxmath.domain.Constants.ATTACKER_STAT;
import static com.xchagger.malifaux.malifauxmath.domain.Constants.ATTACKER_TOTAL;
import static com.xchagger.malifaux.malifauxmath.domain.Constants.DEFENDER_FLIP;
import static com.xchagger.malifaux.malifauxmath.domain.Constants.DEFENDER_STAT;
import static com.xchagger.malifaux.malifauxmath.domain.Constants.DEFENDER_TOTAL;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.warkiz.widget.IndicatorSeekBar;
import com.xchagger.malifaux.malifauxmath.domain.Values;
import com.xchagger.malifaux.malifauxmath.listener.AttackerOptionsListener;
import com.xchagger.malifaux.malifauxmath.listener.ChangeListener;
import com.xchagger.malifaux.malifauxmath.listener.DefenderMitigationListener;
import com.xchagger.malifaux.malifauxmath.listener.DefenderOptionsListener;
import com.xchagger.malifaux.malifauxmath.listener.SeekbarChangeListener;
import com.xchagger.malifaux.malifauxmath.listener.TieModifierListener;
import com.xchagger.malifaux.malifauxmath.listener.TotalChangeListener;
import com.xchagger.malifaux.malifauxmath.listener.WinnerListener;

public class MainActivity extends AppCompatActivity {

    private Values values = new Values();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initAttacker();
        initDefender();
        initResults();

        // set initial values
        values.setAttackerStat(5);
        values.setAttackerFlip(7);
        values.setDefenderStat(5);
        values.setDefenderFlip(7);
    }

    private void initAttacker() {
        TextView attackerTotal = findViewById(R.id.textAttackerTotal);
        TextView attackerStatText = findViewById(R.id.textAttackerStat);
        TextView attackerFlipText = findViewById(R.id.textAttackerFlip);
        IndicatorSeekBar attackerStatSeekBar = findViewById(R.id.seekBarAttackerStat);
        IndicatorSeekBar attackerFlipSeekBar = findViewById(R.id.seekBarAttackerFlip);

        attackerStatSeekBar.setOnSeekChangeListener(
                new SeekbarChangeListener(values, ATTACKER_STAT));

        attackerFlipSeekBar.setOnSeekChangeListener(
                new SeekbarChangeListener(values, ATTACKER_FLIP));

        // register observers
        values.addPropertyChangeListener(new ChangeListener(ATTACKER_STAT, attackerStatText));
        values.addPropertyChangeListener(new ChangeListener(ATTACKER_FLIP, attackerFlipText));
        values.addPropertyChangeListener(new TotalChangeListener(ATTACKER_TOTAL, attackerTotal));
    }

    private void initDefender() {
        TextView defenderTotal = findViewById(R.id.textDefenderTotal);
        TextView defenderStatText = findViewById(R.id.textDefenderStat);
        TextView defenderFlipText = findViewById(R.id.textDefenderFlip);
        IndicatorSeekBar defenderStatSeekBar = findViewById(R.id.seekBarDefenderStat);
        IndicatorSeekBar defenderFlipSeekBar = findViewById(R.id.seekBarDefenderFlip);

        defenderStatSeekBar.setOnSeekChangeListener(
                new SeekbarChangeListener(values, DEFENDER_STAT));

        defenderFlipSeekBar.setOnSeekChangeListener(
                new SeekbarChangeListener(values, DEFENDER_FLIP));

        // register observers
        values.addPropertyChangeListener(new ChangeListener(DEFENDER_STAT, defenderStatText));
        values.addPropertyChangeListener(new ChangeListener(DEFENDER_FLIP, defenderFlipText));
        values.addPropertyChangeListener(new TotalChangeListener(DEFENDER_TOTAL, defenderTotal));
    }

    private void initResults() {
        TextView textWinner = findViewById(R.id.textWinner);
        TextView textTieModifiers = findViewById(R.id.textTieModifiers);
        TextView textAttackerOptions = findViewById(R.id.textAttackerOptions);
        TextView textDefenderOptions = findViewById(R.id.textDefenderOptions);
        TextView textDefenderMitigation = findViewById(R.id.textDefenderMitigation);

        // register observers
        values.addPropertyChangeListener(new WinnerListener(textWinner));
        values.addPropertyChangeListener(new TieModifierListener(textTieModifiers));
        values.addPropertyChangeListener(new AttackerOptionsListener(textAttackerOptions));
        values.addPropertyChangeListener(new DefenderOptionsListener(textDefenderOptions));
        values.addPropertyChangeListener(new DefenderMitigationListener(textDefenderMitigation));

    }

}