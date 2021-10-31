package com.example.covid19tracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Response;
import com.example.covid19tracker.api.statedata;

import org.json.JSONObject;

import java.util.List;

public class stateAdapter extends RecyclerView.Adapter<stateAdapter.stateViewHolder>{

    private Context context;

    public stateAdapter(Context context, List<statedata> list) {
        this.context =context;
        this.list = list;
    }

    private List<statedata> list;

    @NonNull
    @Override
    public stateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.singlerowstate,parent,false);


        return new stateViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull stateViewHolder holder, int position) {

        statedata data=list.get(position);
        holder.state.setText(data.getLoc());
       holder.death.setText(data.getDeaths());
        holder.cases.setText(data.getTotalConfirmed());






    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class stateViewHolder extends RecyclerView.ViewHolder{
      TextView cases,state,sno,death;



        public stateViewHolder(@NonNull View itemView) {
            super(itemView);

            cases=itemView.findViewById(R.id.Cases);
            state=itemView.findViewById(R.id.stateName);
            sno=itemView.findViewById(R.id.sno);
            death=itemView.findViewById(R.id.Death);


        }
    }


}
