package paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.text.*;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.DefaultListModel;

public class Vista extends javax.swing.JFrame implements MouseListener {

    Controlador pc;

    public ArrayList<Point> clickedPoints;
    public LinkedList<Figura> figuresToDraw;
    public boolean drawingIrregular = false;
    DefaultListModel<String> drawingsModel;

    public Vista(Controlador pc) {
        initComponents();
        notFill();
        notSelectedPolygon();
        fillChanged();
        ((AbstractDocument) lineRField.getDocument()).setDocumentFilter(new onlyInt());
        ((AbstractDocument) lineGField.getDocument()).setDocumentFilter(new onlyInt());
        ((AbstractDocument) lineBField.getDocument()).setDocumentFilter(new onlyInt());
        ((AbstractDocument) fillRField.getDocument()).setDocumentFilter(new onlyInt());
        ((AbstractDocument) fillGField.getDocument()).setDocumentFilter(new onlyInt());
        ((AbstractDocument) fillBField.getDocument()).setDocumentFilter(new onlyInt());
        clickedPoints = new ArrayList<>();
        this.pc = pc;
        drawingsModel = new DefaultListModel<>();
        drawingsList.setModel(drawingsModel);
        updateDrawingModel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        figuresList = new javax.swing.JList<>();
        sidesSlider = new javax.swing.JSlider();
        sidesField = new javax.swing.JTextField();
        sidesLabel = new javax.swing.JLabel();
        figureCanvas = new java.awt.Canvas();
        lineLabel = new javax.swing.JLabel();
        lineRSlider = new javax.swing.JSlider();
        lineRLabel = new javax.swing.JLabel();
        lineRField = new javax.swing.JTextField();
        lineGSlider = new javax.swing.JSlider();
        lineGLabel = new javax.swing.JLabel();
        lineGField = new javax.swing.JTextField();
        lineBSlider = new javax.swing.JSlider();
        lineBLabel = new javax.swing.JLabel();
        lineBField = new javax.swing.JTextField();
        fillLabel = new javax.swing.JLabel();
        fillRSlider = new javax.swing.JSlider();
        fillGSlider = new javax.swing.JSlider();
        fillBSlider = new javax.swing.JSlider();
        fillRLabel = new javax.swing.JLabel();
        fillGLabel = new javax.swing.JLabel();
        fillBLabel = new javax.swing.JLabel();
        fillRField = new javax.swing.JTextField();
        fillGField = new javax.swing.JTextField();
        fillBField = new javax.swing.JTextField();
        figuresLabel = new javax.swing.JLabel();
        fillCheck = new javax.swing.JCheckBox();
        clearButton = new javax.swing.JButton();
        generateButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        drawingsList = new javax.swing.JList<>();
        drawingField = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        drawButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titleLabel.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        titleLabel.setText("PAINT");

        figuresList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Punto", "Recta", "Circunferencia", "Polígono regular", "Polígono irregular" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        figuresList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        figuresList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                figuresListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(figuresList);

        sidesSlider.setMajorTickSpacing(1);
        sidesSlider.setMaximum(20);
        sidesSlider.setPaintTicks(true);
        sidesSlider.setSnapToTicks(true);
        sidesSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sidesSliderStateChanged(evt);
            }
        });

        sidesLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        sidesLabel.setText("Lados (escribe un número o usa el slider):");

        figureCanvas.setBackground(new java.awt.Color(255, 255, 255));
        figureCanvas.setMaximumSize(new java.awt.Dimension(500, 500));
        figureCanvas.setMinimumSize(new java.awt.Dimension(500, 500));
        figureCanvas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                figureCanvasMouseClicked(evt);
            }
        });

        lineLabel.setText("Color de línea");

        lineRSlider.setMajorTickSpacing(50);
        lineRSlider.setMaximum(255);
        lineRSlider.setMinorTickSpacing(10);
        lineRSlider.setPaintTicks(true);
        lineRSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                lineRSliderStateChanged(evt);
            }
        });

        lineRLabel.setText("R:");

        lineRField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lineRFieldActionPerformed(evt);
            }
        });

        lineGSlider.setMajorTickSpacing(50);
        lineGSlider.setMaximum(255);
        lineGSlider.setMinorTickSpacing(10);
        lineGSlider.setPaintTicks(true);
        lineGSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                lineGSliderStateChanged(evt);
            }
        });

        lineGLabel.setText("G:");

        lineGField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lineGFieldActionPerformed(evt);
            }
        });

        lineBSlider.setMajorTickSpacing(50);
        lineBSlider.setMaximum(255);
        lineBSlider.setMinorTickSpacing(10);
        lineBSlider.setPaintTicks(true);
        lineBSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                lineBSliderStateChanged(evt);
            }
        });

        lineBLabel.setText("B:");

        lineBField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lineBFieldActionPerformed(evt);
            }
        });

        fillLabel.setText("Color de relleno");

        fillRSlider.setMajorTickSpacing(50);
        fillRSlider.setMaximum(255);
        fillRSlider.setMinorTickSpacing(10);
        fillRSlider.setPaintTicks(true);
        fillRSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                fillRSliderStateChanged(evt);
            }
        });

        fillGSlider.setMajorTickSpacing(50);
        fillGSlider.setMaximum(255);
        fillGSlider.setMinorTickSpacing(10);
        fillGSlider.setPaintTicks(true);
        fillGSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                fillGSliderStateChanged(evt);
            }
        });

        fillBSlider.setMajorTickSpacing(50);
        fillBSlider.setMaximum(255);
        fillBSlider.setMinorTickSpacing(10);
        fillBSlider.setPaintTicks(true);
        fillBSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                fillBSliderStateChanged(evt);
            }
        });

        fillRLabel.setText("R:");

        fillGLabel.setText("G:");

        fillBLabel.setText("B:");

        fillRField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fillRFieldActionPerformed(evt);
            }
        });

        fillGField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fillGFieldActionPerformed(evt);
            }
        });

        fillBField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fillBFieldActionPerformed(evt);
            }
        });

        figuresLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        figuresLabel.setText("SELECCIONA UNO:");

        fillCheck.setText("Relleno");
        fillCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fillCheckActionPerformed(evt);
            }
        });

        clearButton.setText("LIMPIAR DIBUJO");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        generateButton.setText("GENERAR SVG");
        generateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateButtonActionPerformed(evt);
            }
        });

        drawingsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(drawingsList);

        addButton.setText("AGREGAR");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("ELIMINAR");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        drawButton.setText("DIBUJAR SELECCIONADO");
        drawButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drawButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(sidesLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lineRSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lineRLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lineRField, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lineGSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lineGLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lineGField, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lineBSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lineBLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lineBField, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                                .addComponent(fillLabel)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(fillRSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(fillRLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(fillRField, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(fillGSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(fillGLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(fillGField, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(fillBSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(fillBLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(fillBField, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                                .addComponent(sidesSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(sidesField))
                            .addComponent(figuresLabel)
                            .addComponent(lineLabel)
                            .addComponent(fillCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(clearButton)
                            .addComponent(figureCanvas, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(drawingField)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(drawButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteButton))
                    .addComponent(generateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titleLabel)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(29, Short.MAX_VALUE)
                                .addComponent(clearButton)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(figuresLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sidesLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sidesSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sidesField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lineLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lineRSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lineRLabel)
                                    .addComponent(lineRField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lineGSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lineGLabel)
                                    .addComponent(lineGField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lineBSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lineBLabel)
                                    .addComponent(lineBField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fillCheck)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fillLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(fillRSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fillRLabel)
                                    .addComponent(fillRField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(fillGSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fillGLabel)
                                    .addComponent(fillGField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(fillBSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fillBLabel)
                                    .addComponent(fillBField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(figureCanvas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(drawingField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addButton)
                            .addComponent(deleteButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(drawButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(generateButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public int lineR, lineG, lineB, fillR, fillG, fillB, sides;
    public String selectedFigure;
    public boolean fill, painting = false;
    public int startX, startY, endX, endY;

    public void updateDrawingModel() {
        String[] list = this.pc.pm.obtenerDibujos();
        drawingsModel.clear();
        for (String dibujo : list) {
            drawingsModel.addElement(dibujo);
        }
    }

    private void sidesSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sidesSliderStateChanged
        sidesField.setText(String.valueOf(sidesSlider.getValue()));
        sides = sidesSlider.getValue();
    }//GEN-LAST:event_sidesSliderStateChanged

    private void figureCanvasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_figureCanvasMouseClicked
        Graphics fg = figureCanvas.getGraphics();
        Graphics2D g = (Graphics2D) fg;
        if (!painting) {
            startX = evt.getX();
            startY = evt.getY();
            g.setColor(new Color(lineR, lineG, lineB));
            if ((!figuresList.isSelectionEmpty())) {
                if (selectedFigure.equals("Punto")) {
                    String lColor = String.valueOf(" rgb(" + lineR + "," + lineG + "," + lineB + ")");
                    g.drawLine(startX, startY, startX, startY);
                    this.pc.drawLine(startX, startY, startX + 1, startY + 1, lColor);
                }
            }
        } else {
            endX = evt.getX();
            endY = evt.getY();
            g.setColor(new Color(lineR, lineG, lineB));
            if ((!figuresList.isSelectionEmpty())) {
                if (selectedFigure.equals("Punto")) {
                    String lColor = String.valueOf(" rgb(" + lineR + "," + lineG + "," + lineB + ")");
                    g.drawLine(endX, endY, endX, endY);
                    this.pc.drawLine(endX, endY, endX + 1, endY + 1, lColor);
                }
            }
        }
        if ((!figuresList.isSelectionEmpty())) {
            int x = startX;
            int y = startY;
            g.setColor(new Color(lineR, lineG, lineB));
            switch (selectedFigure) {
                case "Recta":
                    if (painting) {
                        g.drawLine(startX, startY, endX, endY);
                        String lColor = String.valueOf(" rgb(" + lineR + "," + lineG + "," + lineB + ")");
                        this.pc.drawLine(startX, startY, endX, endY, lColor);
                    }
                    break;
                case "Circunferencia":
                    if (painting) {
                        int radius = (int) Math.sqrt(Math.pow(endX - startX, 2) + Math.pow(endY - startY, 2));
                        g.drawOval(x - radius, y - radius, 2 * radius, 2 * radius);
                        String fColor = "";
                        if (fill) {
                            g.setColor(new Color(fillR, fillG, fillB, 255));
                            fColor = String.valueOf(" rgba(" + fillR + "," + fillG + "," + fillB + "," + 255 + ")");
                        } else {
                            g.setColor(new Color(0, 0, 0, 0));
                            fColor = String.valueOf(" rgba(" + fillR + "," + fillG + "," + fillB + ",0)");
                        }
                        g.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);
                        String lColor = String.valueOf(" rgb(" + lineR + "," + lineG + "," + lineB + ")");
                        this.pc.drawCircle(x, y, radius, lColor, fColor);
                    }
                    break;
                case "Polígono regular":
                    if (painting) {
                        int radius = (int) Math.sqrt(Math.pow(endX - startX, 2) + Math.pow(endY - startY, 2));
                        drawRegularPolygon(g, x, y, sides, radius, endX, endY);
                    }
                    break;
                case "Polígono irregular":
                    if (!(sides <= 0)) {
                        drawingIrregular = true;
                        clickedPoints.add(new Point(evt.getX(), evt.getY()));
                        drawIrregularPolygon(g);
                        if (clickedPoints.size() == sides) {
                            endIrregular(g);
                        }
                    }
                    break;
            }
        }
        painting = !painting;
    }//GEN-LAST:event_figureCanvasMouseClicked

    public void drawRegularPolygon(Graphics g, int x, int y, int sides, int radius, int endX, int endY) {
        double angleIncrement = 2 * Math.PI / sides;
        int[] pointsX = new int[sides];
        int[] pointsY = new int[sides];
        //double distance = Math.sqrt(Math.pow(endX - x, 2) + Math.pow(endY - y, 2));
        double angle = Math.atan2(endY - y, endX - x);
        double startAngle = angle - Math.PI / 2;
        for (int i = 0; i < sides; i++) {
            pointsX[i] = (int) (x + radius * Math.cos(startAngle));
            pointsY[i] = (int) (y + radius * Math.sin(startAngle));
            startAngle += angleIncrement;
        }
        String fColor = "";
        if (fill) {
            g.setColor(new Color(fillR, fillG, fillB, 255));
            fColor = String.valueOf(" rgba(" + fillR + "," + fillG + "," + fillB + "," + 255 + ")");
        } else {
            g.setColor(new Color(0, 0, 0, 0));
            fColor = String.valueOf(" rgba(" + fillR + "," + fillG + "," + fillB + ",0)");
        }
        String lColor = String.valueOf(" rgb(" + lineR + "," + lineG + "," + lineB + ")");
        this.pc.drawPolygon(pointsX, pointsY, lColor, fColor, this.sides);
        g.fillPolygon(pointsX, pointsY, sides);
        g.setColor(new Color(lineR, lineG, lineB));
        g.drawPolygon(pointsX, pointsY, sides);
    }

    public void drawIrregularPolygon(Graphics g) {
        g.setColor(new Color(lineR, lineG, lineB));
        for (int i = 0; i < clickedPoints.size() - 1; i++) {
            Point start = clickedPoints.get(i);
            Point end = clickedPoints.get(i + 1);
            g.drawLine(start.x, start.y, end.x, end.y);
        }
    }

    public void endIrregular(Graphics g) {
        int[] xPoints = new int[clickedPoints.size()];
        int[] yPoints = new int[clickedPoints.size()];
        String fColor;
        String lColor = String.valueOf(" rgb(" + lineR + "," + lineG + "," + lineB + ")");
        for (int i = 0; i < clickedPoints.size(); i++) {
            xPoints[i] = clickedPoints.get(i).x;
            yPoints[i] = clickedPoints.get(i).y;
        }
        if (fill) {
            g.setColor(new Color(fillR, fillG, fillB, 255));
            fColor = String.valueOf(" rgba(" + fillR + "," + fillG + "," + fillB + "," + 255 + ")");
            g.fillPolygon(xPoints, yPoints, clickedPoints.size());
        } else {
            fColor = String.valueOf(" rgba(" + fillR + "," + fillG + "," + fillB + ",0)");
        }
        g.setColor(new Color(lineR, lineG, lineB));
        g.drawPolygon(xPoints, yPoints, clickedPoints.size());
        pc.drawPolygon(xPoints, yPoints, lColor, fColor, sides);
        clickedPoints.clear();
    }

    private void lineRSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_lineRSliderStateChanged
        lineRField.setText(String.valueOf(lineRSlider.getValue()));
        lineR = lineRSlider.getValue();
    }//GEN-LAST:event_lineRSliderStateChanged

    private void fillRSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_fillRSliderStateChanged
        fillRField.setText(String.valueOf(fillRSlider.getValue()));
        fillR = fillRSlider.getValue();
    }//GEN-LAST:event_fillRSliderStateChanged

    private void lineGFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lineGFieldActionPerformed
        if (Integer.parseInt(lineGField.getText()) > 255) {
            lineGField.setText("255");
        }
        lineG = Integer.parseInt(lineGField.getText());
    }//GEN-LAST:event_lineGFieldActionPerformed

    private void lineGSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_lineGSliderStateChanged
        lineGField.setText(String.valueOf(lineGSlider.getValue()));
        lineG = lineGSlider.getValue();
    }//GEN-LAST:event_lineGSliderStateChanged

    private void lineBSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_lineBSliderStateChanged
        lineBField.setText(String.valueOf(lineBSlider.getValue()));
        lineB = lineBSlider.getValue();
    }//GEN-LAST:event_lineBSliderStateChanged

    private void fillGSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_fillGSliderStateChanged
        fillGField.setText(String.valueOf(fillGSlider.getValue()));
        fillG = fillGSlider.getValue();
    }//GEN-LAST:event_fillGSliderStateChanged

    private void fillBSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_fillBSliderStateChanged
        fillBField.setText(String.valueOf(fillBSlider.getValue()));
        fillB = fillBSlider.getValue();
    }//GEN-LAST:event_fillBSliderStateChanged

    private void figuresListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_figuresListValueChanged
        selectedFigure = figuresList.getSelectedValue();
        if ((selectedFigure == "Punto") || (selectedFigure == "Recta")) {
            notFill();
        } else {
            yesFill();
        }
        if ((selectedFigure == "Polígono regular") || (selectedFigure == "Polígono irregular")) {
            selectedPolygon();
        } else {
            notSelectedPolygon();
        }
    }//GEN-LAST:event_figuresListValueChanged

    private void lineRFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lineRFieldActionPerformed
        if (Integer.parseInt(lineRField.getText()) > 255) {
            lineRField.setText("255");
        }
        lineR = Integer.parseInt(lineRField.getText());
    }//GEN-LAST:event_lineRFieldActionPerformed

    private void lineBFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lineBFieldActionPerformed
        if (Integer.parseInt(lineBField.getText()) > 255) {
            lineBField.setText("255");
        }
        lineB = Integer.parseInt(lineBField.getText());
    }//GEN-LAST:event_lineBFieldActionPerformed

    private void fillRFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fillRFieldActionPerformed
        if (Integer.parseInt(fillRField.getText()) > 255) {
            fillRField.setText("255");
        }
        fillR = Integer.parseInt(fillRField.getText());
    }//GEN-LAST:event_fillRFieldActionPerformed

    private void fillGFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fillGFieldActionPerformed
        if (Integer.parseInt(fillGField.getText()) > 255) {
            fillGField.setText("255");
        }
        fillG = Integer.parseInt(fillGField.getText());
    }//GEN-LAST:event_fillGFieldActionPerformed

    private void fillBFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fillBFieldActionPerformed
        if (Integer.parseInt(fillBField.getText()) > 255) {
            fillBField.setText("255");
        }
        fillG = Integer.parseInt(fillGField.getText());
    }//GEN-LAST:event_fillBFieldActionPerformed

    private void fillCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fillCheckActionPerformed
        fill = !fill;
        fillChanged();
    }//GEN-LAST:event_fillCheckActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        painting = false;
        drawingIrregular = false;
        clickedPoints.clear();
        Graphics g = figureCanvas.getGraphics();
        g.setColor(figureCanvas.getBackground());
        g.fillRect(0, 0, figureCanvas.getWidth(), figureCanvas.getHeight());
        figureCanvas.repaint();
        this.pc.clearFigures();
    }//GEN-LAST:event_clearButtonActionPerformed

    private void generateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateButtonActionPerformed
        if (!drawingsList.isSelectionEmpty()) {
            String nombreSeleccionado = this.drawingsList.getSelectedValue();
            this.pc.generateSvgCode(nombreSeleccionado);
        }
    }//GEN-LAST:event_generateButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        String nombre = drawingField.getText().toUpperCase();
        if ((nombre.length() > 0) && (nombre.length() <= 20)) {
            this.pc.agregarDibujo(nombre);
            drawingField.setText("");
            updateDrawingModel();
        }
        painting = false;
        drawingIrregular = false;
        clickedPoints.clear();
        Graphics g = figureCanvas.getGraphics();
        g.setColor(figureCanvas.getBackground());
        g.fillRect(0, 0, figureCanvas.getWidth(), figureCanvas.getHeight());
        figureCanvas.repaint();
        this.pc.clearFigures();
    }//GEN-LAST:event_addButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        String nombre = drawingsList.getSelectedValue();
        drawingField.setText(nombre);
        if (nombre != null) {
            this.pc.eliminarDibujo(nombre);
            updateDrawingModel();
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void drawButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drawButtonActionPerformed
        String nombre = drawingsList.getSelectedValue();
        this.figuresToDraw = this.pc.getFiguresToDraw(nombre);
        Graphics g = figureCanvas.getGraphics();
        for (Object figura : figuresToDraw) {
            if (figura instanceof Recta recta) {
                int rLr = recta.lineR;
                int rLg = recta.lineG;
                int rLb = recta.lineB;
                int rSx = recta.startX;
                int rSy = recta.startY;
                int rEx = recta.endX;
                int rEy = recta.endY;
                g.setColor(new Color(rLr, rLg, rLb));
                g.drawLine(rSx, rSy, rEx, rEy);
            }
            if (figura instanceof Circunferencia circunferencia) {
                int cX = circunferencia.x;
                int cY = circunferencia.y;
                int cRadius = circunferencia.radius;
                int cLr = circunferencia.lineR;
                int cLg = circunferencia.lineG;
                int cLb = circunferencia.lineB;
                int cFr = circunferencia.fillR;
                int cFg = circunferencia.fillG;
                int cFb = circunferencia.fillB;
                int cFa = circunferencia.fillA;
                g.setColor(new Color(cLr, cLg, cLb));
                g.drawOval(cX - cRadius, cY - cRadius, 2 * cRadius, 2 * cRadius);
                g.setColor(new Color(cFr, cFg, cFb, cFa));
                g.fillOval(cX - cRadius, cY - cRadius, 2 * cRadius, 2 * cRadius);
            }
            if (figura instanceof Poligono poligono) {
                int[] pointsX = poligono.pointsX;
                int[] pointsY = poligono.pointsY;
                int pLr = poligono.lineR;
                int pLg = poligono.lineG;
                int pLb = poligono.lineB;
                int pFr = poligono.fillR;
                int pFg = poligono.fillG;
                int pFb = poligono.fillB;
                int pFa = poligono.fillA;
                int nPoints = poligono.nVertices;
                g.setColor(new Color(pLr,pLg,pLb));
                g.drawPolygon(pointsX, pointsY, nPoints);
                g.setColor(new Color(pFr,pFg,pFb,pFa));
                g.fillPolygon(pointsX, pointsY, nPoints);
            }
        }
    }//GEN-LAST:event_drawButtonActionPerformed

    public void fillChanged() {
        fillLabel.setVisible(fill);
        fillRSlider.setVisible(fill);
        fillGSlider.setVisible(fill);
        fillBSlider.setVisible(fill);
        fillRLabel.setVisible(fill);
        fillRField.setVisible(fill);
        fillGLabel.setVisible(fill);
        fillGField.setVisible(fill);
        fillBLabel.setVisible(fill);
        fillBField.setVisible(fill);
    }

    public void notFill() {
        fillCheck.setVisible(false);
    }

    public void yesFill() {
        fillCheck.setVisible(true);
    }

    public void selectedPolygon() {
        sidesLabel.setVisible(true);
        sidesSlider.setVisible(true);
        sidesField.setVisible(true);
    }

    public void notSelectedPolygon() {
        sidesLabel.setVisible(false);
        sidesSlider.setVisible(false);
        sidesField.setVisible(false);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new Vista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton drawButton;
    private javax.swing.JTextField drawingField;
    private javax.swing.JList<String> drawingsList;
    private java.awt.Canvas figureCanvas;
    private javax.swing.JLabel figuresLabel;
    private javax.swing.JList<String> figuresList;
    private javax.swing.JTextField fillBField;
    private javax.swing.JLabel fillBLabel;
    private javax.swing.JSlider fillBSlider;
    private javax.swing.JCheckBox fillCheck;
    private javax.swing.JTextField fillGField;
    private javax.swing.JLabel fillGLabel;
    private javax.swing.JSlider fillGSlider;
    private javax.swing.JLabel fillLabel;
    private javax.swing.JTextField fillRField;
    private javax.swing.JLabel fillRLabel;
    private javax.swing.JSlider fillRSlider;
    private javax.swing.JButton generateButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField lineBField;
    private javax.swing.JLabel lineBLabel;
    private javax.swing.JSlider lineBSlider;
    private javax.swing.JTextField lineGField;
    private javax.swing.JLabel lineGLabel;
    private javax.swing.JSlider lineGSlider;
    private javax.swing.JLabel lineLabel;
    private javax.swing.JTextField lineRField;
    private javax.swing.JLabel lineRLabel;
    private javax.swing.JSlider lineRSlider;
    private javax.swing.JTextField sidesField;
    private javax.swing.JLabel sidesLabel;
    private javax.swing.JSlider sidesSlider;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
