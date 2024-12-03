package com.example.fragmentspractice;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class BlankFragment2 extends Fragment {

    private int counter = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank2, container, false);
        Button button = view.findViewById(R.id.popup_button);

        button.setOnClickListener(v -> {
            PopupMenu popupMenu = new PopupMenu(getContext(), v);
            popupMenu.getMenu().add("Увеличить счетчик");
            popupMenu.setOnMenuItemClickListener(item -> {
                counter++;
                Toast.makeText(getContext(), "Счетчик: " + counter, Toast.LENGTH_SHORT).show();
                return true;
            });
            popupMenu.show();
        });

        return view;
    }

}