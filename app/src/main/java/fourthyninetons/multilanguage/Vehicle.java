package fourthyninetons.multilanguage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Vehicle extends AppCompatActivity {

    String[] vehicleArray = {"Motorcycle", "Small Commercial Vehicle", "Intermediate Commercial Vehicle", "Medium Commercial Vehicle",
            "Large Commercial Vehicle", "Heavy Commercial Vehicle", "Trailer"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle);
        setTitle("Select Vehicle Type");
        ArrayAdapter adapter = new ArrayAdapter<>(this, R.layout.simple_list_item_1, vehicleArray);

        ListView listView = (ListView) findViewById(R.id.vehicle_list);
        listView.setAdapter(adapter);
    }
}
