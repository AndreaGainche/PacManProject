package view;

import java.awt.*;

/**
 * A text which can be displayed to a canvas
 *
 * @inv textSize > 0 && position(x,y) with x>=0 and y>=0 && text not null
 * @author Nassim Hmamouche
 */
public class TextFigure extends Rectangle{
    private int size;
    private int[] position;
    private String text;
    private final static Color transparent = new Color(0, 0, 0, 0);

    /**
     * Initialize the figure properties
     *
     */
    public TextFigure(int size, int posX, int posY, String text){
        super(text.length(), 10, posX, posY, transparent);
        this.size = size;
        this.position = new int[]{position[0], position[1]};
        this.text = text;
        textInvariant();
    }

    /**
     * GETTER : Returns the position
     *
     * @return array of 2 int : position on X-axis and Y-axis
     */
    public int[] getPosition(){
        return new int[]{position[0], position[1]};
    }
    /**
     * GETTER : Returns the text size
     * 
     * @return int : size
     */
    public int getSize(){
        return size;
    }
    /**
     * GETTER : Returns the text content
     * 
     * @return String : text
     */
    public String getText(){
        return text;
    }

    /**
     * Verifies if the class invariant is respected
     */
    public void textInvariant(){
        assert this.getPosition()[0]>=0 && this.getPosition()[1]>=0 && this.getSize()>0 && this.getText()!="" : "Texte invalide!";
    }
}
