package com.androidtutorialpoint.cardviewtutorial;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Video extends Fragment {




    public Video() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         new YouTubeBaseActivity();
        // Inflate the layout for this fragment
        View player = inflater.inflate(R.layout.fragment_video, container, false);


        return player;
    }

}
