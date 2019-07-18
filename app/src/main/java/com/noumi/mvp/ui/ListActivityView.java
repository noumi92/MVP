package com.noumi.mvp.ui;

import com.noumi.mvp.data.News;
import java.util.List;

public interface ListActivityView {
        void onDataLoadComplete(List<News> newsList);
}
