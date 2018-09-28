package t.angelicafabila.thecornellianapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import android.util.Log;
import android.view.View;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
import android.widget.Button;
//import android.widget.Spinner;
//import android.widget.Toast;
import android.support.v7.widget.Toolbar;

public class Main extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //add Toolbar
        Toolbar toolbar = findViewById(R.id.actionbar);
        setSupportActionBar(toolbar);

        // Spinner Widget/Dropdown
//        Spinner menuSpinner = findViewById(R.id.spinner_main);
//
//        ArrayAdapter<String> myAdapter = new ArrayAdapter<>(Main.this,
//                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.items));
//        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        menuSpinner.setAdapter(myAdapter);

        configureMainButton();
        configureAboutUsButton();
        configureContactUsButton();
    }

    private void configureMainButton()
    {
        Button mainButton = (Button) findViewById(R.id.MainButton);
        mainButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(Main.this, Main.class));
            }
        });
    }

    private void configureAboutUsButton()
    {
        Button aboutUsButton = (Button) findViewById(R.id.AboutUsButton);
        aboutUsButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(Main.this, About_Us.class));
            }
        });
    }

    private void configureContactUsButton()
    {
        Button contactUsButton = (Button) findViewById(R.id.ContactUsButton);
        contactUsButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(Main.this, Contact_Us.class));
            }
        });
    }
}