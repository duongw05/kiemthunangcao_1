package buoi4.employee;

import buoi4.model.Employee;
import buoi4.service.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmployeeTest {
    private EmployeeService service;

    @BeforeEach
    public void setup() {
        service = new EmployeeService();
    }

    @Test
    public void testAddSingleEmployee() {
        Employee e = new Employee(1, "John", "Doe", "john.doe@example.com");
        service.add(e);
        Assertions.assertEquals(1, service.getAll().size());
    }

    @Test
    public void testAddMultipleEmployees() {
        service.add(new Employee(1, "John", "Doe", "john.doe@example.com"));
        service.add(new Employee(2, "Jane", "Smith", "jane.smith@example.com"));
        Assertions.assertEquals(2, service.getAll().size());
    }

    @Test
    public void testAddDuplicateIdEmployee() {
        service.add(new Employee(1, "John", "Doe", "john.doe@example.com"));
        service.add(new Employee(1, "Jane", "Smith", "jane.smith@example.com"));
        Assertions.assertEquals(2, service.getAll().size());
    }

    @Test
    public void testAddNullEmployee() {
        Assertions.assertThrows(NullPointerException.class, () -> service.add(null));
    }

    @Test
    public void testUpdateEmployeeValid() {
        service.add(new Employee(1, "John", "Doe", "john.doe@example.com"));
        service.update(new Employee(1, "Johnny", "Doe", "johnny.doe@example.com"), 1);
        Assertions.assertEquals("Johnny", service.getAll().get(0).getFirstName());
    }

    @Test
    public void testUpdateEmployeeInvalidId() {
        service.add(new Employee(1, "John", "Doe", "john.doe@example.com"));
        service.update(new Employee(2, "Jane", "Smith", "jane.smith@example.com"), 2);
        Assertions.assertEquals("John", service.getAll().get(0).getFirstName());
    }

    @Test
    public void testDeleteEmployeeValid() {
        service.add(new Employee(1, "John", "Doe", "john.doe@example.com"));
        service.delete(1);
        Assertions.assertEquals(0, service.getAll().size());
    }

    @Test
    public void testDeleteEmployeeInvalidId() {
        service.add(new Employee(1, "John", "Doe", "john.doe@example.com"));
        service.delete(2);
        Assertions.assertEquals(1, service.getAll().size());
    }

    @Test
    public void testSearchEmployeeValid() {
        service.add(new Employee(1, "John", "Doe", "john.doe@example.com"));
        Employee result = service.search(1);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(1, result.getId());
    }

    @Test
    public void testSearchEmployeeInvalid() {
        service.add(new Employee(1, "John", "Doe", "john.doe@example.com"));
        Employee result = service.search(2);
        Assertions.assertNull(result);
    }

    @Test
    public void testSearchEmployeeEmptyList() {
        Employee result = service.search(1);
        Assertions.assertNull(result);
    }

    @Test
    public void testAddEmployeeWithEmptyEmail() {
        Employee e = new Employee(1, "John", "Doe", "");
        service.add(e);
        Assertions.assertEquals(1, service.getAll().size());
    }

    @Test
    public void testUpdateEmployeeWithNewEmail() {
        service.add(new Employee(1, "John", "Doe", "john.doe@example.com"));
        service.update(new Employee(1, "John", "Doe", "johnny.doe@example.com"), 1);
        Assertions.assertEquals("johnny.doe@example.com", service.getAll().get(0).getEmail());
    }

    @Test
    public void testDeleteAllEmployees() {
        service.add(new Employee(1, "John", "Doe", "john.doe@example.com"));
        service.add(new Employee(2, "Jane", "Smith", "jane.smith@example.com"));
        service.getAll().clear();
        Assertions.assertEquals(0, service.getAll().size());
    }
}
