/**
 * Created by Kachun on 10-2-2017.
 */

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class JaxbMain1 {
    public static void main(String[] args) {

        Customer customer = new Customer();
        customer.setName("Kachun");
        customer.setDateOfBirth("20-10-1993");
        Address address = new Address();
        address.setCity("Zeist");
        address.setStreet("Hoog Kanje 18");
        address.setZip("3708DJ");
        customer.setAddress(address);


        try {
            File file = new File("C:\\Users\\Kachun\\IdeaProjects\\IAC\\customer_address.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);

            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(customer, file);
            jaxbMarshaller.marshal(customer, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}
