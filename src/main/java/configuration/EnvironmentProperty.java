package configuration;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class EnvironmentProperty {
    Logger logger = LoggerFactory.getLogger(EnvironmentProperty.class);

    public EnvironmentProperty() {
        setSystemPropertiesFromYamlFile();
    }

    private void setSystemPropertiesFromYamlFile() {
        YamlReader yamlReader = new YamlReader();
        //Environment:
        String webUrl = yamlReader.getConfig().getEnvironments().getEnvironment().getWebUrl();
        String title = yamlReader.getConfig().getEnvironments().getEnvironment().getTitle();
        String envName = yamlReader.getConfig().getEnvironments().getEnvironment().getEnvName();
        String login = yamlReader.getConfig().getEnvironments().getEnvironment().getLogin();
        String appPassword = yamlReader.getConfig().getEnvironments().getEnvironment().getPassword();

        System.setProperty("webUrl", webUrl);
        logger.info("Setting system property 'webUrl' to: {}", webUrl);
        System.setProperty("title", title);
        logger.info("Setting system property 'title' to: {}", title);
        System.setProperty("envName", envName);
        logger.info("Setting system property 'envName' to: {}", envName);
        System.setProperty("login", login);
        logger.info("Setting system property 'login' to: {}", login);
        System.setProperty("password", appPassword);
        logger.info("Setting system property 'appPassword' to: {}", appPassword);


        //DataBase:
        String dbName = yamlReader.getConfig().getDataBase().retrieveDataBaseModel().getDbName();
        String host = yamlReader.getConfig().getDataBase().retrieveDataBaseModel().getHost();
        String user = yamlReader.getConfig().getDataBase().retrieveDataBaseModel().getUser();
        String dbPassword = yamlReader.getConfig().getDataBase().retrieveDataBaseModel().getDbPassword();
        System.setProperty("dbName", dbName);
        logger.info("Setting system property 'dbName' to: {}", dbName);
        System.setProperty("host", host);
        logger.info("Setting system property 'host' to: {}", host);
        System.setProperty("user", user);
        logger.info("Setting system property 'user' to: {}", user);
        System.setProperty("dbPassword", dbPassword);
        logger.info("Setting system property 'host' to: {}", dbPassword);


    }


}







