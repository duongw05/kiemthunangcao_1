package buoi4.oto;

import buoi4.model.XeOto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import buoi4.service.OtoService;

public class XeOtoTest {
    OtoService service = new OtoService();

    @BeforeEach
    public void setup() {
        service = new OtoService();
    }

    @Test
    public void testAddValid() {
        XeOto xe = new XeOto(1, "MayBack", 1000f, "Khong");
        service.addXeOto(xe);
        Assertions.assertEquals(1, service.getAll().size());
    }

    @Test
    public void updateValid() {
        XeOto xe = new XeOto(1, "MayBack" , 1000f , "Khong");
        service.addXeOto(xe);
        XeOto xe1 = new XeOto(1, "MayBack" , 1000000f , "Khong");
        service.updateXeOto(xe1, 1);
        Assertions.assertEquals(1000000f, service.getAll().get(0).getGia());
    }

    @Test
    public void deleteValid() {
        XeOto xe = new XeOto(1, "MayBack" , 1000f , "Khong");
        service.addXeOto(xe);
        int sizeBefore = service.getAll().size();
        service.deleteOto(1);
        int sizeAfter = service.getAll().size();
        Assertions.assertEquals(sizeBefore - 1, sizeAfter);
    }

    @Test
    public void deleteInValid() {
        XeOto xe = new XeOto(1, "MayBack" , 1000f , "Khong");
        service.addXeOto(xe);
        int sizeBefore = service.getAll().size();
        service.deleteOto(1);
        int sizeAfter = service.getAll().size();
        Assertions.assertEquals(sizeBefore , sizeAfter);
    }

    @Test
    public void testSearchXeOtoValid() {
        XeOto xe = new XeOto(1, "MayBack" , 1000f , "Khong");
        service.addXeOto(xe);

        XeOto foundXeOTO = service.searchXeOTO(1);

        Assertions.assertEquals(1, foundXeOTO.getId());
    }

    @Test
    public void testSearchXeOtoInValid() {
        XeOto xe = new XeOto(1, "MayBack" , 1000f , "Khong");
        service.addXeOto(xe);

        XeOto foundXeOTO = service.searchXeOTO(1);

        Assertions.assertEquals(2, foundXeOTO.getId());
    }
}
