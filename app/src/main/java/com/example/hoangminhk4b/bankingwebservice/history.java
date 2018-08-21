package com.example.hoangminhk4b.bankingwebservice;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.hoangminhk4b.bankingwebservice.Adapter.HistoryAdapter;
import com.example.hoangminhk4b.bankingwebservice.Models.HistoryModel;
import com.example.hoangminhk4b.bankingwebservice.base.baseFragment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class history extends baseFragment {
    private String data;
    private ListView lvHistory;
    @Override
    protected int getLayout() {
        return R.layout.history;
    }

    @Override
    protected void initView(View view) {
            lvHistory=view.findViewById(R.id.lvHistory);
    }

    @Override
    protected void init() {

        if(data !=null){
            Retrofit retrofit=new Retrofit.Builder().baseUrl(APISource.url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            APISource service=retrofit.create(APISource.class);
            Map<String,Object> body=new HashMap<>();
            body.put("ma",data);
            body.put("type",1);
            service.getHistory(body).enqueue(new Callback<List<HistoryModel>>() {
                @Override
                public void onResponse(Call<List<HistoryModel>> call, Response<List<HistoryModel>> response) {
                    List<HistoryModel> dataResponse=response.body();
                    HistoryAdapter historyAdapter=new HistoryAdapter(getActivity(),dataResponse);
                    lvHistory.setAdapter(historyAdapter);
                    historyAdapter.notifyDataSetChanged();
                }

                @Override
                public void onFailure(Call<List<HistoryModel>> call, Throwable t) {

                }
            });
        }
    }

    public void bindingData(String data){
        this.data=data;
    }
    public ListView getLvHistory(){
        return this.lvHistory;
    }
}
