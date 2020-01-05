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

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.flowerstore.R;

import org.w3c.dom.Text;

public class OrderFragment extends Fragment implements View.OnClickListener {

    private TextView introOrder;
    private TextView senderTextView;
    private EditText nameSenderET;
    private Spinner payMethodSpinner;
    private EditText additionalMessageET;
    private Text receiverTextView;
    private EditText receiverNameET;
    private EditText addressReceiverET;
    private Button confirmationOrderButton;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_order, container, false);
        confirmationOrderButton = (Button)root.findViewById(R.id.confimation_order_button);
        confirmationOrderButton.setOnClickListener(this);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("this", "onViewCreated");

        introOrder = view.findViewById(R.id.intro_order_tv);
        senderTextView = view.findViewById(R.id.sender_tv);
        nameSenderET = view.findViewById(R.id.name_sender_et);
        payMethodSpinner = view.findViewById(R.id.pay_method_spinner);
        additionalMessageET = view.findViewById(R.id.additional_message_et);
        receiverTextView = view.findViewById(R.id.receiver_tv);
        receiverNameET = view.findViewById(R.id.receiver_name_et);
        addressReceiverET = view.findViewById(R.id.address_receiver_et);


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