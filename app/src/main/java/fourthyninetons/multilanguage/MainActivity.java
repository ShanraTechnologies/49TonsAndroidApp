package fourthyninetons.multilanguage;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    AppCompatButton clearPref;
    final String LANG_PREF_SET = "LANG_PREF_SET";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clearPref = (AppCompatButton) findViewById(R.id.clearPref);

        clearPref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                SharedPreferences.Editor editor = pref.edit();
                editor.putBoolean(LANG_PREF_SET, false);
                editor.commit();
            }
        });

    }
}
