package buoi4.baihat;

import buoi4.model.BaiHat;
import buoi4.service.BaiHatService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BaiHatTest {
    private BaiHatService service;

    @BeforeEach
    public void setup() {
        service = new BaiHatService();
    }

    @Test
    public void testAddSingleBaiHat() {
        BaiHat bh = new BaiHat("1", "Song A", "Singer X", 180, "Composer Y");
        service.add(bh);
        Assertions.assertEquals(1, service.getAll().size());
    }

    @Test
    public void testAddMultipleBaiHat() {
        service.add(new BaiHat("1", "Song A", "Singer X", 180, "Composer Y"));
        service.add(new BaiHat("2", "Song B", "Singer Y", 200, "Composer Z"));
        Assertions.assertEquals(2, service.getAll().size());
    }

    @Test
    public void testAddDuplicateIdBaiHat() {
        service.add(new BaiHat("1", "Song A", "Singer X", 180, "Composer Y"));
        service.add(new BaiHat("1", "Song B", "Singer Y", 200, "Composer Z"));
        Assertions.assertEquals(2, service.getAll().size());
    }

    @Test
    public void testAddNullBaiHat() {
        Assertions.assertThrows(NullPointerException.class, () -> service.add(null));
    }

    @Test
    public void testSearchBaiHatValid() {
        service.add(new BaiHat("1", "Song A", "Singer X", 180, "Composer Y"));
        BaiHat result = service.search("1");
        Assertions.assertNotNull(result);
        Assertions.assertEquals("1", result.getId());
    }

    @Test
    public void testSearchBaiHatInvalid() {
        service.add(new BaiHat("1", "Song A", "Singer X", 180, "Composer Y"));
        BaiHat result = service.search("2");
        Assertions.assertNull(result);
    }

    @Test
    public void testSearchBaiHatEmptyList() {
        BaiHat result = service.search("1");
        Assertions.assertNull(result);
    }

    @Test
    public void testUpdateBaiHatValid() {
        service.add(new BaiHat("1", "Song A", "Singer X", 180, "Composer Y"));
        service.update(new BaiHat("1", "Song A Updated", "Singer X", 190, "Composer Y"), "1");
        Assertions.assertEquals("Song A Updated", service.search("1").getTen());
    }

    @Test
    public void testUpdateBaiHatInvalid() {
        service.add(new BaiHat("1", "Song A", "Singer X", 180, "Composer Y"));
        service.update(new BaiHat("2", "Song B", "Singer Y", 200, "Composer Z"), "2");
        Assertions.assertEquals("Song A", service.search("1").getTen());
    }

    @Test
    public void testDeleteBaiHatValid() {
        service.add(new BaiHat("1", "Song A", "Singer X", 180, "Composer Y"));
        service.delete("1");
        Assertions.assertNull(service.search("1"));
    }

    @Test
    public void testDeleteBaiHatInvalid() {
        service.add(new BaiHat("1", "Song A", "Singer X", 180, "Composer Y"));
        service.delete("2");
        Assertions.assertEquals(1, service.getAll().size());
    }

    @Test
    public void testDeleteBaiHatFromEmptyList() {
        service.delete("1");
        Assertions.assertEquals(0, service.getAll().size());
    }

    @Test
    public void testAddBaiHatWithEmptyId() {
        BaiHat bh = new BaiHat("", "Song A", "Singer X", 180, "Composer Y");
        service.add(bh);
        Assertions.assertEquals(1, service.getAll().size());
    }

    @Test
    public void testSearchBaiHatWithEmptyId() {
        service.add(new BaiHat("", "Song A", "Singer X", 180, "Composer Y"));
        BaiHat result = service.search("");
        Assertions.assertNotNull(result);
    }

    @Test
    public void testUpdateBaiHatWithEmptyId() {
        service.add(new BaiHat("", "Song A", "Singer X", 180, "Composer Y"));
        service.update(new BaiHat("", "Updated Song", "Singer X", 200, "Composer Y"), "");
        Assertions.assertEquals("Updated Song", service.search("").getTen());
    }

    @Test
    public void testDeleteBaiHatWithEmptyId() {
        service.add(new BaiHat("", "Song A", "Singer X", 180, "Composer Y"));
        service.delete("");
        Assertions.assertEquals(0, service.getAll().size());
    }

    @Test
    public void testSearchBaiHatBoundaryCondition() {
        service.add(new BaiHat("99999", "Song A", "Singer X", 180, "Composer Y"));
        BaiHat result = service.search("99999");
        Assertions.assertNotNull(result);
        Assertions.assertEquals("99999", result.getId());
    }

    @Test
    public void testAddBaiHatWithLongName() {
        BaiHat bh = new BaiHat("1", "This is a very long song name that exceeds normal length", "Singer X", 180, "Composer Y");
        service.add(bh);
        Assertions.assertEquals(1, service.getAll().size());
    }
}
