package configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import configuration.models.AppConfig;

import java.io.File;
import java.io.IOException;

public class YamlReader {
    public static AppConfig config;

    public AppConfig getConfig() {
        return config;
    }

    public YamlReader() {
        try {
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            this.config = mapper.readValue(new File("src/main/resources/config.yaml"), AppConfig.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
