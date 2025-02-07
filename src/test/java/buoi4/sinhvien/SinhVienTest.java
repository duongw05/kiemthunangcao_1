package buoi4.sinhvien;

import buoi4.model.SinhVien;
import buoi4.service.SinhVienService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SinhVienTest {
    private SinhVienService service;

    @BeforeEach
    public void setup() {
        service = new SinhVienService();
    }

    @Test
    public void testAddSingleSinhVien() {
        SinhVien sv = new SinhVien(1, "Nguyen Van A", "12A1", "2023", "Toan");
        service.add(sv);
        Assertions.assertEquals(1, service.getAll().size());
    }

    @Test
    public void testAddMultipleSinhVien() {
        service.add(new SinhVien(1, "Nguyen Van A", "12A1", "2023", "Toan"));
        service.add(new SinhVien(2, "Le Thi B", "12A2", "2023", "Ly"));
        Assertions.assertEquals(2, service.getAll().size());
    }

    @Test
    public void testAddDuplicateIdSinhVien() {
        service.add(new SinhVien(1, "Nguyen Van A", "12A1", "2023", "Toan"));
        service.add(new SinhVien(1, "Le Thi B", "12A2", "2023", "Ly"));
        Assertions.assertEquals(2, service.getAll().size());
    }

    @Test
    public void testAddNullSinhVien() {
        Assertions.assertThrows(NullPointerException.class, () -> service.add(null));
    }

    @Test
    public void testSearchSinhVienValid() {
        service.add(new SinhVien(1, "Nguyen Van A", "12A1", "2023", "Toan"));
        SinhVien result = service.searchSinhVien(1);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(1, result.getMaSV());
    }

    @Test
    public void testSearchSinhVienInvalid() {
        service.add(new SinhVien(1, "Nguyen Van A", "12A1", "2023", "Toan"));
        SinhVien result = service.searchSinhVien(2);
        Assertions.assertNull(result);
    }

    @Test
    public void testSearchSinhVienEmptyList() {
        SinhVien result = service.searchSinhVien(1);
        Assertions.assertNull(result);
    }

    @Test
    public void testSearchSinhVienAfterAddingMultiple() {
        service.add(new SinhVien(1, "Nguyen Van A", "12A1", "2023", "Toan"));
        service.add(new SinhVien(2, "Le Thi B", "12A2", "2023", "Ly"));
        SinhVien result = service.searchSinhVien(2);
        Assertions.assertNotNull(result);
        Assertions.assertEquals("Le Thi B", result.getTenSV());
    }

    @Test
    public void testAddSinhVienNegativeId() {
        SinhVien sv = new SinhVien(-1, "Nguyen Van A", "12A1", "2023", "Toan");
        service.add(sv);
        Assertions.assertEquals(1, service.getAll().size());
    }

    @Test
    public void testSearchSinhVienNegativeId() {
        service.add(new SinhVien(1, "Nguyen Van A", "12A1", "2023", "Toan"));
        SinhVien result = service.searchSinhVien(-1);
        Assertions.assertNull(result);
    }

    @Test
    public void testAddSinhVienZeroId() {
        service.add(new SinhVien(0, "Nguyen Van A", "12A1", "2023", "Toan"));
        Assertions.assertEquals(1, service.getAll().size());
    }

    @Test
    public void testSearchSinhVienZeroId() {
        service.add(new SinhVien(0, "Nguyen Van A", "12A1", "2023", "Toan"));
        SinhVien result = service.searchSinhVien(0);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(0, result.getMaSV());
    }

    @Test
    public void testSearchSinhVienBoundaryCondition() {
        service.add(new SinhVien(99999, "Nguyen Van A", "12A1", "2023", "Toan"));
        SinhVien result = service.searchSinhVien(99999);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(99999, result.getMaSV());
    }

    @Test
    public void testAddSinhVienWithLongName() {
        SinhVien sv = new SinhVien(1, "Nguyen Van A B C D E F G H I J K", "12A1", "2023", "Toan");
        service.add(sv);
        Assertions.assertEquals(1, service.getAll().size());
    }

    @Test
    public void testSearchSinhVienAfterClearingList() {
        service.add(new SinhVien(1, "Nguyen Van A", "12A1", "2023", "Toan"));
        service.getAll().clear();
        SinhVien result = service.searchSinhVien(1);
        Assertions.assertNull(result);
    }
}
