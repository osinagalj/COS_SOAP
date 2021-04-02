//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2021.04.01 a las 07:16:11 PM ART 
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
 * <p>Clase Java para Cow_output complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Cow_output"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="herd_id" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="electronic_id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="born_date" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="last_due_date" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;element name="number_of_deliveries" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="weight" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="last_bcs" type="{http://www.isistan.edu.ar/springsoap/gen}CowBcs_output" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Cow_output", propOrder = {
    "id",
    "herdId",
    "electronicId",
    "bornDate",
    "lastDueDate",
    "numberOfDeliveries",
    "weight",
    "lastBcs"
})
public class CowOutput {

    protected long id;
    @XmlElement(name = "herd_id")
    protected long herdId;
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
    @XmlElement(name = "last_bcs")
    protected CowBcsOutput lastBcs;

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
     * Obtiene el valor de la propiedad herdId.
     * 
     */
    public long getHerdId() {
        return herdId;
    }

    /**
     * Define el valor de la propiedad herdId.
     * 
     */
    public void setHerdId(long value) {
        this.herdId = value;
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
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setBornDate(XMLGregorianCalendar value) {
        this.bornDate = value;
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

    /**
     * Obtiene el valor de la propiedad lastBcs.
     * 
     * @return
     *     possible object is
     *     {@link CowBcsOutput }
     *     
     */
    public CowBcsOutput getLastBcs() {
        return lastBcs;
    }

    /**
     * Define el valor de la propiedad lastBcs.
     * 
     * @param value
     *     allowed object is
     *     {@link CowBcsOutput }
     *     
     */
    public void setLastBcs(CowBcsOutput value) {
        this.lastBcs = value;
    }

}
