/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ester
 */
public class Plato {
    private String nombre;
    private String comentario;
    private int cantidad;
    private double precio;
    
    
    public Plato(String nombre,double precio) {
    this.nombre = nombre;
    this.comentario = "";
    this.cantidad = 0;
    this.precio=precio;
}


    public Plato() {
    }

    public Plato(String nombre, String comentario, int cantidad) {
        this.nombre = nombre;
        this.comentario = comentario;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public double getPrecio() { 
        return precio; 
    }
    
    public void setPrecio(double precio) { 
        this.precio = precio; 
    }
    
    @Override
    public String toString() {
        if (cantidad == 0) return ""; // pa no mostrar platos no pedidos

        String comentarioString = (comentario == null || comentario.isEmpty()) ? "" : " (" + comentario + ")"; //si no hay comentario nada, si lo hay que se ponga en el ticket
        double total = precio * cantidad;

        return String.format("%-20s x%-2d  %.2f€/u  =  %.2f€%s", nombre, cantidad, precio, total, comentarioString); //ticket formateado.
    }

}
