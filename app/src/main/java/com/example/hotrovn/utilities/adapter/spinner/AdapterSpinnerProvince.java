package com.example.hotrovn.utilities.adapter.spinner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.hotrovn.R;
import com.example.hotrovn.utilities.model.country.Province;


import java.util.List;

public class AdapterSpinnerProvince extends ArrayAdapter<Province> {
    public AdapterSpinnerProvince(Context context, List<Province> countryList) {
        super(context, 0, countryList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    private View initView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.custom_spinner, parent, false
            );
        }
        ImageView imageViewFlag = convertView.findViewById(R.id.ImgSpin_Country);
        TextView textViewName = convertView.findViewById(R.id.tvSpin_Country);
        Province currentItem = getItem(position);
        if (currentItem != null) {
            imageViewFlag.setVisibility(View.GONE);
            textViewName.setText(currentItem.getName());
        }
        return convertView;
    }
}
