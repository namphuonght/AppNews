package com.trannamphuong.cuoiky.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.trannamphuong.cuoiky.Activity.NoidungActivity;
import com.trannamphuong.cuoiky.Model.TieuDe;
import com.trannamphuong.cuoiky.R;

import java.util.ArrayList;

public class TimKiemAdapter extends RecyclerView.Adapter<TimKiemAdapter.ViewHolder>{

    Context context;
    ArrayList<TieuDe> arrtieuDeTimKiem;

    public TimKiemAdapter(Context context, ArrayList<TieuDe> arrtieuDeTimKiem) {
        this.context = context;
        this.arrtieuDeTimKiem = arrtieuDeTimKiem;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_search, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TieuDe tieuDe = arrtieuDeTimKiem.get(position);
        holder.tv_tieudesearch.setText(tieuDe.getTieuDe());
        Picasso.with(context).load(tieuDe.getUrlImg()).into(holder.imgsearch);
    }

    @Override
    public int getItemCount() {
        return arrtieuDeTimKiem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv_tieudesearch;
        ImageView imgsearch;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_tieudesearch = itemView.findViewById(R.id.tv_tieudesearch);
            imgsearch = itemView.findViewById(R.id.imgTimKiem);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, NoidungActivity.class);
                    intent.putExtra("tieude", arrtieuDeTimKiem.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
