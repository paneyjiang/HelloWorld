package com.xmltoobject.test.com.xmltoobject.test;



import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.kedou.com/exceptionProcessers/}excludes" minOccurs="0"/>
 *         &lt;element ref="{http://www.kedou.com/exceptionProcessers/}processer" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "excludes",
    "processer"
})
@XmlRootElement(name = "exceptionProcessers")
public class ExceptionProcessers {

    protected Excludes excludes;
    protected List<Processer> processer;

    /**
     * Gets the value of the excludes property.
     * 
     * @return
     *     possible object is
     *     {@link Excludes }
     *     
     */
    public Excludes getExcludes() {
        return excludes;
    }

    /**
     * Sets the value of the excludes property.
     * 
     * @param value
     *     allowed object is
     *     {@link Excludes }
     *     
     */
    public void setExcludes(Excludes value) {
        this.excludes = value;
    }

    /**
     * Gets the value of the processer property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the processer property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProcesser().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Processer }
     * 
     * 
     */
    public List<Processer> getProcesser() {
        if (processer == null) {
            processer = new ArrayList<Processer>();
        }
        return this.processer;
    }

}
