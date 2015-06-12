package com.predictpok.db;

import java.sql.*;



public class ControlDB {
	private Connection conexion;
	private String nombreDB="jdbc:mysql://localhost/predictpok01";
	private String usuarioDB="pok01";
	private String passwordDB="pok01";

	public Connection getConexion() {
		return conexion;
    }

	public void setConexion(Connection conexion) {
		this.conexion = conexion;
    }

	public ControlDB conectar(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conexion= DriverManager.getConnection(nombreDB,usuarioDB,passwordDB);
			if(conexion!=null){
				System.out.println("Conexion exitosa a esquema pok01");
			}else{System.out.println("Conexion fallida");}
        }catch(Exception e){
        	e.printStackTrace();
        }

		return this;
    }
	public void desconectar(){
		try{
		conexion.close();
		}catch (Exception e){e.printStackTrace();}
	}
	
	public boolean ejecutar(String sql){
		 try {
	        Statement sentencia;
	        sentencia = getConexion().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
	        sentencia.executeUpdate(sql);
	        //getConexion().commit();
	        sentencia.close();
	     } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	     } 
		 return true;
	}
	
	public ResultSet consultar(String sql){
		ResultSet resultado = null;
        try {
            Statement sentencia;
            sentencia = getConexion().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            resultado = sentencia.executeQuery(sql);
            //getConexion().commit();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }        return resultado;
	}
}
