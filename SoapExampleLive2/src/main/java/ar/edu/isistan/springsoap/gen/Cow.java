//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2021.03.24 a las 05:26:55 PM ART 
//


package ar.edu.isistan.springsoap.gen;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para Cow complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Cow"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="electronic_id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="born_date" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="last_due_date" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;element name="number_of_deliveries" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="weight" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Cow", propOrder = {
    "id",
    "electronicId",
    "bornDate",
    "lastDueDate",
    "numberOfDeliveries",
    "weight"
})
public class Cow {

    protected int id;
    @XmlElement(name = "electronic_id")
    protected int electronicId;
    @XmlElement(name = "born_date", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar bornDate;
    @XmlElement(name = "last_due_date")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar lastDueDate;
    @XmlElement(name = "number_of_deliveries")
    protected int numberOfDeliveries;
    @XmlElement(required = true)
    protected BigDecimal weight;

    /**
     * Obtiene el valor de la propiedad id.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Obtiene el valor de la propiedad electronicId.
     * 
     */
    public int getElectronicId() {
        return electronicId;
    }

    /**
     * Define el valor de la propiedad electronicId.
     * 
     */
    public void setElectronicId(int value) {
        this.electronicId = value;
    }

    /**
     * Obtiene el valor de la propiedad bornDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getBornDate() {
        return bornDate;
    }

    /**
     * Define el valor de la propiedad bornDate.
     * 
     * @param date2
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setBornDate(XMLGregorianCalendar date2) {
        this.bornDate = date2;
    }

    /**
     * Obtiene el valor de la propiedad lastDueDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastDueDate() {
        return lastDueDate;
    }

    /**
     * Define el valor de la propiedad lastDueDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastDueDate(XMLGregorianCalendar value) {
        this.lastDueDate = value;
    }

    /**
     * Obtiene el valor de la propiedad numberOfDeliveries.
     * 
     */
    public int getNumberOfDeliveries() {
        return numberOfDeliveries;
    }

    /**
     * Define el valor de la propiedad numberOfDeliveries.
     * 
     */
    public void setNumberOfDeliveries(int value) {
        this.numberOfDeliveries = value;
    }

    /**
     * Obtiene el valor de la propiedad weight.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getWeight() {
        return weight;
    }

    /**
     * Define el valor de la propiedad weight.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setWeight(BigDecimal value) {
        this.weight = value;
    }

}
