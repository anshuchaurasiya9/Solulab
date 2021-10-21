package com.anshu.mvvm.solulab.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.anshu.mvvm.solulab.model.CoinModel;
import com.anshu.mvvm.solulab.network.APIService;
import com.anshu.mvvm.solulab.network.RetroInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CoinListViewModel extends ViewModel {

    private MutableLiveData<List<CoinModel>> coinList;

    public CoinListViewModel(){
        coinList = new MutableLiveData<>();
    }

    public MutableLiveData<List<CoinModel>> getCoinListObserver() {
        return coinList;

    }

    public void makeApiCall() {
        APIService apiService = RetroInstance.getRetroClient().create(APIService.class);
        Call<List<CoinModel>> call = apiService.getCoinList();
        call.enqueue(new Callback<List<CoinModel>>() {
            @Override
            public void onResponse(Call<List<CoinModel>> call, Response<List<CoinModel>> response) {
                coinList.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<CoinModel>> call, Throwable t) {
                coinList.postValue(null);
            }


        });
    }
}

