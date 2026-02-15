package io.sealsecurity.demo;

import io.sealsecurity.demo.service.DataService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private DataService dataService;

    @Test
    public void contextLoads() {
        assertNotNull("Application context should load", dataService);
    }

    @Test
    public void testTemplateProcessing() {
        Map<String, String> values = new HashMap<>();
        values.put("key", "value");
        
        String result = dataService.processTemplate("Test ${key}", values);
        assertEquals("Test value", result);
    }

    @Test
    public void testYamlParsing() {
        String yaml = "name: Test\nvalue: 123";
        Map<String, Object> result = dataService.parseYaml(yaml);
        
        assertNotNull(result);
        assertEquals("Test", result.get("name"));
    }

    @Test
    public void testDemoData() {
        String result = dataService.getDemoData();
        assertNotNull(result);
        assertTrue(result.contains("Seal Security Demo"));
        assertTrue(result.contains("Protected"));
    }
}
