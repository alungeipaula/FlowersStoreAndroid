package com.example.flowerstore.ui.send;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.flowerstore.R;
import com.example.flowerstore.provider.SharedPreferenceProvider;
import com.example.flowerstore.ui.FlowerStoreApp;

public class OrderFragment extends Fragment {

    private TextView introOrder;
    private TextView senderTextView;
    private EditText nameSenderET;
    private Spinner payMethodSpinner;
    private EditText additionalMessageET;
    private TextView receiverTextView;
    private EditText receiverNameET;
    private EditText addressReceiverET;
    private Button confirmationOrderButton;


    private SharedPreferenceProvider sharedPreferenceProvider;

    private void initSharedPref() {
        sharedPreferenceProvider = ((FlowerStoreApp) getActivity().getApplication()).getSharedPreferenceProvider();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initSharedPref();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_order, container, false);
        confirmationOrderButton = (Button) root.findViewById(R.id.confimation_order_button);
        payMethodSpinner = (Spinner) root.findViewById(R.id.pay_method_spinner);
        confirmationOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String choicePaymentMethod = payMethodSpinner.getSelectedItem().toString();
                if (choicePaymentMethod.equals("Card Pay")) {
                    Navigation.findNavController(v).navigate(OrderFragmentDirections.actionNavOrderToNavPayment());
                } else {
                    ((FlowerStoreApp)getActivity().getApplication()).getDataSource().clearCart();
                    Toast.makeText(getContext(), "Your command has been registered", Toast.LENGTH_SHORT).show();
                }
            }
        });


        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("this", "onViewCreated");

        introOrder = view.findViewById(R.id.intro_order_tv);
        senderTextView = view.findViewById(R.id.sender_tv);
        nameSenderET = view.findViewById(R.id.name_sender_et);
        additionalMessageET = view.findViewById(R.id.additional_message_et);
        receiverTextView = view.findViewById(R.id.receiver_tv);
        receiverNameET = view.findViewById(R.id.receiver_name_et);
        addressReceiverET = view.findViewById(R.id.address_receiver_et);

        loadSharedPreferencesFavoritePersonName();
        loadSharedPreferencesFavoritePersonAddress();
        loadSharedPreferencesUserName();
    }

    private void loadSharedPreferencesUserName() {
        String username = sharedPreferenceProvider.loadUsername(); // AICI e un Load
        nameSenderET.setText(username);
    }

    private void loadSharedPreferencesFavoritePersonName() {
        String favoritePersonName = sharedPreferenceProvider.loadFavoritePersonName();
        receiverNameET.setText(favoritePersonName);
    }

    private void loadSharedPreferencesFavoritePersonAddress() {
        String favoritePersonAddress = sharedPreferenceProvider.loadFavoritePersonAddress();
        addressReceiverET.setText(favoritePersonAddress);
    }
}