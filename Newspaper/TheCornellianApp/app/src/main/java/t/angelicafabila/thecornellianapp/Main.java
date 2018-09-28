package t.angelicafabila.thecornellianapp;

import android.content.Intent;
import android.content.res.XmlResourceParser;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import android.util.Log;
import android.view.View;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
import android.view.ViewGroup;
import android.widget.Button;
//import android.widget.Spinner;
//import android.widget.Toast;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

public class Main extends AppCompatActivity
{
    LinearLayout contentLayout;

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

        contentLayout = (LinearLayout)findViewById(R.id.contentLayout);
        XmlResourceParser parser = getResources().getXml(R.xml.cornellian_news);
        try {
            getNews(parser);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }

        configureMainButton();
        configureAboutUsButton();
        configureContactUsButton();
    }

    private void getNews(XmlResourceParser parser) throws IOException, XmlPullParserException {
        int eventType = -1;
        while (eventType != XmlResourceParser.END_DOCUMENT)
        {
            if (eventType == XmlResourceParser.START_TAG)
            {
                String itemValue = parser.getName();
                if (itemValue.equals("item"))
                {
                    String itemValue2 = parser.getName();
                    String itemValue3 = parser.getName();
                    String itemValue4 = parser.getName();
                    String itemValue5 = parser.getName();
                    if (itemValue2.equals("title") && itemValue3.equals("pubDate") && itemValue4.equals("dc:creator") && itemValue5.equals("content:encoded"))
                    {
                        String title = parser.getAttributeValue(0);
                        String pubDate = parser.getAttributeValue(0);
                        String creator = parser.getAttributeValue(0);
                        String content = parser.getAttributeValue(0);
                        printValues(title, pubDate, creator, content);

                    }
                }
            }
            eventType = parser.next();
        }

    }

    private void printValues(String title, String pubDate, String creator, String content)
    {
        LinearLayout contentData = new LinearLayout(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.weight = 1;
        contentData.setOrientation(LinearLayout.VERTICAL);

        TextView titleText = new TextView(this);
        TextView pubDateText = new TextView(this);
        TextView creatorText = new TextView(this);
        TextView contentText = new TextView(this);

        titleText.setLayoutParams(params);
        pubDateText.setLayoutParams(params);
        creatorText.setLayoutParams(params);
        contentText.setLayoutParams(params);

        titleText.setText(title);
        pubDateText.setText(pubDate);
        creatorText.setText(creator);
        contentText.setText(content);

        contentData.addView(titleText);
        contentData.addView(pubDateText);
        contentData.addView(creatorText);
        contentData.addView(contentText);

        contentLayout.addView(contentData);

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