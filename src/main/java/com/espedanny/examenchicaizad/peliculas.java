/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.espedanny.examenchicaizad;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class peliculas {

    public peliculas(int Id, String Nombre, String Director, int Año, int Duracion, String Pais, String Genero) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.Director = Director;
        this.Año = Año;
        this.Duracion = Duracion;
        this.Pais = Pais;
        this.Genero = Genero;
    }  
    public peliculas(){
    
    }
    int Id;
    String Nombre;
    String Director;
    int Año;
    int Duracion;
    String Pais;
    String Genero;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String Director) {
        this.Director = Director;
    }

    public int getAño() {
        return Año;
    }

    public void setAño(int Año) {
        this.Año = Año;
    }

    public int getDuracion() {
        return Duracion;
    }

    public void setDuracion(int Duracion) {
        this.Duracion = Duracion;
    }

    public String getPais() {
        return Pais;
    }

    public void setPais(String Pais) {
        this.Pais = Pais;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }
    
    
    
     public void GuardarPeliculas(){
        Connection conexiondb = ConexionDB.getConnection();
        
        //Ejecutar operaciones en la BD
        //Crear la sentencia SQL
        String sentenciaSql = "INSERT INTO peliculas (Id,Nombre,Director,Año,Duracion,Pais,Genero) VALUES (null,?,?,?,?,?,?)";
        try {
            //Configurar los paramewtros de la sentencia SQL
            PreparedStatement parametro = conexiondb.prepareStatement(sentenciaSql);
            parametro.setString(1, this.getNombre());
            parametro.setString(2, this.getDirector());
            parametro.setInt(3, this.getAño());
            parametro.setInt(4, this.getDuracion());
            parametro.setString(5, this.getPais());
            parametro.setString(6, this.getGenero());

            //Ejecutar la sentecia SQL
            parametro.execute();
            conexiondb.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
     
    public void ModificarPeliculas(){
        Connection conexiondb = ConexionDB.getConnection();
        
        //Ejecutar operaciones en la BD
        //Crear la sentencia SQL
        String sentenciaSql = "UPDATE peliculas SET Nombre=?,Director=?,Año=?,Duracion=?,Pais=?,Genero=? WHERE Id=?";
        try {
            //Configurar los paramewtros de la sentencia SQL
            PreparedStatement parametro = conexiondb.prepareStatement(sentenciaSql);
            parametro.setString(1, this.getNombre());
            parametro.setString(2, this.getDirector());
            parametro.setInt(3, this.getAño());
            parametro.setInt(4, this.getDuracion());
            parametro.setString(5, this.getPais());
            parametro.setString(6, this.getGenero());
            parametro.setInt(7, this.getId());


            //Ejecutar la sentecia SQL
            parametro.execute();
            conexiondb.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
     public ArrayList<peliculas> ObtenerPeliculas(){
        Connection conexiondb = ConexionDB.getConnection();
        ResultSet rsPeliculas;
        
        var camisas = new ArrayList<peliculas>();
        //Ejecutar operaciones en la BD
        //Crear la sentencia SQL
        String sentenciaSql = "SELECT * FROM peliculas";
        try {
            //Configurar los paramewtros de la sentencia SQL
            PreparedStatement parametro = conexiondb.prepareStatement(sentenciaSql);
            
            //Ejecutar la sentecia SQL
             rsPeliculas=parametro.executeQuery();           
            
            while(rsPeliculas.next()){              
                    camisas.add(new peliculas(rsPeliculas.getInt("Id"),rsPeliculas.getString("Nombre"),rsPeliculas.getString("Director"),rsPeliculas.getInt("Año"),rsPeliculas.getInt("Duracion"),rsPeliculas.getString("Pais"),rsPeliculas.getString("Genero")));

            }
            
            conexiondb.close();
            return camisas;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
        
    }
    
    void EliminarPeliculas() {
    Connection conexiondb = ConexionDB.getConnection();
        
        //Ejecutar operaciones en la BD
        //Crear la sentencia SQL
        String sentenciaSql = "DELETE FROM peliculas WHERE Id=?";
        try {
            //Configurar los paramewtros de la sentencia SQL
            PreparedStatement parametro = conexiondb.prepareStatement(sentenciaSql);
            parametro.setInt(1, this.getId());

            //Ejecutar la sentecia SQL
            parametro.execute();
            conexiondb.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
}
