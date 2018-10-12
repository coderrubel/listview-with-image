package com.example.rubel.customlistviewwithimage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    Toolbar mToolbar;
    ListView mListView;
    ListView listView;

    String[] countryName = {"Bangladesh","Afghanistan","South Africa","Australia","Brazil","India","Japan","Pakistan","Saudi_Arabia","Uganda"};
    int[] countryFlag = {R.drawable.bangladesh,
        R.drawable.afghanistan,
        R.drawable.africa,
        R.drawable.australia,
        R.drawable.brazil,
        R.drawable.india,
        R.drawable.japan,
        R.drawable.pakistan,
        R.drawable.saudi_arabia,
        R.drawable.uganda,
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView = findViewById(R.id.list_view);

        final String[] value = getResources().getStringArray(R.array.city);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,R.layout.activity_detales,R.id.city_name,value);

        listView.setAdapter(adapter);

        mToolbar = (Toolbar) findViewById(R.id.toolbar); //Toolbar Title

        mToolbar.setTitle(getResources().getString(R.string.app_name)); // Image

        mListView = (ListView) findViewById(R.id.list_view);
        MyAdaptar myAdaptar = new MyAdaptar(MainActivity.this,countryName,countryFlag);
        mListView.setAdapter(myAdaptar);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String setItem = value[position];
                Intent mInten = new Intent(MainActivity.this,DetalesActivity.class);
                mInten.putExtra("countryName",countryName[position]);
                mInten.putExtra("countryFlag",countryFlag[position]);
                mInten.putExtra("setItem",value[position]);
                startActivity(mInten);

             //   Toast.makeText(MainActivity.this, setItem+" "+ position,Toast.LENGTH_SHORT).show();

            }
        });
    }
}
