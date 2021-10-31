package com.example.covid19tracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.covid19tracker.api.CountryData;
import com.example.covid19tracker.api.statedata;

import java.text.NumberFormat;
import java.util.List;
import java.util.Map;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder>


{
    private Context context;
    private List<CountryData> list;

    public CountryAdapter(Context context, List<CountryData> list) {
        this.context = context;
        this.list = list;

    }


    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.country_item_layout,parent,false);


        return new CountryViewHolder(view);
                                                                    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {

     CountryData data=list.get(position);
     holder.countrycases.setText(NumberFormat.getInstance().format(Integer.parseInt(data.getCases())));
     holder.countryname.setText(data.getCountry());
     holder.sn.setText(String.valueOf(position+1));


        Map<String,String> img=data.getCountryInfo();
        Glide.with(context).load(img.get("flag")).into(holder.imageView);;





    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class CountryViewHolder extends RecyclerView.ViewHolder {

        TextView sn,countryname,countrycases;
        ImageView imageView;


        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);

            sn=itemView.findViewById(R.id.sno);
            countryname=itemView.findViewById(R.id.countryName);
            countrycases=itemView.findViewById(R.id.Cases);
            imageView=itemView.findViewById(R.id.CountryImage);

        }
    }

}
