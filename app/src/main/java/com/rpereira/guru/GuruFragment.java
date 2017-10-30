package com.rpereira.guru;

import android.app.Fragment;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Random;


public class GuruFragment extends Fragment {

    public static final String TAG = "GuruFragment";

    public GuruFragment() {
    }

    public static GuruFragment newInstance() {
        return new GuruFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_guru, container, false);
        initTalkButton(view);

        return view;
    }

    private void initTalkButton(View fragmentView) {
        Button talkButton = fragmentView.findViewById(R.id.talkButton);
        talkButton.setOnClickListener((View view) -> {
            talkButton.setEnabled(false);
            MediaPlayer mediaPlayer;
            int audio;
            switch (Math.abs(new Random().nextInt()) % 3) {
                case 0:
                    audio = R.raw.sim;
                    break;
                case 1:
                    audio = R.raw.nao;
                    break;
                default:
                    audio = R.raw.talvez;
            }
            mediaPlayer = MediaPlayer.create(getContext(), audio);
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener((MediaPlayer lMediaPlayer) -> {
                Log.i(TAG, "Played");
                talkButton.setEnabled(true);
            });
        });
    }

}
