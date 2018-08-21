package com.example.hoangminhk4b.bankingwebservice;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.Toast;

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

public class chuyentien extends baseFragment {
    Button btnChuyen;
    private String data;
    private EditText edMaKH;
    private EditText edSoTien;
    private Fragment fragment;

    @Override
    protected int getLayout() {
        return R.layout.chuyen_tien;
    }

    @Override
    protected void initView(View view) {
        edMaKH=view.findViewById(R.id.edMaKH);
        edSoTien=view.findViewById(R.id.edSotien);
        btnChuyen=view.findViewById(R.id.btnChuyen);
        btnChuyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit=new Retrofit.Builder().baseUrl(APISource.url)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                final APISource service=retrofit.create(APISource.class);
                final Map<String,String> body=new HashMap<>();
                body.put("maKhachHang","KH1");
                service.checkSoDuKH(edSoTien.getText().toString(),body).enqueue(new Callback<Boolean>() {
                    @Override
                    public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                        Boolean check=response.body();
                        if(check){
                            Map<String,Object> bodyGD=new HashMap<>();
                            bodyGD.put("maDoiTac",data);
                            bodyGD.put("maKhachHang",edMaKH.getText().toString());
                            bodyGD.put("soTien",Integer.valueOf(edSoTien.getText().toString()));
                            service.setGiaoDich(bodyGD).enqueue(new Callback<Boolean>() {
                                @Override
                                public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                                    Boolean checkGD=response.body();
                                    if(checkGD){
                                        Toast.makeText(getActivity(),"Giao dịch thành công",Toast.LENGTH_SHORT).show();
                                        Map<String,Object> body1=new HashMap<>();
                                        body1.put("ma",data);
                                        body1.put("type",1);
                                        service.getHistory(body1).enqueue(new Callback<List<HistoryModel>>() {
                                            @Override
                                            public void onResponse(Call<List<HistoryModel>> call, Response<List<HistoryModel>> response) {
                                                List<HistoryModel> dataResponse=response.body();
                                                HistoryAdapter adapter= (HistoryAdapter) ((history) fragment).getLvHistory().getAdapter();
                                                adapter.bindingData(dataResponse);
                                                adapter.notifyDataSetChanged();
                                            }

                                            @Override
                                            public void onFailure(Call<List<HistoryModel>> call, Throwable t) {

                                            }
                                        });
                                    }else {
                                        Toast.makeText(getActivity(),"Giao dịch không thành công",Toast.LENGTH_SHORT).show();
                                    }
                                }

                                @Override
                                public void onFailure(Call<Boolean> call, Throwable t) {

                                }
                            });
                        }else {
                            Toast.makeText(getActivity(),"Số tiền không đủ giao dịch",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Boolean> call, Throwable t) {

                    }
                });
            }
        });
    }
    public void bindingData(String data){
        this.data=data;
    }
    public Fragment setHistory(Fragment frg){
        return this.fragment=frg;
    }
}
