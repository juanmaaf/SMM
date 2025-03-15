/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sm.jmaf.image;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import sm.image.BufferedImageOpAdapter;

/**
 * Clase para cambiar los colores de una imagen.
 * 
 * Esta clase implementa la interfaz BufferedImageOp y proporciona
 * funcionalidad para cambiar los colores de una imagen, reemplazando
 * un color por otro dentro de un umbral de diferencia.
 * 
 * @see java.awt.image.BufferedImageOp
 * @author juanmaaf
 */
public class CambiaColoresOp extends BufferedImageOpAdapter {
    private Color color1;
    private Color color2;
    private int umbral;

    /**
     * Crea una nueva instancia de CambiaColoresOp con los colores especificados.
     * 
     * @param C1 El primer color a ser reemplazado.
     * @param C2 El segundo color que reemplazará al primero.
     * @param umb El umbral de diferencia para considerar un color como el primero.
     */
    public CambiaColoresOp(Color C1, Color C2, int umb) {
        color1 = C1;
        color2 = C2;
        umbral = umb;
    }

    /**
     * Aplica el filtro de cambio de colores a una imagen.
     * 
     * @param src La imagen de origen.
     * @param dest La imagen de destino donde se aplicará el filtro.
     * @return La imagen de destino con los colores cambiados.
     * @throws NullPointerException si la imagen de origen es nula.
     */
    @Override
    public BufferedImage filter(BufferedImage src, BufferedImage dest) {
        if (src == null) {
            throw new NullPointerException("src image is null");
        }
        if (dest == null) {
            dest = createCompatibleDestImage(src, null);
        }
        WritableRaster srcRaster = src.getRaster();
        WritableRaster destRaster = dest.getRaster();

        float[] HSB = new float[3];
        int[] RGB = new int[3];

        float[] HSB_Color1 = Color.RGBtoHSB(color1.getRed(), color1.getGreen(), color1.getBlue(), null);
        float[] HSB_Color2 = Color.RGBtoHSB(color2.getRed(), color2.getGreen(), color2.getBlue(), null);

        for (int x = 0; x < src.getWidth(); x++) {
            for (int y = 0; y < src.getHeight(); y++) {
                srcRaster.getPixel(x, y, RGB);

                Color.RGBtoHSB(RGB[0], RGB[1], RGB[2], HSB);

                float distancia = Math.abs(HSB_Color1[0] * 360 - HSB[0] * 360);
                if (distancia > 180) {
                    distancia = 360.0f - distancia;
                }

                if (distancia <= umbral) {
                    HSB[0] = HSB_Color2[0];
                }

                int dest_RGB = Color.HSBtoRGB(HSB[0], HSB[1], HSB[2]);

                destRaster.setPixel(x, y, new int[]{(dest_RGB >> 16) & 0xFF, (dest_RGB >> 8) & 0xFF, dest_RGB & 0xFF});
            }
        }

        return dest;
    }
}
