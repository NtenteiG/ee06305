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

public class Door extends AppCompatActivity {
    ToggleButton lock_btn;
    ImageView img;
    SmsManager smsManager = SmsManager.getDefault();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); // Full Screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); //Full Screen
        setContentView(R.layout.activity_door);
        final View porta = findViewById(R.id.door_layout);
        lock_btn = (ToggleButton) findViewById(R.id.lock);
        img = (ImageView) findViewById(R.id.door_logo);
        lock_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (lock_btn.isChecked())
                {
                    img.setImageResource(R.drawable.door_on);
                    ((TransitionDrawable) img.getDrawable()).startTransition(1200);
                    smsManager.sendTextMessage("6986909533", null, "Open door", null, null);
                    Snackbar.make(porta,"Door is Opened",Snackbar.LENGTH_SHORT).show();
                }
                else
                {
                    img.setImageResource(R.drawable.door_off);
                    ((TransitionDrawable) img.getDrawable()).startTransition(1200);
                    smsManager.sendTextMessage("6986909533", null, "Close door", null, null);
                    Snackbar.make(porta,"Door is closed",Snackbar.LENGTH_SHORT).show();
                }
            }
        });
    }
}
