package com.example.flowerstore.ui.send;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.flowerstore.R;

public class PaymentFragment extends Fragment implements View.OnClickListener{

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

    }

    @Override
    public void onClick(View v) {
        Fragment fragment = null;
        switch (v.getId()) {
            case R.id.confimation_order_button:
                fragment = new PaymentFragment();
                replaceFragment(fragment);
                break;

        }
    }

    public void replaceFragment(Fragment newFragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_order, newFragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }
}

