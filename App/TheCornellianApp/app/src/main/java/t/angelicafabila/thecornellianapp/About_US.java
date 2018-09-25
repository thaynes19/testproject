package t.angelicafabila.thecornellianapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class About_US extends AppCompatActivity {

    ListView aboutus;

    String [] strings = {"Editorial Board", "Editor-in-Chief: M.E. Scoonover-Nelson",
            "Assistant Editor-in-Chief: Angelica Fabila", "News Editor:","Features Editor:",
            "Arts and Entertainment Editor", "Copy Editor", "Layout Editor", "Social Media Manager",
             "Photographer"};

    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about__us);

        aboutus = (ListView) findViewById(R.id.ListView);
        adapter = new ArrayAdapter(About_US.this, android.R.layout.simple_list_item_1, strings);

        aboutus.setAdapter(adapter);

        aboutus.setOnClickListener(new AdapterView.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(About_US.this, "" + strings, Toast.LENGTH_LONG).show();
            }
        });
    }
}
