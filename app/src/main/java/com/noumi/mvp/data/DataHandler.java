package com.noumi.mvp.data;

import com.noumi.mvp.ui.MainActivityPresenterInterface;

public class DataHandler implements DataHandlerInterface {
    private MainActivityPresenterInterface mPresenterInterface;

    public DataHandler(MainActivityPresenterInterface presenterInterface) {
        mPresenterInterface = presenterInterface;
    }

    @Override
    public void loadData() {
        String data = "Data Loaded";
        mPresenterInterface.onResult(data);
    }
}
