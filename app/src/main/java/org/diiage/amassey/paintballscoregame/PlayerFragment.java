package org.diiage.amassey.paintballscoregame;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.diiage.amassey.paintballscoregame.databinding.FragmentPlayerBinding;

public class PlayerFragment extends Fragment {

    public PlayerFragment() {
        // Required empty public constructor
    }

    public static PlayerFragment newInstance() {
        return new PlayerFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FragmentPlayerBinding binding = FragmentPlayerBinding.inflate(inflater,container,false);

        // Inflate the layout for this fragment
        return binding.getRoot();

        //return  inflater.inflate(R.layout.fragment_player,container,false);
    }
}
