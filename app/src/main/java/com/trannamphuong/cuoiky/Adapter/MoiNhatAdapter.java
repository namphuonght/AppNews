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
import com.trannamphuong.cuoiky.Model.MoiNhat;
import com.trannamphuong.cuoiky.R;

import java.util.ArrayList;

public class MoiNhatAdapter extends RecyclerView.Adapter<MoiNhatAdapter.ViewHolder>{

    Context context;
    ArrayList<MoiNhat> mangMoiNhat;

    public MoiNhatAdapter(Context context, ArrayList<MoiNhat> mangMoiNhat) {
        this.context = context;
        this.mangMoiNhat = mangMoiNhat;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, final int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_moinhat, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MoiNhat moinhat = mangMoiNhat.get(position);
        holder .tvTieuDeMoiNhat.setText(moinhat.getTieuDe());
        holder.tvMoTaMoiNhat.setText(moinhat.getMoTa());
        Picasso.with(context).load(moinhat.getUrlImg()).into(holder.imgTieuDeMoiNhat);
    }

    @Override
    public int getItemCount() {
        return mangMoiNhat.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgTieuDeMoiNhat;
        TextView tvTieuDeMoiNhat, tvMoTaMoiNhat;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgTieuDeMoiNhat = itemView.findViewById(R.id.img_tieudemoinhat);
            tvTieuDeMoiNhat = itemView.findViewById(R.id.tv_tieudemoinhat);
            tvMoTaMoiNhat = itemView.findViewById(R.id.tv_motamoinhat);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, NoidungActivity.class);
                    intent.putExtra("tieude",mangMoiNhat.get(getPosition()));
                    context.startActivity(intent);
                }
            });

        }
    }
}
