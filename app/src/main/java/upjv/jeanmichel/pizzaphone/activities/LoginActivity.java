package upjv.jeanmichel.pizzaphone.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import upjv.jeanmichel.pizzaphone.MainActivity;
import upjv.jeanmichel.pizzaphone.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void mainActivity(View view) {

        startActivity(new Intent(LoginActivity.this, MainActivity.class));
    }
}