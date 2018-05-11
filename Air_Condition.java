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

public class Air_Condition extends AppCompatActivity {
    ToggleButton btn;  //Ορισμός του btn ως Button
    ImageView img; // Ορισμός του img ως ImageView
    SmsManager smsManager = SmsManager.getDefault();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); // Full Screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); // Full Screen
        setContentView(R.layout.activity_air__condition);
        btn = (ToggleButton) findViewById(R.id.air_btn); //Αντιστοίχηση της id air_btn στο μπουτόν btn
        img = (ImageView) findViewById(R.id.air_logo);
        final View airco = findViewById(R.id.air_layout);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (btn.isChecked())
                {
                    img.setImageResource(R.drawable.aircondition_on);
                    ((TransitionDrawable) img.getDrawable()).startTransition(1200);
                    smsManager.sendTextMessage("6986909533", null, "Open ac", null, null);
                    Snackbar.make(airco,"Air Condition is Turned On",Snackbar.LENGTH_SHORT).show();
                }
                else
                {
                    img.setImageResource(R.drawable.aircondition_off);
                    ((TransitionDrawable) img.getDrawable()).startTransition(1200);
                    smsManager.sendTextMessage("6986909533", null, "Close ac", null, null);
                    Snackbar.make(airco,"Air Condition is  Turned Off",Snackbar.LENGTH_SHORT).show();
                }
            }
        });
    }
}