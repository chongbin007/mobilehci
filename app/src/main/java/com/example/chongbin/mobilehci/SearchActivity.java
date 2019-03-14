package com.example.chongbin.mobilehci;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.ImageButton;

public class SearchActivity extends AppCompatActivity {
    private ImageButton button1;
    private ImageButton button2;
    private ImageButton button3;
    private ImageButton button4;
    private ImageButton button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        SearchView simpleSearchView = (SearchView) findViewById(R.id.search_activity);
        simpleSearchView.setIconifiedByDefault(true);

        button1 = (ImageButton) this.findViewById(R.id.add_btn1);
        changeButtonState(button1);
        button2 = (ImageButton) this.findViewById(R.id.add_btn2);
        changeButtonState(button2);
        button3 = (ImageButton) this.findViewById(R.id.add_btn3);
        changeButtonState(button3);
        button4 = (ImageButton) this.findViewById(R.id.add_btn4);
        changeButtonState(button4);
        button5 = (ImageButton) this.findViewById(R.id.add_btn5);
        changeButtonState(button5);



    }
    private void changeButtonState(final ImageButton button){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setEnabled(false);
            }
        });
    }
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}