package org.diiage.amassey.paintballscoregame;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.diiage.amassey.paintballscoregame.Adapters.ListViewManchesAdapter;
import org.diiage.amassey.paintballscoregame.Manche.Manche;
import org.diiage.amassey.paintballscoregame.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends FragmentActivity {
    public List<Manche> listeManches;
    ListViewManchesAdapter customAdapter;
    ListView lvManches;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MainActivityViewModel viewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        lvManches = (ListView) findViewById(R.id.listView);

        lvManches.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, MatchActivity.class);
                intent.putExtra("mancheId",0);
                startActivity(intent);
            }
        });

        //Appel ViewModel
        viewModel.getManches().observe(this, new Observer<List<Manche>>() {
            @Override
            public void onChanged(@Nullable List<Manche> manches) {
                listeManches = manches;
                customAdapter = new ListViewManchesAdapter(listeManches, getApplicationContext());
                lvManches.setAdapter(customAdapter);
            }
        });

        binding.setLifecycleOwner(this);
        binding.setViewModel(viewModel);
    }
}