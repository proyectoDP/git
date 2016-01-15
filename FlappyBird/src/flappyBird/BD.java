package flappyBird;

import java.awt.Component;
import java.sql.*;
import java.util.ArrayList;

	public class BD

	{
		
		
		
		
		public void CrearTabla (String nombre, int puntuacion) throws SQLException
		
		{
			
			
			Connection c = null;
		    Statement stmt = null;
		    
		   try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:test.db");
		      System.out.println("ABIERTA LA BASE DE DATOS");

		      stmt = c.createStatement();
		      String sql = "CREATE TABLE IF NOT EXISTS PUNTUACION " +
		                   "(ID INTEGER PRIMARY KEY   AUTOINCREMENT," +
		                   " NOMBRE           TEXT    NOT NULL, " + 
		                   " PUNTUACION            INT     NOT NULL)"; 
		      stmt.executeUpdate(sql);
		      stmt.close();
		      c.close();
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
		    System.out.println("TABLA CREADA");
		
		   try {
		        Class.forName("org.sqlite.JDBC");
		        c = DriverManager.getConnection("jdbc:sqlite:test.db");
		        c.setAutoCommit(false);
		        System.out.println("Opened database successfully");

		        stmt = c.createStatement();
		        String sql = "INSERT INTO PUNTUACION (NOMBRE,PUNTUACION) " +
		                "VALUES ( "+"'"+nombre+"'"+  ","+ puntuacion + ");";
		        stmt.executeUpdate(sql);

		        stmt.close();
		        c.commit();
		        c.close();
		      } catch ( Exception e ) {
		        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		        System.exit(0);
		      }
		      System.out.println("RECORDS CREADO");
		      
		}
		
		      public static void Puntuaciones ()
	
		      {
		    	  
		    	  Connection c = null;
				  Statement stmt = null;
				  
		      try {
		          Class.forName("org.sqlite.JDBC");
		          c = DriverManager.getConnection("jdbc:sqlite:test.db");
		          c.setAutoCommit(false);
		          System.out.println("ABIERTA LA BBDD");
		          
		          Ventana ventana = new Ventana();
		          ventana.setVisible(true);
		          
		          stmt = c.createStatement();
		          ResultSet rs = stmt.executeQuery( "SELECT * FROM PUNTUACION ORDER BY puntuacion DESC LIMIT 1;" );
		          while ( rs.next() ) {
		             int id1 = rs.getInt("id");
		             String  nombre1 = rs.getString("nombre");
		             int puntuacion1  = rs.getInt("puntuacion");
		             System.out.println( "ID = " + id1 );
		             System.out.println( "NAME = " + nombre1 );
		             System.out.println( "PUNTUACION = " + puntuacion1 );
		             
		             ventana.Anadir(nombre1, puntuacion1);
		             
		          }
		          
		          rs.close();
		          stmt.close();
		          c.close();
		        } catch ( Exception e ) {
		          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		          System.exit(0);
		        }
		        System.out.println("TODO BIEN");
		        
			}

	}