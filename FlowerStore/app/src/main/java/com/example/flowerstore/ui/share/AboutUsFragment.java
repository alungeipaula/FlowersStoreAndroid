package com.example.flowerstore.ui.share;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import com.example.flowerstore.R;
import com.example.flowerstore.ui.send.OrderFragmentDirections;

import org.w3c.dom.Text;

public class AboutUsFragment extends Fragment implements View.OnClickListener {

    private TextView businessHoursTv;
    private TextView businessHoursLabelTv;
    private TextView addressLabelTv;
    private TextView addressValueTv;
    private TextView contactLabelTv;
    private TextView telNumberTv;
    private TextView emailAddressTv;
    private TextView webSite;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_about_us, container, false);
        telNumberTv = root.findViewById(R.id.tel_number_tv);
        telNumberTv.setOnClickListener(this);
        webSite = root.findViewById(R.id.web_site_tv);
        webSite.setOnClickListener(this);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    private void initViews(View layout) {
        businessHoursTv = layout.findViewById(R.id.business_hours_tv);
        businessHoursLabelTv = layout.findViewById(R.id.business_hours_label_tv);
        addressLabelTv = layout.findViewById(R.id.address_label_tv);
        addressValueTv = layout.findViewById(R.id.address_value_tv);
        contactLabelTv = layout.findViewById(R.id.contact_label_tv);
        emailAddressTv = layout.findViewById(R.id.email_adress_tv);


    }

    private void call(String cellNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setData(Uri.parse("tel:"+cellNumber));
        getActivity().startActivity(intent);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tel_number_tv:
                call((String) telNumberTv.getText());
                break;
            case R.id.web_site_tv:
                Navigation.findNavController(v).navigate(AboutUsFragmentDirections.actionNavAboutUsToNavWeb());
        }
    }
}