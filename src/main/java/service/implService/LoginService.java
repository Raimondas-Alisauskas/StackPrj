package service.implService;

import model.DTO.UserDTO;
import service.IService.ILoginService;
import service.database.DAO.IDAO.IUserDAO;
import service.database.DAO.implDAO.UserDAO;

public class LoginService implements ILoginService {

    public UserDTO checkUser(String email, String password) {

        UserDTO userDTO = new UserDTO(email, password);

        IUserDAO userDAO = new UserDAO();

        userDTO = userDAO.checkUser(userDTO);

        return userDTO;

    }

}
