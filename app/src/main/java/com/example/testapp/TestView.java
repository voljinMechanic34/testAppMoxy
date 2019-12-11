package com.example.testapp;

import com.arellomobile.mvp.MvpView;
import com.example.testapp.model.Datum;

import java.util.List;

public interface TestView extends MvpView {
    void showData(List<Datum> datumList);
}
