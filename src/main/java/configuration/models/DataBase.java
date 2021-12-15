package configuration.models;

import configuration.GlobalProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataBase {

    Logger logger = LoggerFactory.getLogger(DataBase.class);
    private String defaultDataBase = "postgres";
    public DataBaseModel postgres;
    public DataBaseModel dataBaseModel;

    public DataBase() {
        this.dataBaseModel = retrieveDataBaseModel();
    }

    public DataBaseModel retrieveDataBaseModel() {
        String dataBase = GlobalProperties.DATABASE.isSpecified() ? GlobalProperties.DATABASE.getValue() : this.defaultDataBase;
        logger.info("Retrieved database value: {}", dataBase);

        switch (dataBase) {
            case "postgres":
                dataBaseModel = postgres;
                break;
        }
        return dataBaseModel;
    }
}
