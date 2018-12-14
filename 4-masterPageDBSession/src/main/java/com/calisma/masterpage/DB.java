package com.calisma.masterpage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Base64;
import java.util.Random;



public class DB {

	final private String driver = "com.mysql.jdbc.Driver";
    final private String url = "jdbc:mysql://localhost/";
    final private String endCode = "?useUnicode=true&characterEncoding=utf-8";
    private String dbName = "masterpage"; // database adi
    private String dbUser = "root";
    private String dbPassword = "";

    private Connection conn = null;
    private Statement st = null;
    private PreparedStatement prest = null;
    public DB() {

    }

    public DB(String dbName, String dbUser, String dbPassword){
        this.dbName = dbName;
        this.dbUser = dbUser;
        this.dbPassword = dbPassword;
        

    }

   
    public Statement baglan() {
        if (st != null) {
            kapat();
        }
        
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url + dbName + endCode, dbUser, dbPassword);
            st = conn.createStatement();
            System.out.println("baglanti basarili");

        } catch (Exception e) {

            System.err.println("baglanti hatasi! " + e);
        }

        return st;
    }

     public PreparedStatement preBaglan(String query) {

        if (prest != null) {
        	kapat();
        }
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url + dbName + endCode, dbUser, dbPassword);
            prest = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            System.out.println("prepared baglanti basarili");
        } catch (Exception e) {
            System.err.println("prepared baglanti hatasi!:  " + e);
        }

        return prest;
    }

     public void kapat() {
    	 try {
            if (prest != null) {
                prest.close();
                prest = null;
                System.out.println("prepared statement kapatildi");
            }
            if (st != null) {
                st.close();
                st = null;
                 System.out.println("statement kapatildi");
            }
            if (conn != null) {
                conn.close();
                conn = null;
                System.out.println("connection kapatildi");
            }
        } catch (SQLException e) {
            System.err.println("kapatma hatası!: " + e);
        }
    }
	
	
	public static String MD5(String md5) {
		try {
			java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
			byte[] array = md.digest(md5.getBytes());
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < array.length; ++i) {
				sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
			}
			return sb.toString();
		} catch (java.security.NoSuchAlgorithmException e) {
		}
		return null;
	}
	
	
	public static String sifrele(String data, int i) {
		byte[] dizi = null;
		Random rd = new Random();
		int ri = rd.nextInt(899) + 100;
		for (int j = 0; j < i; j++) {
			dizi = Base64.getEncoder().encode(data.getBytes());
			data = new String(dizi);
		}
		String sifrelenmis = new String(dizi) + MD5("" + ri);
		System.out.println("sifrelenmis" + sifrelenmis);
		return sifrelenmis;
	}

	public static String sifreCoz(String data, int i) {
		byte[] dizi = null;
		data = data.substring(0, data.length() - 32);
		for (int j = 0; j < i; j++) {
			dizi = Base64.getDecoder().decode(data.getBytes());
			data = new String(dizi);
		}
		String cozulmus = new String(dizi);
		System.out.println("cozulmus" + cozulmus);
		return cozulmus;
	}
	
}
