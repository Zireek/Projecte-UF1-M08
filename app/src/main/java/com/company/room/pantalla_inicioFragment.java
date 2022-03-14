package com.company.room;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.company.room.databinding.FragmentMostrarElementoBinding;
import com.company.room.databinding.FragmentNuevoElementoBinding;
import com.company.room.databinding.FragmentPantallaInicioBinding;


public class pantalla_inicioFragment extends Fragment {

    private FragmentPantallaInicioBinding binding;
    NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return (binding = FragmentPantallaInicioBinding.inflate(inflater, container, false)).getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ElementosViewModel elementosViewModel = new ViewModelProvider(requireActivity()).get(ElementosViewModel.class);
        navController = Navigation.findNavController(view);

        binding.buttoncircuitos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_pantalla_inicioFragment_to_recyclerElementosFragment);
            }
        });
        binding.buttonescuderias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_pantalla_inicioFragment_to_escuderias_fragment);
            }
        });
        binding.buttonpilotos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_pantalla_inicioFragment_to_pilotos_fragment);
            }
        });
    }

}