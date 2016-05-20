package fourthyninetons.multilanguage;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class RoleSelectorActiviry extends AppCompatActivity {

//    public void scaleView(View v, float startScale, float endScale) {
//        Animation anim = new ScaleAnimation(
//                0f, 0f,                            // Start and end values for the X axis scaling
//                startScale, endScale,              // Start and end values for the Y axis scaling
//                Animation.RELATIVE_TO_SELF, 1f,    // Pivot point of X scaling
//                Animation.RELATIVE_TO_SELF, 0.5f); // Pivot point of Y scaling
//        anim.setFillAfter(true);                   // Needed to keep the result of the animation
//        anim.setDuration(500);
//        v.startAnimation(anim);
//    }

    CardView loadProviderCard, transporterCard;
    TextView loadProviderTV, transporterTV;
    final String ROLE_SET = "ROLE_SET";
    Button btnContinue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_role_selector_activiry);

        loadProviderCard = (CardView) findViewById(R.id.cardLoadProvider);
        loadProviderTV = (TextView) findViewById(R.id.TVLoadProviderDesc);

        transporterCard = (CardView) findViewById(R.id.cardTransporter);
        transporterTV = (TextView) findViewById(R.id.TVTransporterDesc);

        btnContinue = (Button) findViewById(R.id.continueButton);

        btnContinue.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MapsActivity.class));
            }

        });

        loadProviderCard.setOnClickListener(new View.OnClickListener() {
            final Handler handler = new Handler();

            @Override
            public void onClick(View v) {
//                    (new Thread(){
//                        int i;
//                        @Override
//                        public void run(){
//                            for(i=120; i<255; i++){
//                                handler.post(new Runnable(){
//                                    public void run(){
//                                        transporterTV.setBackgroundColor(Color.argb(55, i, i-150, i-221));
//                                    }
//                                });
//                                // next will pause the thread for some time
//                                try{
//                                    sleep(5);
//                                }
//                                catch(Exception ex)
//                                {
//                                    break;
//                                }
//                            }
//                        }
//                    }).start();

                loadProviderTV.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.sel_role));
                transporterTV.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.de_sel_role));
                loadProviderTV.setTextColor(Color.BLACK);
                transporterTV.setTextColor(Color.GRAY);

                SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                SharedPreferences.Editor editor = pref.edit();
                editor.putInt(ROLE_SET, 0); //Load Provider
                editor.commit();

            }
        });

        transporterCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadProviderTV.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.de_sel_role));
                transporterTV.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.sel_role));
                transporterTV.setTextColor(Color.BLACK);
                loadProviderTV.setTextColor(Color.GRAY);

                SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                SharedPreferences.Editor editor = pref.edit();
                editor.putInt(ROLE_SET, 1); //Transporter
                editor.commit();
            }
        });
    }

    public void continueWithSelection(View v) {

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        Toast.makeText(getApplicationContext(), Integer.toString(pref.getInt(ROLE_SET, -1)), Toast.LENGTH_LONG).show();
//        startActivity(new Intent(getApplicationContext(), MapsActivity.class));
//


    }
}
