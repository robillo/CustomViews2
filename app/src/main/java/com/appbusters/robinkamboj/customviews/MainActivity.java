package com.appbusters.robinkamboj.customviews;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.one:{
                startActivity(new Intent(this, ShapesActivity.class));
                break;
            }
            case R.id.two:{

                break;
            }
            case R.id.three:{

                break;
            }
            case R.id.four:{

                break;
            }
            case R.id.five:{

                break;
            }
            case R.id.six:{

                break;
            }
        }
    }
}
