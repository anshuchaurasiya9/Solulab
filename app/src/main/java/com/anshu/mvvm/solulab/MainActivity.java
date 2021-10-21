package com.anshu.mvvm.solulab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.anshu.mvvm.solulab.adapter.CoinListAdapter;
import com.anshu.mvvm.solulab.model.CoinModel;
import com.anshu.mvvm.solulab.viewmodel.CoinListViewModel;

import java.time.Duration;
import java.util.List;

public class MainActivity extends AppCompatActivity implements CoinListAdapter.ItemClickListener {

    private List<CoinModel> coinModelList;
    private CoinListAdapter adapter;
    private CoinListViewModel viewModel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView= findViewById(R.id.recyclerView);
        final TextView noresult = findViewById(R.id.noResultTv);
        LinearLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        adapter =  new CoinListAdapter(this, coinModelList, this);
        recyclerView.setAdapter(adapter);

        viewModel = new ViewModelProvider(this).get(CoinListViewModel.class);
        viewModel.getCoinListObserver().observe(this, new Observer<List<CoinModel>>() {
            @Override
            public void onChanged(List<CoinModel> coinModels) {

                if(coinModels != null) {
                    coinModelList = coinModels;
                    adapter.setMovieList(coinModels);
                    noresult.setVisibility(View.GONE);
                } else {
                    noresult.setVisibility(View.VISIBLE);
                }
            }
        });
        viewModel.makeApiCall();
            }





    @Override
    public void onMovieClick(CoinModel movie) {
        Toast.makeText(this, "Clicked Coin is : " +movie.getName(), Toast.LENGTH_SHORT).show();
    }
}