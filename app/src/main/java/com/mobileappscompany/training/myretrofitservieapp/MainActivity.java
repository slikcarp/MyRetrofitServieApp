package com.mobileappscompany.training.myretrofitservieapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MAC";
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listItemView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        callRxRetrofit();


    }

    private void initializeListView(List<GitHub> values) {
        ArrayAdapter<GitHub> adapter = new ArrayAdapter<GitHub>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);


        // Assign adapter to ListView
        listView.setAdapter(adapter);

        // ListView Item Click Listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition     = position;

                // ListView Clicked item value
                String  itemValue    = (String) listView.getItemAtPosition(position);

                // Show Alert
                Toast.makeText(getApplicationContext(),
                        "Position :"+itemPosition+"  ListItem : " +itemValue , Toast.LENGTH_LONG)
                        .show();

            }

        });
    }

    private void callRxRetrofit() {
        Observable<List<GitHub>> resultObservable = RetrofitService.Factory.create("pepe-romeros");

        resultObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<GitHub>>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted: Observable is done.");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: An error occurred.", e);
                    }

                    @Override
                    public void onNext(List<GitHub> gitHubs) {
                        initializeListView(gitHubs);
                        for(GitHub repo: gitHubs) {
                            Log.d(TAG, "onNext: " + repo.toString());
                        }
                    }
                });
    }
}
