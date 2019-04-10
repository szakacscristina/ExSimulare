package Tests;

import Domain.EventValidator;
import Repository.InMemoryRepository;
import Service.EventService;
import org.junit.jupiter.api.Test;

import static groovy.util.GroovyTestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

class InvoiceServiceTest {
    private EventValidator validator = new EventValidator();
    private InMemoryRepository repository = new InMemoryRepository(validator);
    private EventService service = new EventService(repository);

    @Test
    void testsIfInsertAndGetAllWorksProperly() {
        service.insert("1", "fhb", "monday", "50.00", "14.00");
        assertEquals(32, service.getAll().get(0).getId());


        try {
            service.insert("1", "fhb", "monday", "50.00","14.00");
        } catch (RuntimeException rex) { assertTrue(true); }
    }
}