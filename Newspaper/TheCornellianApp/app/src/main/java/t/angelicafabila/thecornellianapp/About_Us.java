package t.angelicafabila.thecornellianapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;


public class About_Us extends AppCompatActivity {

    ListView aboutus;

    String [] strings = {"Editorial Board", "Editor-in-Chief: M.E. Scoonover-Nelson",
            "Assistant Editor-in-Chief: Angelica Fabila", "News Editor:","Features Editor:",
            "Arts and Entertainment Editor", "Copy Editor", "Layout Editor", "Social Media Manager",
             "Photographer"};

    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        //aboutus = (ListView) findViewById(R.id.ListView);
        adapter = new ArrayAdapter(About_Us.this, android.R.layout.simple_list_item_1, strings);

        aboutus.setAdapter(adapter);

        aboutus.setOnClickListener(new AdapterView.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(About_Us.this, "" + strings, Toast.LENGTH_LONG).show();
            }
        });

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
                startActivity(new Intent(About_Us.this, Main.class));
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
                startActivity(new Intent(About_Us.this, About_Us.class));
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
                startActivity(new Intent(About_Us.this, Contact_Us.class));
            }
        });
    }
}
