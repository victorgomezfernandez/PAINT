package paint;

public class Poligono implements Figura{
    public int[] pointsX;
    public int[] pointsY;
    public String lColor;
    public String fColor;
    public int nVertices;
    public int orden;
    public int lineR;
    public int lineG;
    public int lineB;
    public int fillR;
    public int fillG;
    public int fillB;
    public int fillA;

    
    public Poligono(int[] pointsX, int[] pointsY, String lColor, String fColor, int nVertices, int orden) {
        this.pointsX = pointsX;
        this.pointsY = pointsY;
        this.lColor = lColor;
        this.fColor = fColor;
        this.nVertices = nVertices;
        this.orden = orden;
        extractColors(lColor);
        extractFillColors(fColor);
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
        return "INSERT INTO poligonos (id, lColor, fColor, nVertices, orden, id_dibujo) VALUES ("+idPoligono+",'"+lColor+"','"+fColor+"',"+nVertices+","+orden+","+Dibujo+");";
    }
    
    public String insertPoints(int idPoligono){
        return "INSERT INTO Vertices (x,y,id_poligono) VALUES "+pointsToString(pointsX,pointsY,idPoligono)+";";
    }
    
    public String svgLine(){
        return "<polygon points=\""+this.pointsToSvg(pointsX, pointsY)+"\" stroke=\""+lColor+"\" fill=\""+fColor+"\"/>\n";
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
