package service.implService;

import model.DTO.UserDTO;
import service.IService.IRegistrationService;
import service.database.DAO.IDAO.IUserDAO;
import service.database.DAO.implDAO.UserDAO;

public class RegistrationService implements IRegistrationService {

    public void insertUser(String name, String email, String password) {

        UserDTO userDTO = new UserDTO(name, email, password);

        IUserDAO userDAO = new UserDAO();

        userDAO.insertUser(userDTO);

    }

}
