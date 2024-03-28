package com.example.fragmentsstudydynamic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.example.fragmentsstudydynamic.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    FragmentTransaction fTrans;
    Fragment1 frag1;
    Fragment2 frag2;
    //numeric identifier for fragment's container
    private static final int CONTENT_VIEW_ID = 10101010;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        binding.fragmentContainer.setId(CONTENT_VIEW_ID);
        //creating 2 fragments
        frag1 = new Fragment1();
        frag2 = new Fragment2();

        //creating 3 elements (RadioButton) and the switch (SwitchCompat)
        binding.Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (savedInstanceState == null){
                    //getting the fragment manager (getSupportFragmentManager), primary object
                    //for working with fragments
                    fTrans = getSupportFragmentManager().beginTransaction(); //begins Transaction
                    fTrans.add(CONTENT_VIEW_ID,frag1); //doing the operation
                    if (binding.swStack.isChecked()){
                        fTrans.addToBackStack(null);
                    }
                    fTrans.commit(); //committing the transaction
                }
            }
        });

        binding.Remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fTrans = getSupportFragmentManager().beginTransaction();
                fTrans.remove(frag1);
                if (binding.swStack.isChecked()){
                    fTrans.addToBackStack(null);
                }
                fTrans.commit();
            }
        });

        binding.Replace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fTrans = getSupportFragmentManager().beginTransaction();
                fTrans.replace(CONTENT_VIEW_ID,frag2);
                if (binding.swStack.isChecked()){
                    fTrans.addToBackStack(null);
                }
                fTrans.commit();
            }
        });
    }
}