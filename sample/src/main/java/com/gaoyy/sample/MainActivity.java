package com.gaoyy.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.gaoyy.circleindexview.CircleIndexView;

public class MainActivity extends AppCompatActivity
{
    private CircleIndexView circleIndexView;
    private EditText editText;
    private Button btn;

    private void assignViews()
    {
        circleIndexView = (CircleIndexView) findViewById(R.id.circle_index_view);
        editText = (EditText) findViewById(R.id.edit_text);
        btn = (Button) findViewById(R.id.btn);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        assignViews();
        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                int value = Integer.valueOf(editText.getText().toString());
                circleIndexView.updateIndex(value);
            }
        });
    }
}
