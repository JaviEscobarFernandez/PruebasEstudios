package com.example.clientes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ClienteAdapter(private val clientes: List<Cliente>): RecyclerView.Adapter<ClienteAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtNombre: TextView = view.findViewById(R.id.txtNombre)
        val txtDni: TextView = view.findViewById(R.id.txtDni)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cliente, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cliente = clientes[position]
        holder.txtNombre.text = cliente.nombre
        holder.txtDni.text = cliente.dni
    }

    override fun getItemCount(): Int = clientes.size
}