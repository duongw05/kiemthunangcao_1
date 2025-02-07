package buoi3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import bai3.Profile;

public class bai5 {
    //bài 5
    @Test
    void testGetName() {
        Profile profile = new Profile("John Doe");
        Assertions.assertEquals("John Doe", profile.getName());

        Profile emptyProfile = new Profile(null);
        Assertions.assertThrows(NullPointerException.class, () -> emptyProfile.getName());
    }
}
