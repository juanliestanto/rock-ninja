/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RockNinja;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Koneksi {
    public static final Connection CONN = connect();
    Connection con;
    Statement stm;
    
    public void config(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/rockninja?serverTimezone=UTC", "root", "");
            stm = con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    static Connection connect() {
      Connection conn = null;
      String url = "jdbc:mysql://localhost/rockninja?serverTimezone=UTC";

      try {
         conn = DriverManager.getConnection(url, "root", "");
      } catch (Exception e) {
         e.printStackTrace();
      }
      return conn;
   }

   static void executeUpdateQuerry(String querry) {
       try {
         Statement stt = CONN.createStatement();
         stt.executeUpdate(querry);

      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   static ResultSet executeReadQuerry(String querry) {
      ResultSet rs = null;
      try {
         Statement stt = CONN.createStatement();
         rs = stt.executeQuery(querry);

      } catch (Exception e) {
         e.printStackTrace();
      }
      return rs;
   }
   public static void nambahSkor(String nama,int skor){
   int id = ambil_id(nama);
   try{
   String sql = "INSERT INTO highscore(id_player,score) VALUES("+id+","+skor+")";
   java.sql.Connection conn = (Connection) Koneksi.connect();
   java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
   pstm.execute();
   
   }catch (HeadlessException | SQLException e){
   System.out.println("Id Gagal diambil" + e.getMessage());
   }
  
   }
   public static int ambil_id(String nama){
        int nilai = 0;
        try {
            String sql = "SELECT id_player FROM player WHERE nama = '"+ nama +"'";
            
            java.sql.Connection conn = (Connection) Koneksi.connect();
            java.sql.Statement stm = conn.createStatement();
            
            ResultSet rs = stm.executeQuery(sql);
            
//            nilai = rs.getInt("id_pemain");
            while(rs.next()){
                nilai = rs.getInt("id_player");    
              
            }

        }catch (HeadlessException | SQLException e) {
            System.out.println("Id Gagal diambil" + e.getMessage());
        }
        return nilai;
    }
   

   

   public static void main(String[] args) {

//      ResultSet rs = Koneksi.executeReadQuerry("select * from pemain");
//      try {
//         while (rs.next()) {
//            System.out.println(rs.getString("namapemain"));
//         }
//      } catch (Exception e) {
//         e.printStackTrace();
//      }
//      
//      var rs2 = Koneksi.executeReadQuerry("select * from pertanyaan");
//      try {
//         while (rs.next()) {
//            System.out.println(rs.getString("jenis_pertanyaan"));
//         }
//      } catch (Exception e) {
//         e.printStackTrace();
//      }

      
      try {
         CONN.close();
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

      // [MYSQL BUSY]
   }
    

}