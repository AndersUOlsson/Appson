package se.appson.www.appson;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class companySettings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_settings);
    }


    public void backToHomePage (View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
