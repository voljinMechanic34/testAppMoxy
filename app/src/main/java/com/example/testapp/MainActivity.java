package com.example.testapp;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.testapp.adapters.OnItemClickListener;
import com.example.testapp.adapters.TestAdapter;
import com.example.testapp.model.Datum;

import java.util.List;

public class MainActivity extends MvpAppCompatActivity implements TestView , OnItemClickListener {

    RecyclerView recyclerView;
    @InjectPresenter
    TestPresenter testPresenter;

    @ProvidePresenter
    TestPresenter provideTestPresenter(){
        return new TestPresenter("1235678");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        LinearLayoutManager recyclerLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recyclerLayoutManager);
        testPresenter.getData();
    }


    @Override
    public void showData(List<Datum> datumList) {
        TestAdapter testAdapter = new TestAdapter(datumList,this);
        recyclerView.setAdapter(testAdapter);
        //Log.i(MainActivity.class.getSimpleName(),text);
    }

    @Override
    public void onHzClick(String s) {
        Toast.makeText(getBaseContext(),s,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSelectorClick(String s) {
        Toast.makeText(getBaseContext(),s,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPictureClick(String text) {
        Toast.makeText(getBaseContext(),text,Toast.LENGTH_SHORT).show();
    }
}
