package com.example.flowerstore.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.flowerstore.R;
import com.example.flowerstore.provider.SharedPreferenceProvider;
import com.example.flowerstore.ui.FlowerStoreApp;

public class ProfileFragment extends Fragment {

    private EditText usernameEditText;
    private Button saveButton;

    //unde iti trebuie SharedPref (Fragment) copiezi asta :
    private SharedPreferenceProvider sharedPreferenceProvider;

    private void initSharedPref() {
        sharedPreferenceProvider = ((FlowerStoreApp) getActivity().getApplication()).getSharedPreferenceProvider();
    }

    //pana aici !!!NU UITA . Da call pe onCreate initSharedPref(); dupa super  (vezi jos)

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initSharedPref();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findViews(view);
        String username = usernameEditText.getText().toString();
        sharedPreferenceProvider.saveUsername(username);
        loadSharedPreferences();
        setEvents();

    }

    private void findViews(View v) {
        usernameEditText = v.findViewById(R.id.frag_profile_username_et);
        saveButton = v.findViewById(R.id.frag_profile_save_bt);
    } // si dupaia

    private void setEvents() {
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveSharedPreferences();
            }
        });
    }

    private void loadSharedPreferences() {
        String username = sharedPreferenceProvider.loadUsername(); // AICI e un Load
        usernameEditText.setText(username);
    }

    private void saveSharedPreferences() {
        String username = usernameEditText.getText().toString();
        sharedPreferenceProvider.saveUsername(username); // AICI e un Save
    }

    //Tot ce scrii in SharedPrefProvider o sa fie vizibil oriunde poti obtine contextu aplicatiei.
}
