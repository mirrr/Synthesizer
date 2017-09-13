package com.example.mir.synthesizer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button aButton, bButton, asButton, cButton, csButton, dButton, dsButton, eButton, fButton, fsButton, gButton, gsButton,
            ch1, ch2;
    private NumberPicker a,b;
    private MediaPlayer aNote, asNote, bNote, csNote, dsNote, lcNote, lcsNote, ldNote, ldsNote, leNote, lfNote, lfsNote, lgNote, lgsNote;
    private final int WHOLE_NOTE = 1000;
    private MediaPlayer[] c1,c2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NumberPicker a = new NumberPicker(this);
            a.setMinValue(0);
            a.setMaxValue(9);
        NumberPicker b = new NumberPicker(this);
            b.setMinValue(0);
            b.setMaxValue(11);
            b.setDisplayedValues(new String[] {"C","CS","D","DS","E","F","FS","G","GS","A","AS","B"});
        c1 = new MediaPlayer[]{leNote, lfsNote, lgsNote, aNote, bNote, csNote, dsNote};
        c2 = new MediaPlayer[]{lcNote, lcsNote, ldNote, ldsNote, leNote, lfNote, lfsNote, lgNote, lgsNote, aNote, asNote, bNote};

        wireWidgets();
        setListeners();
        createMediaPlayers();



    }



    private void ch(int note, int times) {
        for (int i = 0; i < times; i++) {
            play(c2[note]);
            delayPlaying(WHOLE_NOTE / 2);
        }

    }


    private void play(MediaPlayer note) {
        note.seekTo(0);
        note.start();
    }

    private void delayPlaying(int delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void createMediaPlayers() {
        aNote = MediaPlayer.create(this, R.raw.scalehigha);
        asNote = MediaPlayer.create(this, R.raw.scalehighbb);
        bNote = MediaPlayer.create(this, R.raw.scalehighb);
        csNote = MediaPlayer.create(this, R.raw.scalehighcs);
        dsNote = MediaPlayer.create(this, R.raw.scalehighds);
        lcNote = MediaPlayer.create(this, R.raw.scalec);
        lcsNote = MediaPlayer.create(this, R.raw.scalecs);
        ldNote = MediaPlayer.create(this, R.raw.scaled);
        ldsNote = MediaPlayer.create(this, R.raw.scaleds);
        leNote = MediaPlayer.create(this, R.raw.scalee);
        lfNote = MediaPlayer.create(this, R.raw.scalef);
        lfsNote = MediaPlayer.create(this, R.raw.scalefs);
        lgNote = MediaPlayer.create(this, R.raw.scaleg);
        lgsNote = MediaPlayer.create(this, R.raw.scalegs);

    }


    private void setListeners() {
        aButton.setOnClickListener(this);
        asButton.setOnClickListener(this);
        bButton.setOnClickListener(this);
        cButton.setOnClickListener(this);
        csButton.setOnClickListener(this);
        dButton.setOnClickListener(this);
        dsButton.setOnClickListener(this);
        eButton.setOnClickListener(this);
        fButton.setOnClickListener(this);
        fsButton.setOnClickListener(this);
        gButton.setOnClickListener(this);
        gsButton.setOnClickListener(this);
        ch1.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_a:
                play(aNote);
                break;
            case R.id.button_as:
                play(asNote);
                break;
            case R.id.button_b:
                play(bNote);
                break;
            case R.id.button_c:
                play(lcNote);
                break;
            case R.id.button_cs:
                play(lcsNote);
                break;
            case R.id.button_d:
                play(ldNote);
                break;
            case R.id.button_ds:
                play(ldsNote);
                break;
            case R.id.button_e:
                play(leNote);
                break;
            case R.id.button_f:
                play(lfNote);
                break;
            case R.id.button_fs:
                play(lfsNote);
                break;
            case R.id.button_g:
                play(lgNote);
                break;
            case R.id.button_gs:
                play(lgsNote);
                break;
            case R.id.button_ch1:
                for (int i = 0; i < 7; i++) {
                    play(c1[i]);
                    delayPlaying(WHOLE_NOTE / 2);
                }
            case R.id.button_ch2:
                ch(b.getValue(), a.getValue());

            default:
                //the else statement basically
        }
    }

    private void wireWidgets() {
        aButton = (Button) findViewById(R.id.button_a);
        asButton = (Button) findViewById(R.id.button_as);
        bButton = (Button) findViewById(R.id.button_b);
        cButton = (Button) findViewById(R.id.button_c);
        csButton = (Button) findViewById(R.id.button_cs);
        dButton = (Button) findViewById(R.id.button_d);
        dsButton = (Button) findViewById(R.id.button_ds);
        eButton = (Button) findViewById(R.id.button_e);
        fButton = (Button) findViewById(R.id.button_f);
        fsButton = (Button) findViewById(R.id.button_fs);
        gButton = (Button) findViewById(R.id.button_g);
        gsButton = (Button) findViewById(R.id.button_gs);
        ch1 = (Button) findViewById(R.id.button_ch1);
        ch2 = (Button) findViewById(R.id.button_ch2);
        a = (NumberPicker) findViewById(R.id.numberPicker_a);
        b = (NumberPicker) findViewById(R.id.numberPicker_b);
    }
}
