/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sm.jmaf.image;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import sm.image.BufferedImageOpAdapter;

/**
 * Clase para aplicar el efecto de posterización a una imagen.
 * 
 * Esta clase implementa la interfaz BufferedImageOp y proporciona
 * funcionalidad para reducir el número de niveles de color en una imagen,
 * produciendo un efecto de posterización.
 * 
 * @see java.awt.image.BufferedImageOp
 * @author juanmaaf
 */
public class PosterizarOp extends BufferedImageOpAdapter {
    private int niveles;

    /**
     * Crea una nueva instancia de PosterizarOp con el número de niveles especificado.
     * 
     * @param niveles El número de niveles de color para aplicar el efecto de posterización.
     */
    public PosterizarOp(int niveles) {
        this.niveles = niveles;
    }

    /**
     * Aplica el filtro de posterización a una imagen.
     * 
     * @param src La imagen de origen.
     * @param dest La imagen de destino donde se aplicará el filtro.
     * @return La imagen de destino con el efecto de posterización aplicado.
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
        int sample;

        float K = 256.0f / niveles;

        for (int x = 0; x < src.getWidth(); x++) {
            for (int y = 0; y < src.getHeight(); y++) {
                for (int band = 0; band < srcRaster.getNumBands(); band++) {
                    sample = srcRaster.getSample(x, y, band);
                    sample = (int) (K * (int) (sample / K));
                    destRaster.setSample(x, y, band, sample);
                }
            }
        }
        return dest;
    }
}