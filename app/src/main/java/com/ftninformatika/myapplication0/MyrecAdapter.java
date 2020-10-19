package com.ftninformatika.myapplication0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyrecAdapter extends RecyclerView.Adapter<MyrecAdapter.MyViewHolder> {
    private List<String>data;
    private OnElementClickListener listener;

    public MyrecAdapter(OnElementClickListener listener,List<String> data) {
        this.data = data;
        this.listener=listener;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.singleitem,parent,false);
        MyViewHolder viewHolder=new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bind(listener,data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tvText;
        private View wholeView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvText=itemView.findViewById(R.id.tvtext);//zato sto imam cardview
            wholeView=itemView;
        }
        public void bind(final OnElementClickListener listener, final String item){
            tvText.setText(item);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onElementClicked(item);
                }
            });
        }
    }
    public interface OnElementClickListener{
        void onElementClicked(String s);
    }
}
