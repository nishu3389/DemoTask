package com.avinash.task.adpater;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.avinash.task.Model.BannerModel;
import com.avinash.task.R;

import java.util.ArrayList;


/**
 * Created by shachindrap on 5/11/2017.
 */

public class SlidingImage_Adapter extends PagerAdapter {

    private ArrayList<BannerModel> arrayList;
    private LayoutInflater inflater;
    private Context context;
    public SlidingImage_Adapter(Context context, ArrayList<BannerModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        inflater = LayoutInflater.from(context);

    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        View imageLayout = inflater.inflate(R.layout.images_layout_row, view, false);
        ImageView imageView = (ImageView) imageLayout.findViewById(R.id.image);
        imageView.setImageDrawable(arrayList.get(position).getDrawable());

        TextView title1 = (TextView) imageLayout.findViewById(R.id.heading1);
        title1.setText(arrayList.get(position).getTitle1());

        TextView title2 = (TextView) imageLayout.findViewById(R.id.heading2);
        title2.setText(arrayList.get(position).getTitle2());

        view.addView(imageLayout, 0);

        return imageLayout;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
    }

    @Override
    public Parcelable saveState() {
        return null;
    }

}