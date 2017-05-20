package com.avinash.task.adpater;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.avinash.task.Model.ListingModel;
import com.avinash.task.R;

import java.util.ArrayList;


/**
 * Created by shachindrap on 5/19/2017.
 */

public class ListingAdapter extends RecyclerView.Adapter<ListingAdapter.ViewHolder> {
    public Context context;
    ArrayList<ListingModel> arrayList;
    LayoutInflater layoutInflater;

    public ListingAdapter(Context context, ArrayList<ListingModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_row, null);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        itemLayoutView.setLayoutParams(lp);
        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        if(position==0){
            lp.setMargins(14,20,14,10);
        }else {
            lp.setMargins(14,7,14,10);
        }
        holder.ll.setLayoutParams(lp);
        holder.title_tv.setText(arrayList.get(position).getTitle());
        holder.date_tv.setText(arrayList.get(position).getTime());
        holder.description_tv.setText(arrayList.get(position).getDetail());
        holder.imageView.setImageDrawable(arrayList.get(position).getDrawable());

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView title_tv;
        TextView date_tv;
        TextView description_tv;
        LinearLayout ll;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView           = (ImageView)itemView.findViewById(R.id.thumb_img);
            title_tv            = (TextView) itemView.findViewById(R.id.title_tv);
            date_tv             = (TextView) itemView.findViewById(R.id.date_tv);
            description_tv      = (TextView) itemView.findViewById(R.id.description_tv);
            ll                  =  (LinearLayout) itemView.findViewById(R.id.ll);
        }
    }
}
