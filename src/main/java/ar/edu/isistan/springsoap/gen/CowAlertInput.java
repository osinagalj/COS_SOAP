//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2021.04.01 a las 07:16:11 PM ART 
//


package ar.edu.isistan.springsoap.gen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para CowAlert_input complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="CowAlert_input"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cow_id" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="bcs_threshold_min" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="bcs_threshold_max" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CowAlert_input", propOrder = {
    "cowId",
    "bcsThresholdMin",
    "bcsThresholdMax"
})
public class CowAlertInput {

    @XmlElement(name = "cow_id")
    protected long cowId;
    @XmlElement(name = "bcs_threshold_min")
    protected int bcsThresholdMin;
    @XmlElement(name = "bcs_threshold_max")
    protected int bcsThresholdMax;

    /**
     * Obtiene el valor de la propiedad cowId.
     * 
     */
    public long getCowId() {
        return cowId;
    }

    /**
     * Define el valor de la propiedad cowId.
     * 
     */
    public void setCowId(long value) {
        this.cowId = value;
    }

    /**
     * Obtiene el valor de la propiedad bcsThresholdMin.
     * 
     */
    public int getBcsThresholdMin() {
        return bcsThresholdMin;
    }

    /**
     * Define el valor de la propiedad bcsThresholdMin.
     * 
     */
    public void setBcsThresholdMin(int value) {
        this.bcsThresholdMin = value;
    }

    /**
     * Obtiene el valor de la propiedad bcsThresholdMax.
     * 
     */
    public int getBcsThresholdMax() {
        return bcsThresholdMax;
    }

    /**
     * Define el valor de la propiedad bcsThresholdMax.
     * 
     */
    public void setBcsThresholdMax(int value) {
        this.bcsThresholdMax = value;
    }

}
