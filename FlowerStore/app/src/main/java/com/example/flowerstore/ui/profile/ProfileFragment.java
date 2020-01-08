package com.example.flowerstore.ui.profile;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.flowerstore.R;
import com.example.flowerstore.provider.SharedPreferenceProvider;
import com.example.flowerstore.ui.FlowerStoreApp;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ProfileFragment extends Fragment {

    public static final int GET_FROM_GALLERY = 3;

    private ImageView profilePictureIm;
    private Button fragProfileSaveBt;
    private TextView fragProfileUsernameLabelTv;
    private EditText fragProfileusernameEt;
    private TextView favoritePersonLabelTv;
    private EditText favoriteNameEt;
    private EditText favoriteAddressEt;
    private Button uploadPictureB;


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

        loadSharedPreferencesUserName();
        loadSharedPreferencesFavoritePersonName();
        loadSharedPreferencesFavoritePersonAddress();
        loadSharedPrefPicture();

        setEvents();
    }

    private void findViews(View v) {
        profilePictureIm = v.findViewById(R.id.profile_picture);
        fragProfileUsernameLabelTv = v.findViewById(R.id.frag_profile_username_label);
        fragProfileusernameEt = v.findViewById(R.id.frag_profile_username_et);
        favoritePersonLabelTv = v.findViewById(R.id.favorite_person_label_tv);
        favoriteNameEt = v.findViewById(R.id.favorite_name_tv);
        favoriteAddressEt = v.findViewById(R.id.favorite_address_tv);
        fragProfileSaveBt = v.findViewById(R.id.frag_profile_save_bt);
        fragProfileSaveBt = v.findViewById(R.id.frag_profile_save_bt);
        uploadPictureB = v.findViewById(R.id.upload_picture_b);
    } // si dupaia

    private void setEvents() {
        uploadPictureB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI), GET_FROM_GALLERY);
            }
        });
        fragProfileSaveBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveSharedPreferencesUsername();
                saveSharedPreferencesFavoritePersonName();
                saveSharedPreferencesFavoritePersonAddress();
            }
        });
    }

    //username
    private void loadSharedPreferencesUserName() {
        String username = sharedPreferenceProvider.loadUsername(); // AICI e un Load
        fragProfileusernameEt.setText(username);
    }

    private void saveSharedPreferencesUsername() {
        String username = fragProfileusernameEt.getText().toString();
        sharedPreferenceProvider.saveUsername(username); // AICI e un Save
    }

    //favorite person name
    private void loadSharedPreferencesFavoritePersonName() {
        String favoritePersonName = sharedPreferenceProvider.loadFavoritePersonName();
        favoriteNameEt.setText(favoritePersonName);
    }

    private void saveSharedPreferencesFavoritePersonName() {
        String favoritePersonName = favoriteNameEt.getText().toString();
        sharedPreferenceProvider.saveFavoritePersonName(favoritePersonName); // AICI e un Save
    }

    //favorite address name
    private void loadSharedPreferencesFavoritePersonAddress() {
        String favoritePersonAddress = sharedPreferenceProvider.loadFavoritePersonAddress();
        favoriteAddressEt.setText(favoritePersonAddress);
    }

    private void saveSharedPreferencesFavoritePersonAddress() {
        String favoritePersonAddress = favoriteAddressEt.getText().toString();
        sharedPreferenceProvider.saveFavoritePersonAddress(favoritePersonAddress); // AICI e un Save
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        //Detects request codes
        if (requestCode == GET_FROM_GALLERY && resultCode == Activity.RESULT_OK) {
            Uri selectedImage = data.getData();
            Bitmap bitmap = null;
            try {
                bitmap = MediaStore.Images.Media.getBitmap(this.getActivity().getContentResolver(), selectedImage);
                profilePictureIm.setImageBitmap(bitmap);
                saveSharedPrefPicture(bitmap);
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    private void saveSharedPrefPicture(Bitmap bitmap) {
        sharedPreferenceProvider.saveSharedPrefPicture(bitmap);
    }

    private void loadSharedPrefPicture() {
        Bitmap bitmap = sharedPreferenceProvider.loadSharedPrefPicture();
        if (bitmap != null)
            profilePictureIm.setImageBitmap(bitmap);
        else
            Toast.makeText(requireContext(), "Picture saved is null. Save another!", Toast.LENGTH_SHORT).show();
    }


    //Tot ce scrii in SharedPrefProvider o sa fie vizibil oriunde poti obtine contextu aplicatiei.
}
