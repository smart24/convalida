package convalida.validators;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * @author Wellington Costa on 01/11/2017.
 */
public class LengthValidatorTest extends BaseTest {

    @Test public void textLengthLessThan5() {
        LengthValidator validator = new LengthValidator(mockEditText, 5, 0, errorMessage, true);
        when(mockEditText.getText().toString()).thenReturn("test");
        assertEquals(validator.validate(), false);
    }

    @Test public void textLengthGreaterThan5() {
        LengthValidator validator = new LengthValidator(mockEditText, 5, 0, errorMessage, true);
        when(mockEditText.getText().toString()).thenReturn("test@test");
        assertEquals(validator.validate(), true);
    }

    @Test public void textLengthLessThan8() {
        LengthValidator validatorWithEditText = new LengthValidator(mockEditText, 0, 8, errorMessage, true);
        when(mockEditText.getText().toString()).thenReturn("test@test");
        assertEquals(validatorWithEditText.validate(), false);
    }

    @Test public void textLengthGreaterThan8() {
        LengthValidator validatorWithEditText = new LengthValidator(mockEditText, 0, 9, errorMessage, true);
        when(mockEditText.getText().toString()).thenReturn("test@test");
        assertEquals(validatorWithEditText.validate(), true);
    }

}