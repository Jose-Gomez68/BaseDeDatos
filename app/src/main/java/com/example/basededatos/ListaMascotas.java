package com.example.basededatos;

public class ListaMascotas {

    public ListaMascotas (){

    }


    public ListaMascotas(String nombre, int imagenn, int contadorLike, String descrip) {
        this.nombre = nombre;
        this.imagenn = imagenn;
        this.contadorLike = contadorLike;
        this.descrip = descrip;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImagenn() {
        return imagenn;
    }

    public void setImagenn(int imagenn) {
        this.imagenn = imagenn;
    }

    public int getContadorLike() {
        return contadorLike;
    }

    public void setContadorLike(int contadorLike) {
        this.contadorLike = contadorLike;
    }

    private String nombre;
    private int imagenn;
    private int contadorLike;
    private String descrip;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }
}
