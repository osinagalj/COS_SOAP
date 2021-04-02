//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2021.04.01 a las 07:16:11 PM ART 
//


package ar.edu.isistan.springsoap.gen;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Herd_output complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Herd_output"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="location" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="average_bcs" type="{http://www.w3.org/2001/XMLSchema}float"/&gt;
 *         &lt;element name="cows" type="{http://www.isistan.edu.ar/springsoap/gen}Cow_output" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Herd_output", propOrder = {
    "id",
    "location",
    "averageBcs",
    "cows"
})
public class HerdOutput {

    protected long id;
    @XmlElement(required = true)
    protected String location;
    @XmlElement(name = "average_bcs")
    protected float averageBcs;
    @XmlElement(required = true)
    protected List<CowOutput> cows;

    /**
     * Obtiene el valor de la propiedad id.
     * 
     */
    public long getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     * 
     */
    public void setId(long value) {
        this.id = value;
    }

    /**
     * Obtiene el valor de la propiedad location.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocation() {
        return location;
    }

    /**
     * Define el valor de la propiedad location.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocation(String value) {
        this.location = value;
    }

    /**
     * Obtiene el valor de la propiedad averageBcs.
     * 
     */
    public float getAverageBcs() {
        return averageBcs;
    }

    /**
     * Define el valor de la propiedad averageBcs.
     * 
     */
    public void setAverageBcs(float value) {
        this.averageBcs = value;
    }

    /**
     * Gets the value of the cows property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cows property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCows().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CowOutput }
     * 
     * 
     */
    public List<CowOutput> getCows() {
        if (cows == null) {
            cows = new ArrayList<CowOutput>();
        }
        return this.cows;
    }
	public void setCows(List<CowOutput> cows2) {
		this.cows = cows2;
		
	}
	

    

}
