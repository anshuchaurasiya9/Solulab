package com.anshu.mvvm.solulab.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.anshu.mvvm.solulab.R;
import com.anshu.mvvm.solulab.model.CoinModel;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class CoinListAdapter extends RecyclerView.Adapter<CoinListAdapter.MyViewHolder> {
    private Context context;
    private List<CoinModel> coinList;
    private ItemClickListener clickListener;
    private MyViewHolder holder;
    private int position;

    public CoinListAdapter(Context context, List<CoinModel> coinList, ItemClickListener clickListener) {
        this.context = context;
        this.coinList = coinList;
        this.clickListener = clickListener;
    }

    public void setMovieList(List<CoinModel> coinList) {
        this.coinList = coinList;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public CoinListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_row, parent, false);
        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull CoinListAdapter.MyViewHolder holder, int position) {

        holder.tvTitle.setText(this.coinList.get(position).getName().toString());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onMovieClick(coinList.get(position));
            }
        });
        Glide.with(context)
                .load(this.coinList.get(position).getUrl())
                .apply(RequestOptions.centerCropTransform())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        if(this.coinList != null) {
            return this.coinList.size();
        }
        return 0;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView)itemView.findViewById(R.id.titleView);
            imageView = (ImageView)itemView.findViewById(R.id.imageView);

        }
    }
    public interface ItemClickListener{
        public void onMovieClick(CoinModel movie);
    }
}
