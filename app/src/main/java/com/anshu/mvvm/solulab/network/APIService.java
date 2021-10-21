package com.anshu.mvvm.solulab.network;

import com.anshu.mvvm.solulab.model.CoinModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    @GET("coinlist")
    Call<List<CoinModel>> getCoinList();
}
