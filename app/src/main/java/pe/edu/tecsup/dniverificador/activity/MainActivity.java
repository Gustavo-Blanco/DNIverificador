package pe.edu.tecsup.dniverificador.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;

import com.google.android.material.button.MaterialButton;

import pe.edu.tecsup.dniverificador.R;
import pe.edu.tecsup.dniverificador.fragment.ResultadoFragment;
import pe.edu.tecsup.dniverificador.fragment.ValidaFragment;

public class MainActivity extends AppCompatActivity {

    private FrameLayout fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.fragment = findViewById(R.id.fragment);

        ValidaFragment validaFragment = new ValidaFragment();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.fragment, validaFragment);
        fragmentTransaction.commit();

    }
}