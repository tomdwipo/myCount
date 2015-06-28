package com.example.android.mycount;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btnTambah;
    private Button btnReset;
    private Button btnReport;
    private TextView text;
    private int ctr;
    private int countReset;
    private int allTime;
    private int lastReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView)findViewById(R.id.text);

        btnTambah = (Button)findViewById(R.id.tambah);
        btnReset = (Button)findViewById(R.id.reset);

        btnReport = (Button)findViewById(R.id.report);
        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                allTime++;

                ctr = ctr+1;
                updateText();

            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastReset=ctr;
                ctr = 0;

                countReset++;
                updateText();

            }
        });
        btnReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , ReportActivity.class);
                intent.putExtra("current Count",ctr);
                intent.putExtra("count Reset",countReset);
                intent.putExtra("allTime",allTime);
                intent.putExtra("last Reset",lastReset);
                startActivity(intent);
            }
        });
    }

    public void updateText(){
        text = (TextView)findViewById(R.id.text);
        String ct = String.valueOf(ctr);
        text.setText(ct);
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
