package com.noumi.mvp.ui;

import com.noumi.mvp.data.DataHandler;
import com.noumi.mvp.data.DataHandlerInterface;
import com.noumi.mvp.data.News;

import java.util.List;

public class ListPresenter implements IListPresenter {

    private ListActivityView mViewInterface;
    private DataHandlerInterface mDataHandlerInterface;

    public ListPresenter(ListActivityView viewInterface) {
        mViewInterface = viewInterface;
        mDataHandlerInterface = new DataHandler(this);
    }

    @Override
    public void loadNewsData() {
        mDataHandlerInterface.loadData();
    }

    @Override
    public void onResult(List<News> newsList) {
        mViewInterface.onDataLoadComplete(newsList);
    }
}
