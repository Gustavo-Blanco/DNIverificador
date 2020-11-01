package pe.edu.tecsup.dniverificador.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import pe.edu.tecsup.dniverificador.R;

public class ValidaFragment extends Fragment {
    private TextInputEditText dni;
    private TextInputEditText code;
    private MaterialButton button;

    public ValidaFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_valida, container, false);

        this.button = view.findViewById(R.id.validate);
        this.dni = view.findViewById(R.id.DNI_input_text);
        this.code = view.findViewById(R.id.code_input);

        this.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String StringDni = dni.getText().toString();
                String StringCode = code.getText().toString();
                if(StringDni.length() == 8 && StringCode.length() == 1){
                    int[] serie = {3, 2, 7, 6, 5, 4, 3, 2 };
                    int acum = 0;
                    int resta =0;
                    String[] numbers = {"6", "7", "8", "9", "0", "1", "1", "2", "3", "4", "5"};
                    String[] letters = {"K", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};

                    for (int i = 0; i<8;i++){
                        acum += Integer.parseInt(String.valueOf(StringDni.charAt(i)))*serie[i];
                    }
                    int resto = acum%11;
                    if (resto != 0) {
                        resta = 11 - resto;
                    }

                    ResultadoFragment resultadoFragment = new ResultadoFragment();
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("boolean",false);

                    if(StringCode.equals(numbers[resta]) || StringCode.equals(letters[resta])){
                        bundle.putBoolean("boolean",true);
                    }

                    resultadoFragment.setArguments(bundle);
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment, resultadoFragment)
                            .addToBackStack(null)
                            .commit();

                }else if(StringDni.length() > 8 || StringDni.length()<=0){
                    Toast.makeText(getContext(),"El dni debe tener 8 dígitos",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getContext(),"El código debe tener 1 dígito",Toast.LENGTH_LONG).show();
                }
            }
        });
        return view;
    }
}