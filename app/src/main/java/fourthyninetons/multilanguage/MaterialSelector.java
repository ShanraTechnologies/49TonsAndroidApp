package fourthyninetons.multilanguage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MaterialSelector extends AppCompatActivity {

    private ExpandableListView expListView;
    private ListAdapterExpandable adapter;

    // declare array List for all headers in list
    ArrayList<String> headersArrayList = new ArrayList<String>();

    // Declare Hash map for all headers and their corresponding values
    HashMap<String, ArrayList<String>> childArrayList = new HashMap<String, ArrayList<String>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_selector);
        setTitle("Select Material Type");
        expListView = (ExpandableListView) findViewById(R.id.expListView);

        // add headers values
        headersArrayList.add("Construction Material");
        headersArrayList.add("FMCG Products");
        headersArrayList.add("Agro, Meat & Dairy Products");

        // add add child content
        ArrayList<String> daysOfWeekArrayList = new ArrayList<String>();
        daysOfWeekArrayList.add("Cement");
        daysOfWeekArrayList.add("Granite Stones");
        daysOfWeekArrayList.add("Sand");
        daysOfWeekArrayList.add("Paint");
        daysOfWeekArrayList.add("Gravel, Stones, Marble etc");
        daysOfWeekArrayList.add("Other construction material ");

        childArrayList.put("Construction Material", daysOfWeekArrayList);

        ArrayList<String> festivalArrayList = new ArrayList<String>();
        festivalArrayList.add("Soaps, Detergents, Biscuits etc.");
        festivalArrayList.add("Coke, Fanta, Bisleri etc.");

        childArrayList.put("FMCG Products", festivalArrayList);

        ArrayList<String> colorsArrayList = new ArrayList<String>();
        colorsArrayList.add("Grains, Dal, Sugarcane etc.");
        colorsArrayList.add("Eggs");
        colorsArrayList.add("Milk / Butter etc.");
        colorsArrayList.add("Apples, Onions, Coconuts etc.");
        colorsArrayList.add("Hens, Cattle etc.");
        colorsArrayList.add("Fish / Sea food / Chicken etc.");


        childArrayList.put("Agro, Meat & Dairy Products", colorsArrayList);


        // declare adapter

        adapter = new ListAdapterExpandable(this, headersArrayList,
                childArrayList);

        expListView.setAdapter(adapter);

        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                //Toast.makeText(getApplicationContext(), "Child is clicked", //Toast.LENGTH_LONG).show();
                return false;
            }
        });

        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // TODO: Do your stuff
                //Toast.makeText(getApplicationContext(), "Group is Clicked", //Toast.LENGTH_LONG).show();
                return false;
            }
        });
        expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                // TODO: Do your stuff
                //Toast.makeText(getApplicationContext(), "Child is Collapsed", //Toast.LENGTH_LONG).show();
            }
        });

        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                // TODO: Do your stuff

                //Toast.makeText(getApplicationContext(), "Child is Expanded", //Toast.LENGTH_LONG).show();
            }
        });
    }
}
