package pl.spring.core.services;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import pl.spring.data.model.Customer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.spring.data.repositories.CustomerRepository;
import pl.spring.dto.CustomerDTO;

import javax.servlet.ServletContext;
import javax.transaction.Transactional;
import java.util.LinkedList;

@Service
@Transactional
public class CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    ServletContext context;

    @Autowired
    //konstruktor
    public CustomerService(CustomerRepository customerRepository) {

        this.customerRepository = customerRepository;
    }

    //dodanie nowego klienta
    public Customer addCustomer (CustomerDTO customerDTO) {
        Customer customer = convertFromDTO(customerDTO);
        return customerRepository.save(customer);
    }

    //usunięcie klienta
    public void deleteCustomer(CustomerDTO customerDTO){
        Customer customer = convertFromDTO(customerDTO);
        customerRepository.delete(customer);
    }

    //zmiana dowolnych tabelek (jednej lub wielu) w bazie
    // dla istniejącego klienta (lub dodanie jak nie ma nic)
    public void editCustomer(CustomerDTO customerDTO){
        Customer customer = convertFromDTO(customerDTO);
        customerRepository.save(customer);
    }

    //pobranie pojedynczego klienta (znajduje po id)
    public CustomerDTO getSingleCustomer(Long id){
        Customer customer = customerRepository.findById(id).get();
        return convertOneCustomerToDTO(customer);
    }

    public CustomerDTO getSingleCustomer(String firstName, String lastName){
        Customer customer = customerRepository.findCustomerByFirstNameAndLastName(firstName, lastName);
        return convertOneCustomerToDTO(customer);
    }

    //pobranie listy wszystkich klientów
    public List<CustomerDTO> getAllCustomers(){
        return convertAllInfoToDTO(customerRepository.findAll());
    }

    //pobranie listy tylko umówionych klientów
    public List<CustomerDTO> getArrangedCustomers(){
        return convertAllInfoToDTO(customerRepository.findByVisitDateNotNull());
    }

    //pobranie listy tylko nie umówionych klientów
    public List<CustomerDTO> getNotArrangedCustomers(){
        return convertAllInfoToDTO(customerRepository.findByVisitDateIsNull());
    }

    //metoda pomocnicza
    //konwersja danych z obiektu DTO do encji (wiersza w tabelce)
    //potrzebne do zmian na bazie - dodawanie, usuwanie, edycja klienta
    private Customer convertFromDTO(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setId(customerDTO.getId());
        customer.setFirstName(customerDTO.getFirstName());
        customer.setLastName((customerDTO.getLastName()));
        customer.setTelephoneNumber(customerDTO.getTelephoneNumber());
        customer.setVisitDate(customerDTO.getVisitDate());
        customer.setVisitTime(customerDTO.getVisitTime());
        customer.setAssignedHairdresser(customerDTO.getAssignedHairdresser());
        customer.setInfo(customerDTO.getInfo());
        customer.setComments(customerDTO.getComments());
        return customer;
    }

    //metoda pomocnicza - konwersja listy klientów pobranej z bazy na liste obiektów DTO
    private List<CustomerDTO> convertAllInfoToDTO(List<Customer> customers) {
        List<CustomerDTO> customersDTOlist = new LinkedList<>();
        for (Customer customer : customers){
            CustomerDTO customerDTO = convertOneCustomerToDTO(customer);
            customersDTOlist.add(customerDTO);
        }
        return customersDTOlist;
    }


    //metoda pomocnicza - konwersja pojedynczego klienta z bazy na obiekt DTO
    private CustomerDTO convertOneCustomerToDTO(Customer customer){
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customer.getId());
        customerDTO.setFirstName(customer.getFirstName());
        customerDTO.setLastName(customer.getLastName());
        customerDTO.setTelephoneNumber(customer.getTelephoneNumber());
        customerDTO.setVisitDate(customer.getVisitDate());
        customerDTO.setVisitTime(customer.getVisitTime());
        customerDTO.setAssignedHairdresser(customer.getAssignedHairdresser());
        customerDTO.setInfo(customer.getInfo());
        customerDTO.setComments(customer.getComments());
        return customerDTO;
    }

    //metoda do generowania pdfa - faktury
    public ByteArrayInputStream customerBill(CustomerDTO customerDTO) {

        Customer customer1 = convertFromDTO(customerDTO);
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {

            BaseFont bf = BaseFont.createFont("c:/windows/fonts/arial.ttf",
                    BaseFont.CP1250, BaseFont.EMBEDDED);
            Font font = new Font(bf, 12);


            PdfPTable table = new PdfPTable(5);
            table.setWidthPercentage(80);
            table.setWidths(new int[]{1, 2, 3, 3, 2});
            table.setSpacingBefore(150);
            table.setSpacingAfter(30);

            //Font headFont = FontFactory.getFont(FontFactory.COURIER_BOLD);
            PdfPCell hcell;
            hcell = new PdfPCell(new Phrase("Id", font));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);


            hcell = new PdfPCell(new Phrase("Imię", font));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Nazwisko", font));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Data wystawienia", font));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Godzina", font));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            PdfPCell cell;

            cell = new PdfPCell(new Phrase(customer1.getId().toString().hashCode()));
            cell.setVerticalAlignment(Element.ALIGN_CENTER);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase(customer1.getFirstName()));
            cell.setPaddingLeft(5);
            cell.setVerticalAlignment(Element.ALIGN_CENTER);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase((customer1.getLastName())));
            cell.setVerticalAlignment(Element.ALIGN_CENTER);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setPaddingRight(5);
            table.addCell(cell);

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date currentDate = new Date();
            //dateFormat.format(currentDate);

            cell = new PdfPCell(new Phrase(String.valueOf(dateFormat.format(currentDate))));
            cell.setVerticalAlignment(Element.ALIGN_CENTER);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setPaddingRight(5);
            table.addCell(cell);

            Date currentTime = new Date(System.currentTimeMillis());
            DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

            cell = new PdfPCell(new Phrase(String.valueOf(timeFormat.format(currentTime))));
            cell.setVerticalAlignment(Element.ALIGN_CENTER);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setPaddingRight(5);
            table.addCell(cell);

            table.setSpacingBefore(190);
            table.setSpacingAfter(40);

            PdfWriter.getInstance(document, out);
            document.open();

            document.addTitle("Wystawiono nowy rachunek");
            document.addSubject("Using iText");
            document.addKeywords("Java, PDF, iText");
            document.addAuthor("Marcin");
            document.addCreator("Marcin");


            Paragraph paragraph = new Paragraph("Faktura");
            FontFactory.getFont(FontFactory.HELVETICA, 110);
            paragraph.setAlignment(Element.ALIGN_CENTER);
            paragraph.getExtraParagraphSpace();
            paragraph.setSpacingAfter(30);

            Paragraph paragraph2 = new Paragraph();
            Chapter chapter1 = new Chapter(paragraph2, 1);
            chapter1.setNumberDepth(0);
            Paragraph paragraph3 = new Paragraph();
            Section section1 = chapter1.addSection(paragraph3);
            Image image1 = Image.getInstance(context.getRealPath("/") +"\\sources\\images\\fryzapplogo.png");

            image1.setAlignment(11);
            image1.setSpacingBefore(10);
            image1.scaleToFit(500, 500);
            section1.add(image1);


            Paragraph paragraph4 = new Paragraph("Kwota do zaplaty: 18zl",
                    FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLD,
                            new CMYKColor(0, 255, 255, 17)));
            paragraph4.setAlignment(Element.ALIGN_RIGHT);
            paragraph4.getExtraParagraphSpace();
            paragraph4.setSpacingAfter(20);
            document.add(paragraph);
            document.add(image1);
            document.add(table);
            document.add(paragraph4);
            document.close();

        } catch (DocumentException ex) {

            Logger.getLogger(CustomerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return new ByteArrayInputStream(out.toByteArray());
    }
}