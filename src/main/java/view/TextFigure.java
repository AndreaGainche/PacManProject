package view;

import java.awt.*;

/**
 * A text which can be displayed to a canvas
 *
 * @inv textSize > 0 && position(x,y) with x>=0 and y>=0 && text not null
 * @author Nassim Hmamouche
 */
public class TextFigure extends Rectangle{
    private String text;
    private final static Color transparent = new Color(0, 0, 0, 0);

    /**
     * Initialize the figure properties
     *
     */
    public TextFigure(int height, int posX, int posY, String text){
        super(text.length(), height, posX, posY, transparent);
        this.text = text;
        textInvariant();
    }
    /**
     * GETTER : Returns the text content
     * 
     * @return String : text
     */
    public String getText(){
        return this.text;
    }
    /**
     * SETTER : Edit the text content
     *
     * @param text
     */
    public void setText(String text){
        this.text = text;
        textInvariant();
    }

    /**
     * Checks if the class invariant is respected
     */
    public void textInvariant(){
        assert this.getPosition()[0]>=0 && this.getPosition()[1]>=0 && this.getHeight()>0 && this.getText()!="" : "Texte invalide!";
    }
}
