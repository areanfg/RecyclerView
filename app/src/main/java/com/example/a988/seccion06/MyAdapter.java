package com.example.a988.seccion06;

import android.os.TestLooperManager;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    List<Contacto> contactos;
    private OnItemClickListener listener;


    public MyAdapter(List<Contacto> contactos, OnItemClickListener listener){
        this.contactos = contactos;
        this.listener = listener;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {
        private ImageView imageView;
        private TextView textViewNombre;
        private TextView textViewTelefono;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.imageContact);
            textViewNombre = (TextView) itemView.findViewById(R.id.textViewNombre);
            textViewTelefono = (TextView) itemView.findViewById(R.id.textViewTelefono);
            itemView.setOnCreateContextMenuListener(this);

        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        }
        public void bind(final Contacto contacto, final OnItemClickListener listener) {

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onItemClick(contacto);
                }
            });
        }

    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View v = layoutInflater.inflate(R.layout.recycle_item, viewGroup,false);

        MyViewHolder viewHolder = new MyViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.textViewNombre.setText(contactos.get(i).getNombre());
        myViewHolder.textViewTelefono.setText(String.valueOf(contactos.get(i).getTelefono()));
        myViewHolder.imageView.setImageResource(contactos.get(i).getFoto());
        myViewHolder.bind(contactos.get(i), listener);
    }

    @Override
    public int getItemCount() {
        return contactos.size();
    }

    public interface OnItemClickListener {
        void onItemClick(Contacto contacto);
    }



}