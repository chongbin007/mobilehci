package com.example.chongbin.mobilehci;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;


public class JourneyFragment extends Fragment {

    public Chronometer textTimer;
    public Button startTimeBtn;
    private Button mapBtn;
    private Button finishBtn;
    private boolean isStart;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_journey, container, false);


        textTimer = (Chronometer) view.findViewById(R.id.chronometer);
        textTimer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometerChanged) {
                textTimer = chronometerChanged;
            }
        });

        startTimeBtn = (Button) view.findViewById(R.id.count_btn);
        startTimeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textTimer.setBase(SystemClock.elapsedRealtime());
                textTimer.start();
                startTimeBtn.setEnabled(false);
                finishBtn.setEnabled(true);
            }
        });

        finishBtn = (Button) view.findViewById(R.id.finish_btn);
        finishBtn.setEnabled(false);
        finishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textTimer.stop();
                finishBtn.setEnabled(false);
                startTimeBtn.setEnabled(true);

            }
        });
        return view;
    }

    /*public void startStopChronometer(View view){
        if(isStart){
            textTimer.stop();
            isStart = false;
            startTimeBtn.setText("Start");
        }else{
            textTimer.setBase(SystemClock.elapsedRealtime());
            textTimer.start();
            isStart = true;
            startTimeBtn.setText("Stop");
        }
    }*/

}