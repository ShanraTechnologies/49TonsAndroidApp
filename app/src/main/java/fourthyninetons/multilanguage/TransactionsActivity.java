package fourthyninetons.multilanguage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TransactionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transactions);
        setTitle("My Transactions");
    }
}
