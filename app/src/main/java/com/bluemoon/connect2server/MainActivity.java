package com.bluemoon.connect2server;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.apache.http.Header;
import org.json.JSONArray;

import java.util.List;


public class MainActivity extends Activity {

    AsyncHttpClient client = new AsyncHttpClient();
    String uri = "http://goodmorningphp.mybluemix.net/";
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //login("Kazuki","red");
        //addUser("User", "Pass");

        listView = (ListView)findViewById(R.id.rankListView);

        getRank();
    }

    public void login(String name, String pass){
        RequestParams params = new RequestParams();
        params.put("action", "login");
        params.put("name", name);
        params.put("pass", pass);

        client.get(uri, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {
                Log.i("sync", "onSuccess: send");
            }

            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
            }
        });
    }

    public void addUser(String name, String pass){
        RequestParams params = new RequestParams();
        params.put("action", "add");
        params.put("name", name);
        params.put("pass", pass);

        client.get(uri, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {
                Log.i("sync", "onSuccess: send");
            }

            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
            }
        });
    }

    public void getRank(){
        RequestParams params = new RequestParams();
        params.put("action", "getrank");

        client.get(uri, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {
                Log.i("sync", "onSuccess: send");
                JSONArray jsonArray = new JSONArray();
                try {
                    jsonArray = new JSONArray(new String(bytes));
                } catch (Exception e) {
                    e.printStackTrace();
                }

                List<RankData> list = JsonAnalytics.analysisSearchResult(jsonArray);
                RankAdapter rankAdapter = new RankAdapter(getBaseContext(),0,list);
                listView.setAdapter(rankAdapter);
            }

            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
