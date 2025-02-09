package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    private InvoiceDao invoiceDao;

    @Test
    void testInvoiceDaoSave() {
        //given
        Product product1 = new Product("product1");
        Product product2 = new Product("product2");
        Product product3 = new Product("product3");

        Item item1 = new Item(product1, new BigDecimal(15), 10);
        Item item2 = new Item(product2, new BigDecimal(5), 23);
        Item item3 = new Item(product3, new BigDecimal(30), 8);

        product1.getItems().add(item1);
        product2.getItems().add(item2);
        product3.getItems().add(item3);

        Invoice invoice = new Invoice("FV0001");
        item1.setInvoice(invoice);
        item2.setInvoice(invoice);
        item3.setInvoice(invoice);
        invoice.getItems().add(item1);
        invoice.getItems().add(item2);
        invoice.getItems().add(item3);

        //when
        invoiceDao.save(invoice);
        int id = invoice.getId();
        Invoice invoiceId = invoiceDao.findById(id).orElseThrow(
                () -> new RuntimeException("Invoice not found in database")
        );
        int invoiceIdContains3Items = invoiceId.getItems().size();
        String invoiceIdNumber = invoiceId.getNumber();
        Product product1Id = invoiceId.getItems().get(0).getProduct();
        Product product2Id = invoiceId.getItems().get(1).getProduct();
        Product product3Id = invoiceId.getItems().get(2).getProduct();
        Item item1Id = invoiceId.getItems().get(0);
        Item item2Id = invoiceId.getItems().get(1);
        Item item3Id = invoiceId.getItems().get(2);


        //then
        assertNotEquals(0, id);
        assertEquals(3, invoiceIdContains3Items);
        assertEquals("FV0001", invoiceIdNumber);
        assertEquals("product1", product1Id.getName());
        assertEquals("product2", product2Id.getName());
        assertEquals("product3", product3Id.getName());
        assertEquals(15, item1Id.getPrice().intValue());
        assertEquals(5, item2Id.getPrice().intValue());
        assertEquals(30, item3Id.getPrice().intValue());
        assertEquals(10, item1Id.getQuantity());
        assertEquals(23, item2Id.getQuantity());
        assertEquals(8, item3Id.getQuantity());

        //cleanUp
        invoiceDao.deleteById(id);
    }
}
