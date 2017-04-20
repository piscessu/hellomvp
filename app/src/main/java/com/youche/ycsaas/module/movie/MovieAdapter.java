package com.youche.ycsaas.module.movie;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.youche.ycsaas.R;

import java.util.List;

/**
 * Created by SuChangz on 2017/4/19.
 * Desc
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {

    private Context mContext;
    private List<MovieEntity.SubjectsBean> mSubjectsBeanList;

    public MovieAdapter(Context context, List<MovieEntity.SubjectsBean> subjectsBeanList) {
        mContext = context;
        mSubjectsBeanList = subjectsBeanList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.movielist_rcv_item, parent, false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.mTextView.setText(mSubjectsBeanList.get(position).getTitle());
        Glide.with(mContext).load(mSubjectsBeanList.get(position).getImages().getLarge()).into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        return mSubjectsBeanList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mTextView;
        ImageView mImageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.tv);
            mImageView = (ImageView) itemView.findViewById(R.id.iv);
        }
    }
}
