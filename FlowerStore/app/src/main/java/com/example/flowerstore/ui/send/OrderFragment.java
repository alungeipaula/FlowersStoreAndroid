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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.flowerstore.R;

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

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_order, container, false);
        confirmationOrderButton = (Button) root.findViewById(R.id.confimation_order_button);
        confirmationOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(OrderFragmentDirections.actionNavOrderToNavPayment());
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
        payMethodSpinner = view.findViewById(R.id.pay_method_spinner);
        additionalMessageET = view.findViewById(R.id.additional_message_et);
        receiverTextView = view.findViewById(R.id.receiver_tv);
        receiverNameET = view.findViewById(R.id.receiver_name_et);
        addressReceiverET = view.findViewById(R.id.address_receiver_et);


    }


}