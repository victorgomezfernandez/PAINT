package paint;

public class Poligono {
    public int[] pointsX;
    public int[] pointsY;
    public String lColor;
    public String fColor;
    public int nVertices;
    public int orden;

    
    public Poligono(int[] pointsX, int[] pointsY, String lColor, String fColor, int nVertices, int orden) {
        this.pointsX = pointsX;
        this.pointsY = pointsY;
        this.lColor = lColor;
        this.fColor = fColor;
        this.nVertices = nVertices;
        this.orden = orden;
    }
    
    public String pointsToString(int[] pointsX, int[] pointsY, int idPoligono){
        String pointsString = "";
        for (int i = 0; i < pointsX.length-1; i++) {
            pointsString+="("+pointsX[i]+","+pointsY[i]+","+idPoligono+"),";
        }
        pointsString+="("+pointsX[pointsX.length-1]+","+pointsY[pointsY.length-1]+","+idPoligono+")";
        return pointsString;
    }
    
    public String pointsToSvg(int[] pointsX, int[] pointsY){
        StringBuilder pointsString = new StringBuilder();
        for (int i = 0; i < pointsX.length; i++) {
            pointsString.append(pointsX[i]).append(",").append(pointsY[i]);
            if (i < pointsX.length -1 ) {
                pointsString.append(" ");
            }
        }
        return pointsString.toString();
    }
    
    public String insertPolygon(int Dibujo, int idPoligono){
        System.out.println(nVertices);
        return "INSERT INTO poligonos (id, lColor, fColor, nVertices, orden, id_dibujo) VALUES ("+idPoligono+",'"+lColor+"','"+fColor+"',"+nVertices+","+orden+","+Dibujo+");";
    }
    
    public String insertPoints(int idPoligono){
        return "INSERT INTO Vertices (x,y,id_poligono) VALUES "+pointsToString(pointsX,pointsY,idPoligono)+";";
    }
    
    public String svgLine(){
        return "<polygon points=\""+this.pointsToSvg(pointsX, pointsY)+"\" stroke=\""+lColor+"\" fill=\""+fColor+"\"/>\n";
    }
    
    @Override public String toString(){
        return svgLine();
    }
    
}
