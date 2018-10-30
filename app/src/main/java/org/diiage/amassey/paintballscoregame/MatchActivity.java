package org.diiage.amassey.paintballscoregame;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;

import org.diiage.amassey.paintballscoregame.databinding.ActivityMatchBinding;

public class MatchActivity extends AppCompatActivity {
    Long mancheId;
    private ActivityMatchBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle extras = getIntent().getExtras();
        mancheId = extras.getLong("mancheId");

        MatchActivityViewModel viewModel = ViewModelProviders.of(this).get(MatchActivityViewModel.class);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_match);



        binding.setLifecycleOwner(this);
        binding.setViewModel(viewModel);
    }
}
