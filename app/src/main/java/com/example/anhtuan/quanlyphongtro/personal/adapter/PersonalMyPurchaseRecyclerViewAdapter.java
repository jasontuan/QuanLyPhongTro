package com.example.anhtuan.quanlyphongtro.personal.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.anhtuan.quanlyphongtro.R;
import com.example.anhtuan.quanlyphongtro.contract.IContract;
import com.example.anhtuan.quanlyphongtro.model.Purchase;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PersonalMyPurchaseRecyclerViewAdapter extends RecyclerView.Adapter<PersonalMyPurchaseRecyclerViewAdapter.MyPurchaseDataViewHolder> {

    private Context context;
    private IContract.IOnClickItemPurchaseListener iOnClickItemPurchaseListener;
    private List<Purchase> purchaseList;

    public PersonalMyPurchaseRecyclerViewAdapter(Context context, List<Purchase> purchaseList) {
        this.context = context;
        this.purchaseList = purchaseList;
    }

    public void setiOnClickItemPurchaseListener(IContract.IOnClickItemPurchaseListener iOnClickItemPurchaseListener) {
        this.iOnClickItemPurchaseListener = iOnClickItemPurchaseListener;
    }

    @NonNull
    @Override
    public MyPurchaseDataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.items_purchase, parent, false);
        return new MyPurchaseDataViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyPurchaseDataViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        Purchase purchase = purchaseList.get(position);
        holder.tvTitlePurchase.setText(purchase.getTitle());
        holder.tvPricePurchase.setText(purchase.getPrice());
        holder.tvAcreagePurchase.setText(purchase.getAcreage().toString());
        holder.tvAddressPurchase.setText(purchase.getAddress());
        Glide.with(context).load("https://anh.eva.vn//upload/2-2013/images/2013-04-25/1366856222-nhat-kim-anh-1.jpg").into(holder.imgItemPurchase);

        holder.lnlItemsPurchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iOnClickItemPurchaseListener.onClickItemPurchase(position);
            }
        });

        holder.imgDeletePurchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iOnClickItemPurchaseListener.onClickItemDeletePurchase(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return purchaseList != null ? purchaseList.size() : 0;
    }

    static class MyPurchaseDataViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.lnl_items_purchase)
        LinearLayout lnlItemsPurchase;
        @BindView(R.id.tv_title_purchase)
        TextView tvTitlePurchase;
        @BindView(R.id.tv_price_purchase)
        TextView tvPricePurchase;
        @BindView(R.id.tv_acreage_purchase)
        TextView tvAcreagePurchase;
        @BindView(R.id.tv_address_purchase)
        TextView tvAddressPurchase;
        @BindView(R.id.img_item_purchase)
        ImageView imgItemPurchase;
        @BindView(R.id.img_delete_purchase)
        ImageView imgDeletePurchase;

        MyPurchaseDataViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
