package paint;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Modelo {

    public LinkedList<String> listaDibujos;
    public LinkedList<Figura> listaFiguras;
    public Connection con;
    public String sURL = "jdbc:mariadb://localhost:3306/paint";
    public int idDibujo;

    public Modelo() throws ClassNotFoundException, SQLException {
        idDibujo = this.obtenerId();
        listaDibujos = new LinkedList<>();
        listaFiguras = new LinkedList<>();
        inicializarBd();
    }

    public void inicializarBd() throws ClassNotFoundException, SQLException {
        listaDibujos.clear();
        try {
            con = DriverManager.getConnection(sURL, "root", "");
            Statement s = con.createStatement();
            ResultSet rs;
            String comando = "SELECT `nombre` FROM `dibujos`;";
            rs = s.executeQuery(comando);
            while (rs.next()) {
                this.listaDibujos.add(rs.getString(1));
            }
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    public void agregarDibujo(String nombre) {
        this.listaDibujos.add(nombre.toUpperCase());
        try {
            con = DriverManager.getConnection(sURL, "root", "");
            Statement s = con.createStatement();
            String comando = "INSERT INTO `dibujos` (id, nombre) VALUES (" + idDibujo + ",'" + nombre.toUpperCase() + "');";
            s.executeUpdate(comando);
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        idDibujo = this.obtenerId();
    }

    public void eliminarDibujo(String nombre) {
        this.listaDibujos.remove(nombre.toUpperCase());
        try {
            con = DriverManager.getConnection(sURL, "root", "");
            Statement s = con.createStatement();
            String comando = "DELETE FROM `dibujos` WHERE `nombre` = '" + nombre.toUpperCase() + "';";
            s.executeUpdate(comando);
            con.close();
        } catch (SQLException ex) {
            System.out.println("Base de datos no conectada");
        }
    }

    public void insertarFigura(String comando) {
        try {
            con = DriverManager.getConnection(sURL, "root", "");
            Statement s = con.createStatement();
            s.executeUpdate(comando);
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public int obtenerIdPoligono() {
        int idPoligono = 0;
        try {
            con = DriverManager.getConnection(sURL, "root", "");
            Statement s = con.createStatement();
            String comando = "SELECT MAX(id) FROM Poligonos;";
            ResultSet rs = s.executeQuery(comando);
            if (rs.next()) {
                idPoligono = rs.getInt(1);
            }
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return idPoligono;
    }

    public int obtenerId() {
        int idActual = 0;
        try {
            con = DriverManager.getConnection(sURL, "root", "");
            Statement s = con.createStatement();
            String comando = "SELECT MAX(id) FROM dibujos";
            ResultSet rs = s.executeQuery(comando);
            if (rs.next()) {
                idActual = rs.getInt(1) + 1;
            }
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return idActual;
    }

    public int obtenerIdSeleccionado(String nombre) {
        int idSeleccionado = 0;
        try {
            con = DriverManager.getConnection(sURL, "root", "");
            Statement s = con.createStatement();
            String comando = "SELECT id FROM `dibujos` WHERE `nombre` = '" + nombre.toUpperCase() + "';";
            ResultSet rs = s.executeQuery(comando);
            if (rs.next()) {
                idSeleccionado = rs.getInt(1);
            }
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return idSeleccionado;
    }

    public String obtenerFigurasSvg(String nombre, int width, int height) {
        String svgCode = "";
        obtenerFiguras(nombre);
        for (Object figura : listaFiguras) {
            svgCode+=figura;
        }
        this.listaFiguras.clear();
        return svgCode;
    }
    
    public LinkedList obtenerFiguras (String nombre) {
        int idDibujoActual = obtenerIdSeleccionado(nombre);
        this.listaFiguras.clear();
        try {
            con = DriverManager.getConnection(sURL, "root", "");
            Statement s = con.createStatement();
            String comando = "SELECT startX,startY,endX,endY,lColor,orden FROM `rectas` WHERE `id_dibujo` = " + idDibujoActual + ";";
            ResultSet rs = s.executeQuery(comando);
            while (rs.next()) {
                int rsX = rs.getInt(1);
                int rsY = rs.getInt(2);
                int reX = rs.getInt(3);
                int reY = rs.getInt(4);
                String rLc = rs.getString(5);
                int rO = rs.getInt(6);
                listaFiguras.add(new Recta(rsX, rsY, reX, reY, rLc, rO));
            }
            comando = "SELECT x,y,radius,lColor,fColor,orden FROM `circunferencias` WHERE `id_dibujo` = " + idDibujoActual + ";";
            rs = s.executeQuery(comando);
            while (rs.next()) {
                int cX = rs.getInt(1);
                int cY = rs.getInt(2);
                int cR = rs.getInt(3);
                String cLc = rs.getString(4);
                String cFc = rs.getString(5);
                int cO = rs.getInt(6);
                listaFiguras.add(new Circunferencia(cX, cY, cR, cLc, cFc, cO));
            }
            comando = "SELECT id,lColor,fColor,nVertices,orden FROM `poligonos` WHERE `id_dibujo` = " + idDibujoActual + ";";
            rs = s.executeQuery(comando);
            while (rs.next()) {
                int pId = rs.getInt(1);
                String pLc = rs.getString(2);
                String pFc = rs.getString(3);
                int pNv = rs.getInt(4);
                int pO = rs.getInt(5);
                int[] pointsX = new int[pNv];
                int[] pointsY = new int[pNv];
                comando = "SELECT x,y FROM `vertices` WHERE `id_poligono` = " + pId + ";";
                System.out.println(idDibujoActual+","+pId);
                rs = s.executeQuery(comando);
                int secuencia = 0;
                while (rs.next()) {
                    pointsX[secuencia] = rs.getInt(1);
                    pointsY[secuencia] = rs.getInt(2);
                    secuencia++;
                }
                listaFiguras.add(new Poligono(pointsX, pointsY, pLc, pFc, pNv, pO));
            }
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        listaFiguras = ordenarLista(listaFiguras);
        return listaFiguras;
    }
    
    public LinkedList ordenarLista (LinkedList listaFiguras){
        Collections.sort(listaFiguras, new Comparator<Figura>() {
            @Override
            public int compare(Figura f1, Figura f2) {
                return Integer.compare(f1.getOrden(), f2.getOrden());
            }
        });
        return listaFiguras;
    }

    public String[] obtenerDibujos() {
        String[] dibujos = new String[listaDibujos.size()];
        for (int i = 0; i < listaDibujos.size(); i++) {
            dibujos[i] = listaDibujos.get(i);
        }
        return dibujos;
    }
}
