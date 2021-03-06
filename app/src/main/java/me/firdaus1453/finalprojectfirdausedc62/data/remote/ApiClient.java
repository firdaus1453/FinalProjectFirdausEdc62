package me.firdaus1453.finalprojectfirdausedc62.data.remote;

import me.firdaus1453.finalprojectfirdausedc62.adapter.Contract;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

//    Retrofit retrofit = new Retrofit.Builder()
//            .baseUrl(Contract.BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build();
//
//    ApiInterface service = retrofit.create(ApiInterface.class);

    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(Contract.BASE_URL
                )
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;

    }
}
