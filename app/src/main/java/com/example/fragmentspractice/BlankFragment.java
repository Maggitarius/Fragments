package com.example.fragmentspractice;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BlankFragment extends Fragment {

    private TextView textView;

    public BlankFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);

        textView = view.findViewById(R.id.textView);

        textView.setOnClickListener(v -> showPopupMenu(v));

        return view;
    }

    private void showPopupMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(requireContext(), view);
        popupMenu.getMenu().add(0, 1, 0, "Сменить текст 1");
        popupMenu.getMenu().add(0, 2, 1, "Сменить текст 2");

        popupMenu.setOnMenuItemClickListener(item -> {
            switch (item.getItemId()) {
                case 1:
                    textView.setText("Вы выбрали текст 1");
                    Toast.makeText(getActivity(), "Текст изменён на 1", Toast.LENGTH_SHORT).show();
                    return true;
                case 2:
                    textView.setText("Вы выбрали текст 2");
                    Toast.makeText(getActivity(), "Текст изменён на 2", Toast.LENGTH_SHORT).show();
                    return true;
                default:
                    return false;
            }
        });

        popupMenu.show();
    }
}
