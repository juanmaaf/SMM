/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sm.jmaf.image;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import sm.image.BufferedImageOpAdapter;

/**
 * Clase para resaltar el color rojo en una imagen.
 * 
 * Esta clase implementa la interfaz BufferedImageOp y proporciona
 * funcionalidad para resaltar el color rojo en una imagen, convirtiendo
 * los píxeles que contienen predominantemente rojo en color, y los
 * demás píxeles en escala de grises.
 * 
 * @see java.awt.image.BufferedImageOp
 * @author juanmaaf
 */
public class RojoOp extends BufferedImageOpAdapter {
    private int umbral;

    /**
     * Crea una nueva instancia de RojoOp con el umbral especificado.
     * 
     * @param umbral El umbral para determinar si un píxel es predominantemente rojo.
     */
    public RojoOp(int umbral) {
        this.umbral = umbral;
    }

    /**
     * Aplica el filtro de resaltado de rojo a una imagen.
     * 
     * @param src La imagen de origen.
     * @param dest La imagen de destino donde se aplicará el filtro.
     * @return La imagen de destino con el efecto de resaltado de rojo aplicado.
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
        int[] pixelComp = new int[srcRaster.getNumBands()];
        int[] pixelCompDest = new int[srcRaster.getNumBands()];
        for (int x = 0; x < src.getWidth(); x++) {
            for (int y = 0; y < src.getHeight(); y++) {
                srcRaster.getPixel(x, y, pixelComp);

                // Obtener los componentes individuales de RGB
                int r = pixelComp[0];
                int g = pixelComp[1];
                int b = pixelComp[2];

                // Verificar si el pixel es predominantemente rojo
                if (r - g - b > umbral) {
                    // Se mantiene el color original
                    pixelCompDest[0] = r;
                    pixelCompDest[1] = g;
                    pixelCompDest[2] = b;
                } else {
                    // Convertir a escala de grises
                    int gris = (r + g + b) / 3;
                    pixelCompDest[0] = gris;
                    pixelCompDest[1] = gris;
                    pixelCompDest[2] = gris;
                }
                
                destRaster.setPixel(x, y, pixelCompDest);
            }
        }
        return dest;
    }
}
