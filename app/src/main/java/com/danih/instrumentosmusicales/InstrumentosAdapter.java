package com.danih.instrumentosmusicales;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class InstrumentosAdapter extends RecyclerView.Adapter<InstrumentosAdapter.InstrumentoHolder>{
private ArrayList<Instrumento> listaInstrumentos;
private Context context;
private LayoutInflater inflater;

    public InstrumentosAdapter(ArrayList<Instrumento> listaInstrumentos, Context context) {
        this.listaInstrumentos = listaInstrumentos;
        this.context = context;
        this.inflater=LayoutInflater.from(this.context);
    }

    @Override
    public InstrumentosAdapter.InstrumentoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = inflater.inflate(R.layout.instrumentos_item, parent, false);
        return new InstrumentoHolder(item);
    }

    @Override
    public void onBindViewHolder( InstrumentosAdapter.InstrumentoHolder holder, int position) {
        String nombre=listaInstrumentos.get(position).getNombre();
        holder.textView.setText(nombre);
        int imagen=listaInstrumentos.get(position).getImagen();
        holder.imagen.setImageResource(imagen);

    }

    @Override
    public int getItemCount() {
        return listaInstrumentos.size();
    }
    class InstrumentoHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
ImageView imagen;
TextView textView;

        public InstrumentoHolder( View itemView) {
            super(itemView);
            imagen=itemView.findViewById(R.id.imgViewInstrumento);
            textView=itemView.findViewById(R.id.textNombreInstrumento);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int posicion = getLayoutPosition();
            Intent intent=new Intent(context, DescripcionActivity.class);
            Instrumento ins = listaInstrumentos.get(posicion);
            intent.putExtra("item", ins);
            context.startActivity(intent);

        }
    }
}
