package view;

import java.awt.*;
import javax.swing.ImageIcon;
import java.lang.NullPointerException;

/**
 * An abstract figure composed of an image
 *
 * @author Nassim Hmamouche
 */
public class ImageFigure extends Rectangle{
    /**
     * the shape image
     */
    private ImageIcon image;
    private final static Color transparent = new Color(0, 0, 0, 0);

    /**
     * Initialize the figure properties
     *
     */
    public ImageFigure(int width, int height, int posX, int posY, String directoryImage){
        super(width, height, posX, posY, transparent);
        try{ 
            image = new ImageIcon(new ImageIcon(directoryImage).getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
        }catch(NullPointerException e){ // gestion d'exceptions : fichier inexistant ou introuvable
            e.printStackTrace();
        }
    }

    /**
     * GETTER : Returns the image
     * 
     * @return the image
     */
    public ImageIcon getImage(){
        return this.image;
    }
}
