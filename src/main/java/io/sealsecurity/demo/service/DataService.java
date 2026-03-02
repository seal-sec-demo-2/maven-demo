package io.sealsecurity.demo.service;

import org.apache.commons.text.StringSubstitutor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.Yaml;

import java.util.HashMap;
import java.util.Map;

/**
 * Service demonstrating usage of vulnerable dependencies.
 * These dependencies are automatically patched by Seal Security.
 */
@Service
public class DataService {

    private static final Logger logger = LogManager.getLogger(DataService.class);

    /**
     * Demonstrates Commons Text usage (CVE-2022-42889 - Text4Shell)
     */
    public String processTemplate(String template, Map<String, String> values) {
        StringSubstitutor substitutor = new StringSubstitutor(values);
        String result = substitutor.replace(template);
        logger.info("Processed template with Commons Text");
        return result;
    }

    /**
     * Demonstrates SnakeYAML usage (CVE-2022-1471)
     */
    public Map<String, Object> parseYaml(String yamlContent) {
        Yaml yaml = new Yaml();
        Map<String, Object> data = yaml.load(yamlContent);
        logger.info("Parsed YAML content");
        return data;
    }

    /**
     * Demonstrates Log4j usage (CVE-2021-44228 - Log4Shell)
     */
    public void logActivity(String activity) {
        logger.info("Activity logged: {}", activity);
        logger.debug("Debug information for: {}", activity);
    }

    public String getDemoData() {
        Map<String, String> values = new HashMap<>();
        values.put("name", "Seal Security Demo");
        values.put("status", "Protected");
        
        String template = "Application: ${name}, Status: ${status}";
        return processTemplate(template, values);
    }
}
