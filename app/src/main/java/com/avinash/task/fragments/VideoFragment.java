package com.avinash.task.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.avinash.task.Model.ListingModel;
import com.avinash.task.R;
import com.avinash.task.adpater.ListingAdapter;

import java.util.ArrayList;



public class VideoFragment extends Fragment {

    private RecyclerView video_rv;
    private ListingAdapter mListingAdapter;
    ArrayList<ListingModel> arrayList;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_video, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        arrayList = new ArrayList<>();
        video_rv = (RecyclerView) view.findViewById(R.id.video_rv);
        video_rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        arrayList.add(new ListingModel(
                        getResources().getString(R.string.dummy_title1),
                        getResources().getString(R.string.dummy_time1),
                        getResources().getString(R.string.dummy_text),
                        getResources().getDrawable(R.drawable.guitar1)
                )
        );
        arrayList.add(new ListingModel(
                        getResources().getString(R.string.dummy_title2),
                        getResources().getString(R.string.dummy_time2),
                        getResources().getString(R.string.dummy_text),
                        getResources().getDrawable(R.drawable.guitar2)
                )
        );
        arrayList.add(new ListingModel(
                        getResources().getString(R.string.dummy_title3),
                        getResources().getString(R.string.dummy_time3),
                        getResources().getString(R.string.dummy_text),
                        getResources().getDrawable(R.drawable.guitar3)
                )
        );
        arrayList.add(new ListingModel(
                        getResources().getString(R.string.dummy_title4),
                        getResources().getString(R.string.dummy_time4),
                        getResources().getString(R.string.dummy_text),
                        getResources().getDrawable(R.drawable.guitar4)
                )
        );
        arrayList.add(new ListingModel(
                        getResources().getString(R.string.dummy_title5),
                        getResources().getString(R.string.dummy_time5),
                        getResources().getString(R.string.dummy_text),
                        getResources().getDrawable(R.drawable.guitar5)
                )
        ); calladapter();
    }

    private void calladapter() {
        mListingAdapter = new ListingAdapter(getActivity(), arrayList);
        video_rv.setAdapter(mListingAdapter);
    }
}
