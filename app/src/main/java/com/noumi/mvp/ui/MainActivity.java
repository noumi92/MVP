package com.noumi.mvp.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.noumi.mvp.R;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements MainActivityInterface{
    private MainActivityPresenterInterface mPresenter;
    private TextView mTextView;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView) findViewById(R.id.text_view);
        mButton = (Button) findViewById(R.id.load_button);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.presentData();
            }
        });

        mPresenter = new MainActivityPresenter(this);
    }

    @Override
    public void updateView(String result) {
        mTextView.setText(result);
    }

}
