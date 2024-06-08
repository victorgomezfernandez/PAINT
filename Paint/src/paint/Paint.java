package paint;

import java.sql.SQLException;

public class Paint {
    
    public static void main(String[] args)  throws ClassNotFoundException, SQLException {
        Modelo pm = new Modelo();
        Controlador pc = new Controlador(pm, 600, 600);
        Vista pv = new Vista(pc);
        pv.setVisible(true);
    }
    
}