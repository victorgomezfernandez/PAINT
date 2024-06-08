package paint;

public class Circunferencia {
    public int x;
    public int y;
    public int radius;
    public String lColor;
    public String fColor;
    public int orden;

    public Circunferencia(int x, int y, int radius, String lColor, String fColor, int orden) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.lColor = lColor;
        this.fColor = fColor;
        this.orden = orden;
    }
    
    public String insertCircle(int Dibujo){
        System.out.println("INSERT INTO Circunferencias (x, y, radius, lColor, fColor, orden, id_dibujo) VALUES ("+x+","+y+","+radius+",'"+lColor+"','"+fColor+"',"+orden+","+Dibujo+") ");
        return ("INSERT INTO Circunferencias (x, y, radius, lColor, fColor, orden, id_dibujo) VALUES ("+x+","+y+","+radius+",'"+lColor+"','"+fColor+"',"+orden+","+Dibujo+") ");
    }
    
    public String svgLine(){
        return "<circle cx=\""+this.x+"\" cy=\""+this.y+"\" r=\""+this.radius+"\" stroke=\""+lColor+"\" fill=\""+fColor+"\" />\n";
    }
    
    @Override public String toString(){
        return svgLine();
    }
}
