package com.noumi.mvp.ui;

import com.noumi.mvp.data.DataHandler;
import com.noumi.mvp.data.DataHandlerInterface;

public class MainActivityPresenter implements MainActivityPresenterInterface {

    private MainActivityInterface mViewInterface;
    private DataHandlerInterface mDataHandlerInterface;

    public MainActivityPresenter(MainActivityInterface viewInterface) {
        mViewInterface = viewInterface;
        mDataHandlerInterface = new DataHandler(this);
    }

    @Override
    public void presentData() {
        mDataHandlerInterface.loadData();
    }

    @Override
    public void onResult(String result) {
        mViewInterface.updateView(result);
    }
}
