/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mortalkombatbversion;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;


public class ImageFixer {
    
    
    
    public ImageFixer(){}
    
    public ImageIcon getScaledImage(Image srcImg){

        ImageIcon resizedImg = new ImageIcon(srcImg.getScaledInstance(180, 180,  java.awt.Image.SCALE_SMOOTH));

    return  resizedImg;
    
}
    
    
    
}

