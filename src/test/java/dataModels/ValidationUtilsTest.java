package dataModels;

import org.testng.annotations.Test;

import static dataModels.ValidationUtils.is01;
import static dataModels.ValidationUtils.isHexadecimal;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class ValidationUtilsTest {

    @Test
    public void isHexadecimalTest(){
        assertTrue(isHexadecimal("abc123"));
        assertFalse(isHexadecimal("abc123?"));
        assertFalse(isHexadecimal("qwe123"));
    }

    @Test
    public void is01Test(){
        assertTrue(is01("10001"));
        assertFalse(is01("012"));
        assertFalse(is01("1o1"));
    }
}
