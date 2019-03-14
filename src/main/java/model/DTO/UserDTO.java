package model.DTO;

public class UserDTO {

        public String name;
        public String email;
        public String password;

        public UserDTO(String _name, String _email, String _password) {

            this.name = _name;
            this.email= _email;
            this.password = _password;

        }

        public UserDTO(String _name, String _email) {

            this.name = _name;
            this.email = _email;

        }



}
