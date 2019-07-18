package com.noumi.mvp.ui;

import com.noumi.mvp.data.News;
import java.util.List;

public interface IListPresenter {
    void loadNewsData();
    void onResult(List<News> newsList);
}
