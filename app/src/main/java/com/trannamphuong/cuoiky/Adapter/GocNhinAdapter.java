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
import com.trannamphuong.cuoiky.Model.GocNhin;
import com.trannamphuong.cuoiky.R;

import java.util.ArrayList;

public class GocNhinAdapter extends RecyclerView.Adapter<GocNhinAdapter.ViewHolder>{

    Context context;
    ArrayList<GocNhin> mangGocNhin;

    public GocNhinAdapter(Context context, ArrayList<GocNhin> mangGocNhin) {
        this.context = context;
        this.mangGocNhin = mangGocNhin;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, final int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_gocnhin, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        GocNhin gocnhin = mangGocNhin.get(position);
        holder .tvTieuDeGocNhin.setText(gocnhin.getTieuDe());
        holder.tvMoTaGocNhin.setText(gocnhin.getMoTa());
        Picasso.with(context).load(gocnhin.getUrlImg()).into(holder.imgTieuDeGocNhin);
    }

    @Override
    public int getItemCount() {
        return mangGocNhin.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgTieuDeGocNhin;
        TextView tvTieuDeGocNhin, tvMoTaGocNhin;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgTieuDeGocNhin = itemView.findViewById(R.id.img_tieudegocnhin);
            tvTieuDeGocNhin = itemView.findViewById(R.id.tv_tieudegocnhin);
            tvMoTaGocNhin = itemView.findViewById(R.id.tv_motagocnhin);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, NoidungActivity.class);
                    intent.putExtra("tieude",mangGocNhin.get(getPosition()));
                    context.startActivity(intent);
                }
            });

        }
    }
}
