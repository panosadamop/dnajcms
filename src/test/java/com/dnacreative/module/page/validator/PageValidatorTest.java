package com.dnacreative.module.page.validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import com.dnacreative.module.page.model.Page;

/**
 * @author Michael Isvy
 *         Simple test to make sure that Bean Validation is working
 *         (useful when upgrading to a new version of Hibernate Validator/ Bean Validation)
 */
public class PageValidatorTest {


	@Test
    public void shouldNotValidateWhenNoError() {

    	Page pageUnderTest = new Page("a", "b");
    	
        PageValidator validatorUnderTest = new PageValidator();
        
   
        Errors errors = new BeanPropertyBindingResult(pageUnderTest, "page");
        validatorUnderTest.validate(pageUnderTest, errors);

        assertFalse(errors.hasErrors());
        assertNull(errors.getFieldError("title"));
        assertNull(errors.getFieldError("content"));
    }

    @Test
    public void shouldNotValidateWhenTitleEmpty() {

    	Page pageUnderTest = new Page("", "test content");
    	
        PageValidator validatorUnderTest = new PageValidator();
        
   
        Errors errors = new BeanPropertyBindingResult(pageUnderTest, "page");
        validatorUnderTest.validate(pageUnderTest, errors);

        assertTrue(errors.hasErrors());
        assertNotNull(errors.getFieldError("title"));
    }
    
    @Test
    public void shouldNotValidateWhenTitleAndContentEmpty() {

    	Page pageUnderTest = new Page("", "");
    	
        PageValidator validatorUnderTest = new PageValidator();
        
   
        Errors errors = new BeanPropertyBindingResult(pageUnderTest, "page");
        validatorUnderTest.validate(pageUnderTest, errors);

        assertTrue(errors.hasErrors());
        assertNotNull(errors.getFieldError("title"));
        assertNotNull(errors.getFieldError("content"));
    }

}
