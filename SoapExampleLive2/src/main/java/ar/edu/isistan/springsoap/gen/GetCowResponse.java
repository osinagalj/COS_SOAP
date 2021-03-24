//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2021.03.24 a las 05:26:55 PM ART 
//


package ar.edu.isistan.springsoap.gen;

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
    "cow"
})
@XmlRootElement(name = "getCowResponse")
public class GetCowResponse {

    @XmlElement(required = true)
    protected Cow cow;

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
