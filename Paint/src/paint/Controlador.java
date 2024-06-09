package paint;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class Controlador {

    Modelo pm;
    public String svgString;
    public LinkedList<Object> figuras;
    public LinkedList<Recta> rectas;
    public LinkedList<Circunferencia> circunferencias;
    public LinkedList<Poligono> poligonos;
    public int width;
    public int height;
    public String[] DL;
    public int orden;
    public int idDibujo;

    public Controlador(Modelo pm, int width, int height) {
        this.pm = pm;
        this.figuras = new LinkedList<>();
        this.rectas = new LinkedList<>();
        this.circunferencias = new LinkedList<>();
        this.poligonos = new LinkedList<>();
        this.width = width;
        this.height = height;
        this.idDibujo = this.pm.idDibujo;
    }

    public void consultarDibujos() {
        DL = pm.obtenerDibujos();
    }

    public void agregarDibujo(String nombre) {
        consultarDibujos();
        this.pm.agregarDibujo(nombre);
        for (Object figura : figuras) {
            if (figura instanceof Recta recta) {
                this.pm.insertarFigura(recta.insertLine(idDibujo));
            }
            if (figura instanceof Circunferencia circunferencia) {
                this.pm.insertarFigura(circunferencia.insertCircle(idDibujo));
            }
            if (figura instanceof Poligono poligono) {
                this.pm.insertarFigura(poligono.insertPolygon(idDibujo, this.obtenerIdPoligono() + 1));
                this.pm.insertarFigura(poligono.insertPoints(this.obtenerIdPoligono()));
            }
        }
        this.idDibujo = this.pm.idDibujo;
    }

    public void eliminarDibujo(String nombre) {
        consultarDibujos();
        this.pm.eliminarDibujo(nombre);
    }

    public void drawLine(int xStart, int yStart, int xEnd, int yEnd, String lColor) {
        this.figuras.add(new Recta(xStart, yStart, xEnd, yEnd, lColor, orden));
        aumentarOrden();
    }

    public void drawCircle(int x, int y, int radio, String lColor, String fColor) {
        this.figuras.add(new Circunferencia(x, y, radio, lColor, fColor, orden));
        aumentarOrden();
    }

    public void drawPolygon(int[] pointsX, int[] pointsY, String lColor, String fColor, int nVertices) {
        String points = "";
        for (int i = 0; i < pointsX.length; i++) {
            points += pointsX[i] + "," + pointsY[i] + " ";
        }
        this.figuras.add(new Poligono(pointsX, pointsY, lColor, fColor, nVertices, orden));
        aumentarOrden();
    }

    public int obtenerIdPoligono() {
        return this.pm.obtenerIdPoligono();
    }

    public void generateSvgCode(String nombre) {
        svgString = ("<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"" + width + "\" height=\"" + height + "\">\n");
        svgString += this.pm.obtenerFigurasSvg(nombre, width, height);
        svgString += "</svg>";
        try {
            FileWriter fw = new FileWriter(nombre + ".svg");
            fw.write(svgString);
            fw.close();
            String path = nombre+".svg";
            File arc = new File(path);
            Desktop dk = Desktop.getDesktop();
            dk.open(arc);
        } catch (IOException e) {
            System.out.println(e);
        }
        
    }

    public void clearFigures() {
        this.figuras.clear();
        this.circunferencias.clear();
        this.poligonos.clear();
        svgString = ("<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"" + width + "\" height=\"" + height + "\">\n");
        this.orden = 0;
    }
    
    public LinkedList getFiguresToDraw(String nombre){
        return this.pm.obtenerFiguras(nombre);
    }

    public void aumentarOrden() {
        this.orden++;
    }

}
