package paint;

public class Recta {
    public int startX;
    public int startY;
    public int endX;
    public int endY;
    public String lColor;
    public int orden;

    public Recta(int startX, int startY, int endX, int endY, String lColor, int orden) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.lColor = lColor;
        this.orden = orden;
    }
    
    public String insertLine(int Dibujo){
        return ("INSERT INTO Rectas (startX, startY, endX, endY, lColor, orden, id_dibujo) VALUES ("+startX+","+startY+","+endX+","+endY+",'"+lColor+"',"+orden+","+Dibujo+") ");
    }
    
    public String svgLine(){
        return "<line x1=\""+this.startX+"\" y1=\""+this.startY+"\" x2=\""+this.endX+"\" y2=\""+this.endY+"\" stroke=\""+lColor+"\" />\n";
    }
    
    @Override public String toString(){
        return svgLine();
    }
}
