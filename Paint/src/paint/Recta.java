package paint;

public class Recta implements Figura{
    public int startX;
    public int startY;
    public int endX;
    public int endY;
    public String lColor;
    public int orden;
    public int lineR;
    public int lineG;
    public int lineB;

    public Recta(int startX, int startY, int endX, int endY, String lColor, int orden) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.lColor = lColor;
        this.orden = orden;
        extractColors(lColor);
    }
    
    public String insertLine(int Dibujo){
        return ("INSERT INTO Rectas (startX, startY, endX, endY, lColor, orden, id_dibujo) VALUES ("+startX+","+startY+","+endX+","+endY+",'"+lColor+"',"+orden+","+Dibujo+") ");
    }
    
    public String svgLine(){
        return "<line x1=\""+this.startX+"\" y1=\""+this.startY+"\" x2=\""+this.endX+"\" y2=\""+this.endY+"\" stroke=\""+lColor+"\" />\n";
    }
    
    public void extractColors(String color){
        String numbersOnly = color.substring(5, color.length() -1);
        String[] rgbValues = numbersOnly.split(",");
        this.lineR = Integer.parseInt(rgbValues[0].trim());
        this.lineG = Integer.parseInt(rgbValues[1].trim());
        this.lineB = Integer.parseInt(rgbValues[2].trim());
    }
    
    @Override public String toString(){
        return svgLine();
    }
    
    @Override public int getOrden() {
        return this.orden;
    }
}
