package com.example.hotrovn.utilities.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hotrovn.R;

import java.util.List;

public class AdapterBulletinInformation extends RecyclerView.Adapter<AdapterBulletinInformation.Holder> {

    private Context context;
    private List<String> list;

    public AdapterBulletinInformation(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recycle_helper, parent, false);
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

        private TextView tvNameOrganization;
        private TextView tvItemHelper;
        private TextView tvDate;
        private TextView tvShowDetailHelper;
        private TextView tvNumberHelper;
        private TextView tvTimeHelper;
        private LinearLayout linearLayout5;
        private TextView tvInforUserHelper;

        public Holder(@NonNull View itemView) {
            super(itemView);
            tvNameOrganization = itemView.findViewById(R.id.tvName_Organization);
            tvItemHelper = itemView.findViewById(R.id.tvItem_Helper);
            tvDate = itemView.findViewById(R.id.tvDate);
            tvShowDetailHelper = itemView.findViewById(R.id.tvShowDetail_Helper);
            tvNumberHelper = itemView.findViewById(R.id.tvNumber_Helper);
            tvTimeHelper = itemView.findViewById(R.id.tvTime_helper);
            linearLayout5 = itemView.findViewById(R.id.linearLayout5);
            tvInforUserHelper = itemView.findViewById(R.id.tvInfor_User_helper);

        }
    }
}
