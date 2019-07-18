package com.noumi.mvp.ui;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.noumi.mvp.R;
import com.noumi.mvp.data.News;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsHolder> {
    private List<News> mNewsList;

    public NewsAdapter(List<News> newsList) {
        mNewsList = newsList;
    }

    @NonNull
    @Override
    public NewsHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.list_item, viewGroup, false);
        return new NewsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsHolder newsHolder, int position) {
        News news = mNewsList.get(position);
        newsHolder.mTitleTextView.setText(news.getTitle());
        newsHolder.mIntroTextView.setText(news.getIntro());
    }

    @Override
    public int getItemCount() {
        return mNewsList.size();
    }

    public class NewsHolder extends RecyclerView.ViewHolder{
        private TextView mTitleTextView, mIntroTextView;
        public NewsHolder(@NonNull View itemView) {
            super(itemView);
            mTitleTextView = (TextView) itemView.findViewById(R.id.news_title);
            mIntroTextView = (TextView) itemView.findViewById(R.id.news_intro);
        }
    }
}
