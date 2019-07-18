package com.noumi.mvp.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.noumi.mvp.R;
import com.noumi.mvp.data.News;

import java.util.List;

public class ListActivity extends AppCompatActivity implements ListActivityView {
    private IListPresenter mPresenter;
    private RecyclerView mRecyclerView;
    private NewsAdapter mNewsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPresenter = new ListPresenter(this);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onStart() {
        super.onStart();
        mPresenter.loadNewsData();
    }

    @Override
    public void onDataLoadComplete(List<News> newsList) {
        if(mNewsAdapter == null){
            mNewsAdapter = new NewsAdapter(newsList);
            mRecyclerView.setAdapter(mNewsAdapter);
        }else
        {
            mNewsAdapter.notifyDataSetChanged();
        }
    }
}
