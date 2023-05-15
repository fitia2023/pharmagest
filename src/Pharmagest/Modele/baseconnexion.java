package Pharmagest.Modele;

import java.sql.Connection;
import java.sql.DriverManager;

public class baseconnexion {

    public Connection connection(String bdname, String bduser , String bdpassword){

        Connection bd = null;

        try{

        Class.forName("org.postgresql.Driver");
        bd =DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+bdname,bduser,bdpassword);

        if (bd != null ){
            System.out.print("reussi");
        }else {
            System.out.print("pas connect");
        }

        }catch (Exception e){
            System.out.println(e);
        }
        return bd;
    }

}
