package t.angelicafabila.thecornellianapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Contact_Us extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
    }

    /* Activity to send user to the Cornellian website. */
    public void website(View view){
        Intent websiteIntent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://blogs.cornellcollege.edu/cornellian/"));
        startActivity(websiteIntent);
    }
    /* Activity to send user to the Cornellian Facebook page. */
    public void facebook(View view){
        Intent facebookIntent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://www.facebook.com/TheCornellian/"));
        startActivity(facebookIntent);
    }
    /* Activity to send user to the Cornellian Twitter page. */
    public void twitter(View view){
        Intent twitterIntent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://www.google.com/")); //TODO
        startActivity(twitterIntent);
    }
}
