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
 *         &lt;element name="id_herd" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *         &lt;element name="cow" type="{http://www.isistan.edu.ar/springsoap/gen}Cow"/&gt;
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
    "idHerd",
    "cow"
})
@XmlRootElement(name = "postCowToHerdRequest")
public class PostCowToHerdRequest {

    @XmlElement(name = "id_herd", required = true)
    protected BigInteger idHerd;
    @XmlElement(required = true)
    protected Cow cow;

    /**
     * Obtiene el valor de la propiedad idHerd.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getIdHerd() {
        return idHerd;
    }

    /**
     * Define el valor de la propiedad idHerd.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setIdHerd(BigInteger value) {
        this.idHerd = value;
    }

    /**
     * Obtiene el valor de la propiedad cow.
     * 
     * @return
     *     possible object is
     *     {@link Cow }
     *     
     */
    public Cow getCow() {
        return cow;
    }

    /**
     * Define el valor de la propiedad cow.
     * 
     * @param value
     *     allowed object is
     *     {@link Cow }
     *     
     */
    public void setCow(Cow value) {
        this.cow = value;
    }

}
