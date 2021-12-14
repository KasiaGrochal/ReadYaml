package configuration;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Environments {
    Logger logger = LoggerFactory.getLogger(Environments.class);

    private String defaultEnvironment = "test1";
    public EnvironmentModel test1;
    public EnvironmentModel test2;
    public EnvironmentModel prod;
    public EnvironmentModel environmentModel;

    public Environments() {
        this.environmentModel = getEnvironment();
    }

    public EnvironmentModel getEnvironment() {
        String environment = GlobalProperties.ENVIRONMENT.isSpecified() ? GlobalProperties.ENVIRONMENT.getValue() : this.defaultEnvironment;
        logger.info("Retrieved environment value: {}", environment);

        switch (environment) {
            case "test1":
                environmentModel = test1;
                break;
            case "test2":
                environmentModel = test2;
                break;
            case "prod":
                environmentModel = prod;
                break;
        }
        return environmentModel;
    }
}


