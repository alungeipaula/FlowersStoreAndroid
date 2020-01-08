package com.example.flowerstore.ui.send;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;

import com.example.flowerstore.R;
import com.example.flowerstore.ui.FlowerStoreApp;

public class PaymentFragment extends Fragment {

    TextView introCard;
    EditText cardNumber;
    EditText holderName;
    EditText expiryDate;
    EditText securityCode;
    Button confirmationPaymentButton;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_payment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        introCard = view.findViewById(R.id.intro_card);
        cardNumber = view.findViewById(R.id.card_number);
        holderName = view.findViewById(R.id.holder_name);
        expiryDate = view.findViewById(R.id.expiry_date);
        securityCode = view.findViewById(R.id.security_code);
        confirmationPaymentButton = view.findViewById(R.id.confirmation_payment_button);
        confirmationPaymentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(PaymentFragmentDirections.actionNavPaymentToNavHome());
                ((FlowerStoreApp)getActivity().getApplication()).getDataSource().clearCart();
                Toast.makeText(getContext(), "Your command has been registered", Toast.LENGTH_SHORT).show();
            }
        });
    }


}

