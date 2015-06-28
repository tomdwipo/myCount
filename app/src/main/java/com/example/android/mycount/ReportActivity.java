package com.example.android.mycount;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class ReportActivity extends AppCompatActivity {
    private TextView txtCurrentCount, txtLastReset, txtCountReset, txtAllTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        txtCurrentCount = (TextView)findViewById(R.id.txtCurrentCount);
        txtLastReset = (TextView)findViewById(R.id.txtLastReset);
        txtCountReset = (TextView)findViewById(R.id.txtCountReset);
        txtAllTime = (TextView)findViewById(R.id.txtAllTime);

        Bundle b = getIntent().getExtras();
        txtCurrentCount.setText(String.valueOf(b.getInt("current Count")));
        txtLastReset.setText(String.valueOf(b.getInt("last Reset")));
        txtCountReset.setText(String.valueOf(b.getInt("count Reset")));
        txtAllTime.setText(String.valueOf(b.getInt("allTime")));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_report, menu);
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
