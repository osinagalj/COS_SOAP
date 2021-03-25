//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2021.03.25 a las 06:05:25 PM ART 
//


package ar.edu.isistan.springsoap.gen;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id_animal" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *         &lt;element name="bcs_threshold" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "idAnimal",
    "bcsThreshold"
})
@XmlRootElement(name = "postAnimalAlertRequest")
public class PostAnimalAlertRequest {

    @XmlElement(name = "id_animal", required = true)
    protected BigInteger idAnimal;
    @XmlElement(name = "bcs_threshold", required = true)
    protected BigInteger bcsThreshold;

    /**
     * Obtiene el valor de la propiedad idAnimal.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getIdAnimal() {
        return idAnimal;
    }

    /**
     * Define el valor de la propiedad idAnimal.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setIdAnimal(BigInteger value) {
        this.idAnimal = value;
    }

    /**
     * Obtiene el valor de la propiedad bcsThreshold.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getBcsThreshold() {
        return bcsThreshold;
    }

    /**
     * Define el valor de la propiedad bcsThreshold.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setBcsThreshold(BigInteger value) {
        this.bcsThreshold = value;
    }

}
