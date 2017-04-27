package app.calcounterapplication.com.calcounter;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import data.DatabaseHandler;

public class LoginActivity extends AppCompatActivity {
    private EditText email, password;
    final String TAG = "Debug";
    private Button submitButton;
    private DatabaseHandler dba;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth.signInWithEmailAndPassword(email.getText().toString(), password.getText().toString())
        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
        @Override
        public void onComplete(@NonNull Task<AuthResult> task) {
        Log.d(TAG, "signInWithEmail:onComplete:" + task.isSuccessful());

        // If sign in fails, display a message to the user. If sign in succeeds
        // the auth state listener will be notified and logic to handle the
        // signed in user can be handled in the listener.
        if (!task.isSuccessful()) {
        Log.w(TAG, "signInWithEmail:failed", task.getException());
        Toast.makeText(LoginActivity.this, "Authentication failed",
        Toast.LENGTH_SHORT).show();
        }

        // ...
        }
        });
    }
}
