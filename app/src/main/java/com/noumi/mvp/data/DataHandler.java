package com.noumi.mvp.data;

import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.noumi.mvp.ui.IListPresenter;

import java.util.ArrayList;
import java.util.List;

public class DataHandler implements DataHandlerInterface {
    private IListPresenter mPresenterInterface;
    private FirebaseFirestore mFirebaseFirestore;
    private List<News> mNewsList;

    public DataHandler(IListPresenter presenterInterface) {
        mPresenterInterface = presenterInterface;
        mFirebaseFirestore = FirebaseFirestore.getInstance();
        mNewsList = new ArrayList<>();
    }

    @Override
    public void loadData() {
        mNewsList.clear();
        mFirebaseFirestore.collection("news").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        for(QueryDocumentSnapshot documentSnapshot : task.getResult()){
                            mNewsList.add(documentSnapshot.toObject(News.class));
                        }
                        mPresenterInterface.onResult(mNewsList);
                    }
                });
    }
}