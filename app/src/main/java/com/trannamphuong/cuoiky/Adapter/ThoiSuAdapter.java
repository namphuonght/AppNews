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
import com.trannamphuong.cuoiky.Model.ThoiSu;
import com.trannamphuong.cuoiky.R;

import java.util.ArrayList;

public class ThoiSuAdapter extends RecyclerView.Adapter<ThoiSuAdapter.ViewHolder>{

    Context context;
    ArrayList<ThoiSu> mangThoiSu;

    public ThoiSuAdapter(Context context, ArrayList<ThoiSu> mangThoiSu) {
        this.context = context;
        this.mangThoiSu = mangThoiSu;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, final int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_thoisu, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ThoiSu thoisu = mangThoiSu.get(position);
        holder .tvTieuDeThoiSu.setText(thoisu.getTieuDe());
        holder.tvMoTaThoiSu.setText(thoisu.getMoTa());
        Picasso.with(context).load(thoisu.getUrlImg()).into(holder.imgTieuDeThoiSu);
    }

    @Override
    public int getItemCount() {
        return mangThoiSu.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgTieuDeThoiSu;
        TextView tvTieuDeThoiSu, tvMoTaThoiSu;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgTieuDeThoiSu = itemView.findViewById(R.id.img_tieudethoisu);
            tvTieuDeThoiSu = itemView.findViewById(R.id.tv_tieudethoisu);
            tvMoTaThoiSu = itemView.findViewById(R.id.tv_motathoisu);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, NoidungActivity.class);
                    intent.putExtra("tieude",mangThoiSu.get(getPosition()));
                    context.startActivity(intent);
                }
            });

        }
    }
}
