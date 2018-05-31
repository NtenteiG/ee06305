package ntentei.final_sms;

import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ToggleButton;

public class Lights extends AppCompatActivity {
    ToggleButton btn;
    ImageView img;
    SmsManager smsManager = SmsManager.getDefault();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); // Full Screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); // Full Screen
        setContentView(R.layout.activity_lights);
        final View light = findViewById(R.id.lights_layout);
        btn = (ToggleButton) findViewById(R.id.lights_btn);
        img = (ImageView) findViewById(R.id.lights_logo);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn.isChecked())
                {
                    img.setImageResource(R.drawable.lights_on);
                    ((TransitionDrawable) img.getDrawable()).startTransition(1200);
                    smsManager.sendTextMessage("6982858536", null, "Open lights", null, null);
                    Snackbar.make(light,"Lights are Turned On",Snackbar.LENGTH_SHORT).show();

                }
                else {
                    img.setImageResource(R.drawable.lights_off);
                    ((TransitionDrawable) img.getDrawable()).startTransition(1200);
                    smsManager.sendTextMessage("6982858536", null, "Close lights", null, null);
                    Snackbar.make(light, "Lights are Turned Off", Snackbar.LENGTH_SHORT).show();
                }
            }
        });
    }
}