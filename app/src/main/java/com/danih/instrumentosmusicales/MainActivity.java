package com.danih.instrumentosmusicales;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Instrumento> listaInstrumento;
    private RecyclerView recycler;
    private InstrumentosAdapter adapter;
    private FloatingActionButton botonReset;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        listaInstrumento = new ArrayList<Instrumento>();
        resetInstrumento();

        recycler = findViewById(R.id.recyclerInstrumento);
        adapter = new InstrumentosAdapter(listaInstrumento, this);
        recycler.setAdapter(adapter);
       // recycler.setLayoutManager(new LinearLayoutManager(this));

        int gridColumnCount = getResources().getInteger(R.integer.grid_column_count);
        recycler.setLayoutManager(new GridLayoutManager(this, gridColumnCount));
        int swipeDirs;
        if(gridColumnCount > 1){
            swipeDirs = 0;
        } else {
            swipeDirs = ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
        }


        botonReset = findViewById(R.id.resetInstrumentos);
        botonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetInstrumento();

            }
        });
        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT |
                ItemTouchHelper.DOWN | ItemTouchHelper.UP, swipeDirs) {

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                int from = viewHolder.getAdapterPosition();
                int to = target.getAdapterPosition();
                Collections.swap(listaInstrumento, from, to);
                adapter.notifyItemMoved(from, to);
                return true;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder,
                                 int direction) {
                listaInstrumento.remove(viewHolder.getAdapterPosition());
                adapter.notifyItemRemoved(viewHolder.getAdapterPosition());

            }
        });
        helper.attachToRecyclerView(recycler);


    }

    public void resetInstrumento() {
        listaInstrumento.clear();
        listaInstrumento.add(new Instrumento("Piano", "El piano es un instrumento de percusi??n que se compone por" +
                " una caja de resonancia con un teclado integrado para que puedan " +
                "percutir las cuerdas de acero con los martillos " +
                "forrados con fieltro para producir sonidos arm??nicos.", R.drawable.imagen_piano_edited));

        listaInstrumento.add(new Instrumento("Guitarra", "Es un instrumento musical de cuerda pulsada, compuesto de una caja de resonancia, un m??stil sobre el que va adosado el diapas??n o trastero ???generalmente con un agujero ac??stico en el centro de la tapa (boca)??? y seis cuerdas. ", R.drawable.imagen_guitarra_edited));
        listaInstrumento.add(new Instrumento("Bajo", "\n" +
                " Instrumento musical de la familia de los cord??fonos, similar en apariencia y construcci??n a la guitarra el??ctrica, pero con un cuerpo de mayores dimensiones, un m??stil de mayor longitud y escala y, normalmente, cuatro cuerdas afinadas seg??n la afinaci??n est??ndar del contrabajo.", R.drawable.imagen_bajo_edited));
        listaInstrumento.add(new Instrumento("Bateria", "Descripcion Bateria", R.drawable.imagen_bateria_edited));
        listaInstrumento.add(new Instrumento("Saxof??n", "Descripcion Saxofon", R.drawable.imagen_saxofon_edited));
        listaInstrumento.add(new Instrumento("Violin", " Descripcion Violin", R.drawable.imagen_violin_edited));
        listaInstrumento.add(new Instrumento("Trompeta", "Descripcion trompeta", R.drawable.imagen_trompeta_edited));
        if (adapter != null) {
            adapter.notifyDataSetChanged();
            Toast.makeText(this,"Restableciendo datos", Toast.LENGTH_SHORT).show();
        }
    }

}