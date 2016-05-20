package fourthyninetons.multilanguage;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatCheckBox;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Locale;

public class LanguageSelector extends AppCompatActivity {
    final String APP_LANG = "APP_LANG";
    final String LANG_PREF_SET = "LANG_PREF_SET";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_language_selector);

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        if (pref.getBoolean(LANG_PREF_SET, false)) {

            setLanguage(pref.getString(APP_LANG, "en"));
            startActivity(new Intent(getApplicationContext(), MaterialSelector.class));
        }

        String languages[] = {"English", "हिन्दी", "मराठी"};
        final String lang_codes[] = {"en", "hi", "mr"};

        final Dialog dialog = new Dialog(LanguageSelector.this);
        dialog.setContentView(R.layout.language_list);

        final AppCompatCheckBox defaultCheckBox = (AppCompatCheckBox) dialog.findViewById(R.id.isDefaultCheckbox);

        ListView lv = (ListView) dialog.findViewById(R.id.lv);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, languages);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                setAppLanguage(lang_codes[position], defaultCheckBox.isChecked());
                dialog.dismiss();
                startActivity(new Intent(getApplicationContext(), MaterialSelector.class));
            }
        });
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }

    public void setAppLanguage(String language, Boolean setDefault) {

        setLanguage(language);

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean(LANG_PREF_SET, setDefault);

        if (setDefault) {
            editor.putString(APP_LANG, language);
        }

        editor.commit();
    }

    public void setLanguage(String language) {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);

        Configuration config = new Configuration();
        config.locale = locale;

        getBaseContext().getResources().updateConfiguration(config,
                getBaseContext().getResources().getDisplayMetrics());
    }
}
