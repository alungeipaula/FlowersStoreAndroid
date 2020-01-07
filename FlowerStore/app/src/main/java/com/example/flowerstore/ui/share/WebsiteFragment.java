package com.example.flowerstore.ui.share;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.flowerstore.R;
import com.example.flowerstore.ui.send.OrderFragmentDirections;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

public class WebsiteFragment extends Fragment {

    private final static String URL = "http://www.magnolia.ro/";

    private WebView webSite;
    private TextView test;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_website, container, false);
        webSite = root.findViewById(R.id.web_site_wv);
        WebSettings webSettings = webSite.getSettings();
        webSettings.setAppCacheEnabled(true);
        webSettings.setJavaScriptEnabled(true);
        webSite.loadUrl(URL);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initViews(view);
    }

    private void initViews(View layout) {


    }
}
