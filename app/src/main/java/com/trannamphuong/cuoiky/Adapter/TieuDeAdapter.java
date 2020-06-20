package com.trannamphuong.cuoiky.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.trannamphuong.cuoiky.Model.TieuDe;
import com.trannamphuong.cuoiky.R;

import java.util.ArrayList;

public class TieuDeAdapter extends RecyclerView.Adapter<TieuDeAdapter.ViewHolder>{

    Context context;
    ArrayList<TieuDe> mangTieuDe;

    public TieuDeAdapter(Context context, ArrayList<TieuDe> mangTieuDe) {
        this.context = context;
        this.mangTieuDe = mangTieuDe;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_tieude, parent, false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "da click vao day", Toast.LENGTH_SHORT).show();
            }
        });
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TieuDe tieude = mangTieuDe.get(position);
        holder .tvTieuDe.setText(tieude.getTieuDe());
        holder.tvMoTa.setText(tieude.getMoTa());
        Picasso.with(context).load(tieude.getUrlImg()).into(holder.imgTieuDe);
    }

    @Override
    public int getItemCount() {
        return mangTieuDe.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgTieuDe;
        TextView tvTieuDe, tvMoTa;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgTieuDe = itemView.findViewById(R.id.img_tieude);
            tvTieuDe = itemView.findViewById(R.id.tv_tieude);
            tvMoTa = itemView.findViewById(R.id.tv_mota);

        }
    }
}
