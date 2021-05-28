package com.danih.instrumentosmusicales;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.danih.instrumentosmusicales.databinding.ActivityDescripcionBinding;

public class DescripcionActivity extends AppCompatActivity {
    TextView txtDescripcion;
    ImageView imagenIns;

    private ActivityDescripcionBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = ActivityDescripcionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        txtDescripcion=findViewById(R.id.txtDescripcion);
        imagenIns=findViewById(R.id.imagenIns);

        Intent intent=getIntent();
        Instrumento instrumento = (Instrumento) intent.getSerializableExtra("item");

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        imagenIns.setImageResource(instrumento.getImagen());
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;

        toolBarLayout.setTitle(instrumento.getNombre());
        txtDescripcion.setText(instrumento.getDescripcion());
        imagenIns.setImageResource(instrumento.getImagen());

    }
}