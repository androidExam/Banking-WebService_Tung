package com.example.hoangminhk4b.bankingwebservice.Adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.hoangminhk4b.bankingwebservice.Models.HistoryModel;
import com.example.hoangminhk4b.bankingwebservice.R;

import java.util.List;

public class HistoryAdapter extends BaseAdapter {
    private Activity activity;
    private List<HistoryModel> data;
    View convertView;
    HistoryHolder historyHolder;
    String mdt;

    public HistoryAdapter(Activity activity, List<HistoryModel> data) {
        this.activity = activity;
        this.data = data;
    }

    public void bindingData(List<HistoryModel> data){
        this.data=data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView ==null){
            convertView= LayoutInflater.from(activity).inflate(R.layout.item_history,parent,false);
            historyHolder=new HistoryHolder(convertView);
            convertView.setTag(historyHolder);
        }
        historyHolder= (HistoryHolder) convertView.getTag();
        historyHolder.tvID.setText(data.get(position).getId()+"");
        historyHolder.tvNgayChuyenTien.setText(data.get(position).getNgayChuyenTien());
        historyHolder.tvMaDoiTac.setText(data.get(position).getMaDoiTac());
        historyHolder.tvMaKhachHang.setText(data.get(position).getMaKhachHang());
        historyHolder.tvPhi.setText(data.get(position).getPhi()+"");
        historyHolder.tvSoTien.setText(data.get(position).getSoTien()+"");
        return convertView;
    }
    public class HistoryHolder extends RecyclerView.ViewHolder{
        TextView tvID;
        TextView tvMaDoiTac;
        TextView tvMaKhachHang;
        TextView tvSoTien;
        TextView tvPhi;
        TextView tvNgayChuyenTien;
        public HistoryHolder(@NonNull View itemView) {
            super(itemView);
            tvID=itemView.findViewById(R.id.tvID);
            tvMaDoiTac=itemView.findViewById(R.id.tvMaDoiTac);
            tvMaKhachHang=itemView.findViewById(R.id.tvMaKhachHang);
            tvSoTien=itemView.findViewById(R.id.tvSoTien);
            tvPhi=itemView.findViewById(R.id.tvPhi);
            tvNgayChuyenTien=itemView.findViewById(R.id.tvNgayChuyenTien);
        }
    }
}
