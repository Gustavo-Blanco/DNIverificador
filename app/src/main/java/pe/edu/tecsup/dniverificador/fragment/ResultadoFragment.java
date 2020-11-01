package pe.edu.tecsup.dniverificador.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import pe.edu.tecsup.dniverificador.R;

public class ResultadoFragment extends Fragment {

    private boolean n;

    public ResultadoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.n = getArguments().getBoolean("boolean");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_resultado, container, false);
        TextView textView = view.findViewById(R.id.result);
        ImageView imageView = view.findViewById(R.id.imagen);
        if (this.n){
            textView.setText(R.string.correct);
            textView.setTextColor(this.getResources().getColor(R.color.like));
            imageView.setImageResource(R.drawable.ic_like);
        }else{
            textView.setText(R.string.incorrect);
            textView.setTextColor(this.getResources().getColor(R.color.dislike));
            imageView.setImageResource(R.drawable.ic_dislike);
        }
        return view;
    }
}