package com.mobile.fuhome.app.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.mobile.fuhome.app.R;

import java.util.List;
import java.util.Map;

/**
 * Created by Ryan on 2016/8/1.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

    private List<Map<String,String>>data;
    private OnItemClickListener onItemClickListener;

    public MyAdapter(List<Map<String, String>> data) {
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.control_btn_item, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Map<String, String> map = data.get(position);
        String state = map.get("comname");
        holder.mButton.setText(state);
        holder.mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }




    public class ViewHolder extends RecyclerView.ViewHolder{
        public Button mButton;
        public ViewHolder(View view) {
            super(view);
            mButton = (Button) view;
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener{
        void onClick(int position);
    }
}
