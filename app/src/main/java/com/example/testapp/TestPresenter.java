package com.example.testapp;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.testapp.api.ApiClient;
import com.example.testapp.api.ApiTest;
import com.example.testapp.model.Datum;
import com.example.testapp.model.Example;
import com.example.testapp.model.Variant;
import com.example.testapp.model.VariantText;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@InjectViewState
public class TestPresenter extends MvpPresenter<TestView> {

    public TestPresenter(String k) {
        //loadNews(k);

    }

    public   void getData(){
        ApiTest apiTest = ApiClient.getApiService();
        apiTest.getAllTodo().enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                if (response.isSuccessful()){
                   // Log.d("MainActivity",response.body().getView().get(1));
                  List<Datum> listDatum =   parseData(response.body());
                  getViewState().showData(listDatum);
                }

            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {

            }
        });
    }

    private ArrayList<Datum> parseData(Example body) {
        ArrayList<Datum> newDatumList = new ArrayList<>();
        List<String> listView = body.getView();
        List<Datum> datumList = body.getData();
        int dataSize = datumList.size();
        int viewSize = listView.size();
        // упорядочиваем список
        for (int i = 0 ;i < viewSize ;i++){
            for (int j =0 ; j < dataSize; j ++){
                if (listView.get(i).equals(datumList.get(j).getName())){
                   // Log.i("MainActivity", "true");
                    newDatumList.add(datumList.get(j));
                }
            }
        }
        //Log.i("MainActivity", String.valueOf(newDatumList.size()));
        // приводим список selectors к общему виду обьекта Datum
        List<VariantText> variantTextList = new ArrayList<>();
        int pos = 0;
        for (int i = 0 ; i < dataSize;i++){
            if (datumList.get(i).getName().equals("selector"))
                pos = i;
        }
        List<Variant> variantList = body.getData().get(pos).getData().getVariants();
        int selectedId = body.getData().get(pos).getData().getSelectedId();
        for (int i = 0 ; i< variantList.size();i++){
            String text = variantList.get(i).getText();
            int id = variantList.get(i).getId();
            VariantText variantText = new VariantText(selectedId,id,text);
            variantTextList.add(variantText);
        }
        int p = 0;
        for (int i = 0; i< newDatumList.size();i++){
            if (newDatumList.get(i).getName().equals("selector")){
             newDatumList.remove(i);
             p = i;
            }
        }
        for (int i = 0; i< variantTextList.size();i++){
            newDatumList.add(p,new Datum(variantTextList.get(i),"selector"));
            Log.i("MainActivity", String.valueOf(p));
            p++;

        }

        for (int i = 0; i< newDatumList.size();i++){
            if (newDatumList.get(i).getName().equals("selector"))
                Log.i("MainActivity", newDatumList.get(i).getName()+newDatumList.get(i).getVariantText().getText());
            else
                Log.i("MainActivity", newDatumList.get(i).getName());
        }
        Log.i("MainActivity", String.valueOf(newDatumList.size()));

        return newDatumList;
    }
}
