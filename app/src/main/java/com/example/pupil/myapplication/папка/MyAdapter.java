package com.example.pupil.myapplication.папка;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pupil.myapplication.Pupil;
import com.example.pupil.myapplication.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Pupil> list;

    public MyAdapter(List<Pupil> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.listitem, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.onBind(list.get(i));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtName, txtSurname, txtCount;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtSurname = itemView.findViewById(R.id.txtSurname);
            txtCount = itemView.findViewById(R.id.txtCount);
        }

        void onBind(Pupil pupil) {
            txtName.setText(pupil.getName());
            txtSurname.setText(pupil.getSurname());
            txtCount.setText(String.valueOf(getAdapterPosition() + 1));

        }
    }
}
