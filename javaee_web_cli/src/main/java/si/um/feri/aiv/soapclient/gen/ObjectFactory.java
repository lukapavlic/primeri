
package si.um.feri.aiv.soapclient.gen;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the si.um.feri.aiv.soapclient.gen package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _DodajOseboResponse_QNAME = new QName("http://soap.aiv.feri.um.si/", "dodajOseboResponse");
    private final static QName _VrniVseOsebe_QNAME = new QName("http://soap.aiv.feri.um.si/", "vrniVseOsebe");
    private final static QName _DodajOsebo_QNAME = new QName("http://soap.aiv.feri.um.si/", "dodajOsebo");
    private final static QName _VrniVseOsebeResponse_QNAME = new QName("http://soap.aiv.feri.um.si/", "vrniVseOsebeResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: si.um.feri.aiv.soapclient.gen
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DodajOsebo }
     * 
     */
    public DodajOsebo createDodajOsebo() {
        return new DodajOsebo();
    }

    /**
     * Create an instance of {@link DodajOseboResponse }
     * 
     */
    public DodajOseboResponse createDodajOseboResponse() {
        return new DodajOseboResponse();
    }

    /**
     * Create an instance of {@link VrniVseOsebe }
     * 
     */
    public VrniVseOsebe createVrniVseOsebe() {
        return new VrniVseOsebe();
    }

    /**
     * Create an instance of {@link VrniVseOsebeResponse }
     * 
     */
    public VrniVseOsebeResponse createVrniVseOsebeResponse() {
        return new VrniVseOsebeResponse();
    }

    /**
     * Create an instance of {@link Oseba }
     * 
     */
    public Oseba createOseba() {
        return new Oseba();
    }

    /**
     * Create an instance of {@link Kontakt }
     * 
     */
    public Kontakt createKontakt() {
        return new Kontakt();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DodajOseboResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.aiv.feri.um.si/", name = "dodajOseboResponse")
    public JAXBElement<DodajOseboResponse> createDodajOseboResponse(DodajOseboResponse value) {
        return new JAXBElement<DodajOseboResponse>(_DodajOseboResponse_QNAME, DodajOseboResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VrniVseOsebe }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.aiv.feri.um.si/", name = "vrniVseOsebe")
    public JAXBElement<VrniVseOsebe> createVrniVseOsebe(VrniVseOsebe value) {
        return new JAXBElement<VrniVseOsebe>(_VrniVseOsebe_QNAME, VrniVseOsebe.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DodajOsebo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.aiv.feri.um.si/", name = "dodajOsebo")
    public JAXBElement<DodajOsebo> createDodajOsebo(DodajOsebo value) {
        return new JAXBElement<DodajOsebo>(_DodajOsebo_QNAME, DodajOsebo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VrniVseOsebeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.aiv.feri.um.si/", name = "vrniVseOsebeResponse")
    public JAXBElement<VrniVseOsebeResponse> createVrniVseOsebeResponse(VrniVseOsebeResponse value) {
        return new JAXBElement<VrniVseOsebeResponse>(_VrniVseOsebeResponse_QNAME, VrniVseOsebeResponse.class, null, value);
    }

}
