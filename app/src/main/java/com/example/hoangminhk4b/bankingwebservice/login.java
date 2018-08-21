package com.example.hoangminhk4b.bankingwebservice;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hoangminhk4b.bankingwebservice.base.baseFragment;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class login extends baseFragment {
    EditText edUsername;
    EditText edPassword;
    @Override
    protected int getLayout() {
        return R.layout.login;
    }

    @Override
    protected void initView(View view) {
        edUsername =view.findViewById(R.id.edUsername);
        edPassword =view.findViewById(R.id.edPassword);
        Button btnLogin=view.findViewById(R.id.btnLogin);
        Button btnReset=view.findViewById(R.id.btnReset);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(APISource.url)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                APISource service=retrofit.create(APISource.class);
                Map<String,String> json=new HashMap<>();
                    json.put("maDoiTac",edUsername.getText().toString());
                    json.put("matKhau",edPassword.getText().toString());
                service.getLogin(json)
                        .enqueue(new Callback<Boolean>() {
                    @Override
                    public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                        Boolean check=response.body();
                        if(check){
                            balance balance=new balance();
                            balance.bingdingData(edUsername.getText()+"");
                            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_container,balance).commit();
                        }else {
                            Toast.makeText(getActivity(),"Tài khoản hoặc mật khẩu sai!",Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }

                    @Override
                    public void onFailure(Call<Boolean> call, Throwable t) {
                        Toast.makeText(getActivity(),"Đăng nhập không thành công",Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edUsername.setText("");
                edPassword.setText("");
            }
        });
    }
}
