package fourthyninetons.multilanguage;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class SummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        setTitle("Summary");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.summary_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.confirmButton:
//                ProgressDialog progress = new ProgressDialog(this);
//                progress.setMessage("Please wait while we search a vehicle for you");
//                progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
//                progress.setIndeterminate(true);
//                progress.show();
//                break;

                AlertDialog.Builder alertadd = new AlertDialog.Builder(
                        SummaryActivity.this);
                LayoutInflater factory = LayoutInflater.from(SummaryActivity.this);
                final View view = factory.inflate(R.layout.alert_error, null);
                alertadd.setView(view);
                alertadd.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dlg, int sumthin) {
                        dlg.cancel();
                    }
                });
                alertadd.show();
        }
        return true;
    }
}
