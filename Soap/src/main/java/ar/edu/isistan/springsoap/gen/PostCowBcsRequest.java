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
 *         &lt;element name="herd" type="{http://www.isistan.edu.ar/springsoap/gen}CowBcs_input"/&gt;
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
    "herd"
})
@XmlRootElement(name = "postCowBcsRequest")
public class PostCowBcsRequest {

    @XmlElement(required = true)
    protected CowBcsInput herd;

    /**
     * Obtiene el valor de la propiedad herd.
     * 
     * @return
     *     possible object is
     *     {@link CowBcsInput }
     *     
     */
    public CowBcsInput getHerd() {
        return herd;
    }

    /**
     * Define el valor de la propiedad herd.
     * 
     * @param value
     *     allowed object is
     *     {@link CowBcsInput }
     *     
     */
    public void setHerd(CowBcsInput value) {
        this.herd = value;
    }

}
