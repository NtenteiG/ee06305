package ntentei.final_sms;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class Home extends AppCompatActivity implements View.OnClickListener
{
    private CardView tv,air,door,lights,login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); // Full Screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); //Full Screen
        setContentView(R.layout.activity_home);

        // Ορισμός τών CardView για την κάθε συσκευή
        tv = (CardView)findViewById(R.id.tvcard);
        air = (CardView)findViewById(R.id.aircard);
        door = (CardView)findViewById(R.id.doorcard);
        lights = (CardView)findViewById(R.id.lightscard);

        //Δημιουργία των καρτών σαν Button
        tv.setOnClickListener(this);
        air.setOnClickListener(this);
        door.setOnClickListener(this);
        lights.setOnClickListener(this);
    }
  // Συνάρτηση για όταν πατηθεί  ένα συγκεκριμένο κουμπί να ανοίξει η ανάλογη σελίδα (activity)
    @Override
    public void onClick(View view)
    {
        Intent i;
        switch (view.getId())
        {
        case R.id.aircard: i = new Intent(this,Air_Condition.class);
        startActivity(i); break;
        case R.id.tvcard:  i = new Intent(this,Tv.class);
        startActivity(i); break;
        case R.id.lightscard: i = new Intent(this,Lights.class);
        startActivity(i); break;
        case R.id.doorcard: i = new Intent(this,Door.class);
        startActivity(i); break;
        default:break;
        }
    }
}
