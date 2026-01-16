package com.example.listycity;

    import android.os.Bundle;
    import android.widget.ArrayAdapter;
    import android.widget.Button;
    import android.widget.EditText;
    import android.widget.ListView;
    import androidx.appcompat.app.AppCompatActivity;
    import java.util.ArrayList;

    public class MainActivity extends AppCompatActivity {
        ListView cityList;
        ArrayAdapter<String> cityAdapter;
        ArrayList<String> dataList;
        EditText cityInput;
        Button addCityButton;
        Button deleteCityButton;
        int selected = -1;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            cityList = findViewById(R.id.city_list);
            cityInput = findViewById(R.id.city_input);
            addCityButton = findViewById(R.id.add_city_button);
            deleteCityButton = findViewById(R.id.delete_city_button);

            String[] cities = {
                    "Edmonton", "Toronto"
            };
            dataList = new ArrayList<>();
            for (String city : cities) {
                dataList.add(city);
            }
            cityAdapter = new ArrayAdapter<>(this, R.layout.content, dataList);
            cityList.setAdapter(cityAdapter);
            cityList.setOnItemClickListener((parent, view, position, id) -> {
                selected = position;
            });

            addCityButton.setOnClickListener(view -> {
                String cityName = cityInput.getText().toString().trim();
                if (!cityName.isEmpty()) {
                    dataList.add(cityName);
                    cityAdapter.notifyDataSetChanged();
                    cityInput.setText("");
                }
                ;
            });
            deleteCityButton.setOnClickListener(view -> {
                if (selected != 1) {
                    dataList.remove(selected);
                    cityAdapter.notifyDataSetChanged();
                    selected = -1;
                }
            });
        }
    }