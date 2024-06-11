package com.example.test_login;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;
import android.widget.EditText;

import java.util.ArrayList;

public class InvestmentsActivity extends AppCompatActivity {

    private CustomAdapter adapter;
    private ArrayList<String> dataSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_investments);

        ListView listView = findViewById(R.id.listViewInvestments);

        dataSet = new ArrayList<>();
        dataSet.add("Énergie solaire");
        dataSet.add("Transport en commun électrique");
        dataSet.add("Agriculture biologique");
        dataSet.add("Recyclage des déchets");
        dataSet.add("Efficacité énergétique des bâtiments");
        dataSet.add("Énergie éolienne");
        dataSet.add("Transports en commun");
        dataSet.add("Investissement dans les forêts durables");
        dataSet.add("Traitement des eaux usées");
        dataSet.add("Voitures électriques");
        dataSet.add("Énergie hydroélectrique");
        dataSet.add("Production d'aliments locaux");

        adapter = new CustomAdapter(this, dataSet);
        listView.setAdapter(adapter);

        Button searchButton = findViewById(R.id.buttonSearch);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filterInvestments();
            }
        });
    }

    private void filterInvestments() {
        EditText editTextSearch = findViewById(R.id.editTextSearch);
        String searchText = editTextSearch.getText().toString().toLowerCase();

        ArrayList<String> filteredList = new ArrayList<>();
        for (String investment : dataSet) {
            if (investment.toLowerCase().contains(searchText)) {
                filteredList.add(investment);
            }
        }

        adapter.clear();
        adapter.addAll(filteredList);
        adapter.notifyDataSetChanged();
    }
}
