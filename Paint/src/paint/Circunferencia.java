package paint;

public class Circunferencia implements Figura{
    public int x;
    public int y;
    public int radius;
    public String lColor;
    public String fColor;
    public int orden;
    public int lineR;
    public int lineG;
    public int lineB;
    public int fillR;
    public int fillG;
    public int fillB;
    public int fillA;

    public Circunferencia(int x, int y, int radius, String lColor, String fColor, int orden) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.lColor = lColor;
        this.fColor = fColor;
        this.orden = orden;
        extractColors(lColor);
        extractFillColors(fColor);
    }
    
    public String insertCircle(int Dibujo){
        return ("INSERT INTO Circunferencias (x, y, radius, lColor, fColor, orden, id_dibujo) VALUES ("+x+","+y+","+radius+",'"+lColor+"','"+fColor+"',"+orden+","+Dibujo+") ");
    }
    
    public String svgLine(){
        return "<circle cx=\""+this.x+"\" cy=\""+this.y+"\" r=\""+this.radius+"\" stroke=\""+lColor+"\" fill=\""+fColor+"\" />\n";
    }
    
    public void extractColors(String color){
        String numbersOnly = color.substring(5, color.length() -1);
        String[] rgbValues = numbersOnly.split(",");
        this.lineR = Integer.parseInt(rgbValues[0].trim());
        this.lineG = Integer.parseInt(rgbValues[1].trim());
        this.lineB = Integer.parseInt(rgbValues[2].trim());
    }
    
    public void extractFillColors(String color){
        String numbersOnly = color.substring(6, color.length() -1);
        String[] rgbValues = numbersOnly.split(",");
        this.fillR = Integer.parseInt(rgbValues[0].trim());
        this.fillG = Integer.parseInt(rgbValues[1].trim());
        this.fillB = Integer.parseInt(rgbValues[2].trim());
        this.fillA = Integer.parseInt(rgbValues[3].trim());
    }
    
    @Override public String toString(){
        return svgLine();
    }
    
    @Override public int getOrden() {
        return this.orden;
    }
}
