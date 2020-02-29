package c.sakshi.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static String usernameKey = "username";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPreferences = getSharedPreferences("c.sakshi.lab5", Context.MODE_PRIVATE);

        if (!sharedPreferences.getString(usernameKey, "").equals("")) {
            Login();
        } else {
            setContentView(R.layout.activity_main);
        }
    }

    public void onButtonClick(View view) {
        EditText myTextField = (EditText) findViewById(R.id.username);
        String username = myTextField.getText().toString();
        if (username.isEmpty()) {
            myTextField.setError("Please enter a username");
        } else {
            SharedPreferences sharedPreferences = getSharedPreferences("c.sakshi.lab5", Context.MODE_PRIVATE);
            sharedPreferences.edit().putString("username", username).apply();
            Login();
        }
    }

    public void Login() {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}
