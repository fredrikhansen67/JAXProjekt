package Personell;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductToXmlTest {
	private Product product;
	@BeforeEach
	void setUp() throws Exception {
		ArrayList al = new ArrayList();
        long l = 10;
        Long longId = new Long(l);
        User user = new User(longId, "John", "john@ankeborg.com");
        al.add(new User(longId, "John", "john@ankeborg.com"));
        al.add(new User(longId, "Peter", "peter@ankeborg.com"));
        product = new Product("PO1", "Spring Guru Mug", "https://springframework.guru/wp-content/uploads/2015/04/spring_framework_guru_shirt-rf412049699c14ba5b68bb1c09182bfa2_8nax2_512.jpg", new BigDecimal(18.95), al);  
	}

	@AfterEach
	void tearDown() throws Exception {
		product = null;
	}

	@Test
    public void testObjectToXml() throws JAXBException, FileNotFoundException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Product.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(product, new File("product.xml"));
        marshaller.marshal(product, System.out);
    }

}
