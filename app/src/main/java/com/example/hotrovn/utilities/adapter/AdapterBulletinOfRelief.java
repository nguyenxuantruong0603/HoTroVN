package com.example.hotrovn.utilities.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hotrovn.R;

import java.util.List;

public class AdapterBulletinOfRelief extends RecyclerView.Adapter<AdapterBulletinOfRelief.Holder> {
    private Context context;
    private List<String> list;

    public AdapterBulletinOfRelief(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_recycle_bulletin_of_relief,parent,false);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class Holder extends RecyclerView.ViewHolder {

        private TextView tvLocationBulletinRelief;
        private TextView tvItemNeedHelped;
        private TextView tvNumberHelper;
        private TextView tvTime;
        private TextView tvDate;
        private TextView tvShowDetail;
        public Holder(@NonNull View itemView) {
            super(itemView);

            tvLocationBulletinRelief = itemView.findViewById(R.id.tvLocation_bulletin_relief);
            tvItemNeedHelped = itemView.findViewById(R.id.tvItem_Need_Helped);
            tvNumberHelper = itemView.findViewById(R.id.tvNumber_Helper);
            tvTime = itemView.findViewById(R.id.tvTime);
            tvDate = itemView.findViewById(R.id.tvDate);
            tvShowDetail = itemView.findViewById(R.id.tvShowDetail);

        }
    }
}
