package com.example.checkboxlist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    List<Model> listnames;
    Context context;
    Boolean state;


    public Adapter(List<Model> listnames, Context context, Boolean state) {
        this.listnames = listnames;
        this.context = context;
        this.state = state;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {

        Model model = listnames.get(position);
        holder.txt_name.setText(model.getName());

        if(state){  // if checkbox All clicked, set All checkboxes checked
            holder.checkBox.setChecked(true);
        }else{
            holder.checkBox.setChecked(false);
        }

    }

    @Override
    public int getItemCount() {
        return listnames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txt_name;
        CheckBox checkBox;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_name=itemView.findViewById(R.id.txt_row);
            checkBox=itemView.findViewById(R.id.chkbox_row);

        }
    }
}
