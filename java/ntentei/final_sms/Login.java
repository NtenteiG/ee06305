package ntentei.final_sms;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText number;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); // Full Screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); // Full Screeen
        setContentView(R.layout.activity_log);
        final EditText username = (EditText) findViewById(R.id.username);
        number = (EditText) findViewById(R.id.phone);
        btn = (Button) findViewById(R.id.log_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText().toString().equals("Nikos") && number.getText().toString().equals("1991"))
                {
                    Toast.makeText(getApplicationContext(), "Login Succesfull!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(view.getContext(), Home.class);
                    view.getContext().startActivity(intent);
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Try Again",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
