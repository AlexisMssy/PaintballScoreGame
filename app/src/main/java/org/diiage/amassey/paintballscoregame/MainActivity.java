package org.diiage.amassey.paintballscoregame;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.database.sqlite.SQLiteDatabase;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.diiage.amassey.paintballscoregame.Manche.Manche;
import org.diiage.amassey.paintballscoregame.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends FragmentActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public List<Manche> listeManches;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MainActivityViewModel viewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        LiveData<List<Manche>> mans = viewModel.getManches();

        binding.setLifecycleOwner(this);
        binding.setViewModel(viewModel);

        viewModel.getManches().observe(this, manche -> {
//            Log.d("LIVE",manche.get(1).getDate().toString());
            Log.d("LIVE","string");
        });

        //listeManches = viewModel.getManches();



        /*
        mRecyclerView = findViewById(R.id.rv_listematch);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new AdapterMatch(this, listGT);
        mRecyclerView.setAdapter(mAdapter);
*/
    }
}