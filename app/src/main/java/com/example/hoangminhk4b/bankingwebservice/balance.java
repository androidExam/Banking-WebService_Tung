package com.example.hoangminhk4b.bankingwebservice;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hoangminhk4b.bankingwebservice.base.baseFragment;

public class balance extends baseFragment {
    private String maDT;
    private history history;
    private chuyentien chuyentien;
    @Override
    protected int getLayout() {
        return R.layout.balance;
    }

    @Override
    protected void initView(View view) {
        ViewPager vpBalace=view.findViewById(R.id.vpBalance);
        TabLayout tbBalace=view.findViewById(R.id.tbBalance);
        history=new history();
        chuyentien=new chuyentien();
        BalanceAdapter balanceApdater=new BalanceAdapter(getActivity().getSupportFragmentManager());
        balanceApdater.addFragment(chuyentien,"Chuyển tiền");
        balanceApdater.addFragment(history,"Lịch sử");
        vpBalace.setAdapter(balanceApdater);
        tbBalace.setupWithViewPager(vpBalace);
    }

    @Override
    protected void init() {
        if(maDT != null){
            history.bindingData(maDT);
            chuyentien.bindingData(maDT);
            chuyentien.setHistory(history);
        }
    }

    public void bingdingData(String maDT){
        this.maDT=maDT;
    }
}
