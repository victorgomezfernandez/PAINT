package paint;

import javax.swing.text.*;

public class onlyInt extends DocumentFilter {
    private static final int MAX_LENGTH = 3;

    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
        if (isValid(fb.getDocument(), offset, string.length(), string)) {
            super.insertString(fb, offset, string, attr);
        }
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        if (isValid(fb.getDocument(), offset, text.length() - length, text)) {
            super.replace(fb, offset, length, text, attrs);
        }
    }

    @Override
    public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
        super.remove(fb, offset, length);
    }

    private boolean isValid(Document doc, int offset, int changeInLength, String text) {
        // Verificar que el texto sea numérico
        if (!text.matches("\\d*")) {
            return false;
        }

        // Calcula la nueva longitud considerando reemplazo o inserción
        int newLength = doc.getLength() + changeInLength;
        return newLength <= MAX_LENGTH;
    }
}