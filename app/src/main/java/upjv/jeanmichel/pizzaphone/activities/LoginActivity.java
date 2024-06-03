package upjv.jeanmichel.pizzaphone.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

import upjv.jeanmichel.pizzaphone.MainActivity;
import upjv.jeanmichel.pizzaphone.R;

public class LoginActivity extends AppCompatActivity {
    EditText editText;
    RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void mainActivity(View view) {
        editText = findViewById(R.id.user_name);
        String username = editText.getText().toString();
        String url = "https://daviddurand.info/D228/pizza/login/"+username;
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                response -> Toast.makeText(LoginActivity.this, "Success", Toast.LENGTH_LONG).show(),
                error -> Toast.makeText(LoginActivity.this, "Error", Toast.LENGTH_LONG).show()){
              /*  @Override
                protected Map<String, String> getParams() throws AuthFailureError{
                    Map<String, String> params = new HashMap<>();
                    params.put("user", username);
                    params.put("","");
                    return params;
                }*/
        };
        requestQueue = Volley.newRequestQueue(LoginActivity.this);
        requestQueue.add(stringRequest);
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
    }
}