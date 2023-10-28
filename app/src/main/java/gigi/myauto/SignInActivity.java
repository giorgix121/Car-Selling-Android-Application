package gigi.myauto;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignInActivity extends AppCompatActivity {

    private EditText name;
    private EditText password;
    private Button button;
    private DBHandler dbHandler;
    private TextView signUpHere;
    private CheckBox rememberMe;
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;
    private TextInputLayout usernameLay, passwordLay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        init();

        dbHandler = new DBHandler(this);
        sp = PreferenceManager.getDefaultSharedPreferences(this);
        editor = sp.edit();

        if (sp.getBoolean("user_is_logged_in", false)) {
            Intent i = new Intent(SignInActivity.this, MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(i);
        }



        rememberMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        signUpHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignInActivity.this, SignUpActivity.class));
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ragaca();
            }

        });

    }
    private void init() {
        name = (EditText) findViewById(R.id.username_tv);
        password = (EditText) findViewById(R.id.password_tv);
        button = (Button) findViewById(R.id.button3);
        signUpHere = (TextView) findViewById(R.id.sign_up_here);
        rememberMe = (CheckBox) findViewById(R.id.remember_me);

        usernameLay = (TextInputLayout) findViewById(R.id.username_layout);
        passwordLay = (TextInputLayout) findViewById(R.id.password_layout);
    }


    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    public void ragaca () {
        String Name = name.getText().toString().trim();
        String Password = password.getText().toString().trim();

        if (rememberMe.isChecked()) {
            editor.putBoolean("user_is_logged_in", true);
            editor.apply();
        }


        if (dbHandler.login(Name, Password)) {
            Intent i = new Intent(SignInActivity.this, MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(i);
        } else {
            Toast.makeText(SignInActivity.this, "Incorrect username or password", Toast.LENGTH_SHORT).show();
        }
    }
}
