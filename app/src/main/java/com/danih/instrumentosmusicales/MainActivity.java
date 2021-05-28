package com.danih.instrumentosmusicales;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

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
        recycler.setLayoutManager(new LinearLayoutManager(this));

        botonReset = findViewById(R.id.resetInstrumentos);
        botonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetInstrumento();

            }
        });
        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT |
                ItemTouchHelper.DOWN | ItemTouchHelper.UP, ItemTouchHelper.LEFT |
                ItemTouchHelper.RIGHT) {

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
        listaInstrumento.add(new Instrumento("Piano", "El piano es un instrumento de percusión que se compone por" +
                " una caja de resonancia con un teclado integrado para que puedan " +
                "percutir las cuerdas de acero con los martillos " +
                "forrados con fieltro para producir sonidos armónicos.", R.drawable.imagen_piano_edited));

        listaInstrumento.add(new Instrumento("Guitarra", "Es un instrumento musical de cuerda pulsada, compuesto de una caja de resonancia, un mástil sobre el que va adosado el diapasón o trastero —generalmente con un agujero acústico en el centro de la tapa (boca)— y seis cuerdas. ", R.drawable.imagen_guitarra_edited));
        listaInstrumento.add(new Instrumento("Bajo", "\n" +
                " Instrumento musical de la familia de los cordófonos, similar en apariencia y construcción a la guitarra eléctrica, pero con un cuerpo de mayores dimensiones, un mástil de mayor longitud y escala y, normalmente, cuatro cuerdas afinadas según la afinación estándar del contrabajo.", R.drawable.imagen_bajo_edited));
        listaInstrumento.add(new Instrumento("Bateria", "Descripcion Bateria", R.drawable.imagen_bateria_edited));
        listaInstrumento.add(new Instrumento("Saxofón", "Descripcion Saxofon", R.drawable.imagen_saxofon_edited));
        listaInstrumento.add(new Instrumento("Violin", " Descripcion Violin", R.drawable.imagen_violin_edited));
        listaInstrumento.add(new Instrumento("Trompeta", "Descripcion trompeta", R.drawable.imagen_trompeta_edited));
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

}