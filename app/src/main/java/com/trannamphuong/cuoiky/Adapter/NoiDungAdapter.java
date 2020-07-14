package com.trannamphuong.cuoiky.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.trannamphuong.cuoiky.Model.NoiDung;
import com.trannamphuong.cuoiky.R;

import java.util.ArrayList;

public class NoiDungAdapter extends RecyclerView.Adapter<NoiDungAdapter.ViewHolder> {

    Context context;
    ArrayList<NoiDung> ArrayNoiDung;


    public NoiDungAdapter(Context context, ArrayList<NoiDung> arrayNoiDung) {
        this.context = context;
        ArrayNoiDung = arrayNoiDung;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_noidung, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NoiDung noidung = ArrayNoiDung.get(position);
        Picasso.with(context).load(noidung.getUrlImgNoiDung()).into(holder.imgNoiDung);
        holder.tvMobai.setText(noidung.getMoBai());
        holder.tvKetBai.setText(noidung.getKetBai());

    }

    @Override
    public int getItemCount() {
        return ArrayNoiDung.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgNoiDung;
        TextView tvMobai, tvKetBai;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgNoiDung = itemView.findViewById(R.id.img_noidung);
            tvMobai = itemView.findViewById(R.id.mobai);
            tvKetBai = itemView.findViewById(R.id.ketbai);
        }
    }
}
