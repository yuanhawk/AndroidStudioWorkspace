package com.example.myecommerceapp;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


public class ProductRecViewAdapter extends RecyclerView.Adapter<ProductRecViewAdapter.ViewHolder> {

    private static final String TAG = "ProductRecViewAdapter";
    private String[] mData;
    private LayoutInflater mInflator;
    private ItemClickListener mClickListener;
    private Context context;
    private String type = "";
    private Util utils;

    public ProductRecViewAdapter(Context context, String[] data) {
        this.mInflator = LayoutInflater.from(context);
        this.mData = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Creating a view, instance of layout getting layoutInflater from parent context, inflating layout and saving in new obj
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_product_rec_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int  position) {
        Log.d(TAG, "onBindViewHolder: called");
        //No matter what the access modifiers are, a parent class can access the methods of the inner class
        holder.productName.setText(mData[position]);;

    }

    @Override
    public int getItemCount() {
        return mData.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView productName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productName = (TextView) itemView.findViewById(R.id.productName);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    String getItem(int id) {
        return mData[id];
    }

    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
