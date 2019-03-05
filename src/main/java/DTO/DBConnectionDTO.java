package DTO;

import utils.ErrorType;

import java.sql.Connection;

public class DBConnectionDTO {
    public Connection connection = null;
    public boolean isConnectedToDB = false;
    public ErrorType errorType;

}
