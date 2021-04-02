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
 * <p>Clase Java para CowBcs_input complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="CowBcs_input"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cow_id" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="cc" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CowBcs_input", propOrder = {
    "cowId",
    "cc"
})
public class CowBcsInput {

    @XmlElement(name = "cow_id")
    protected long cowId;
    protected int cc;

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
     * Obtiene el valor de la propiedad cc.
     * 
     */
    public int getCc() {
        return cc;
    }

    /**
     * Define el valor de la propiedad cc.
     * 
     */
    public void setCc(int value) {
        this.cc = value;
    }

}
