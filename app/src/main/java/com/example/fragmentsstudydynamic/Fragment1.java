package com.example.fragmentsstudydynamic;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragmentsstudydynamic.databinding.Fragment1Binding;


public class Fragment1 extends Fragment {
    private Fragment1Binding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = Fragment1Binding.inflate(inflater,container,false);
        return binding.getRoot();
    }
}