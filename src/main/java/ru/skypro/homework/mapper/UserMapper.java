package ru.skypro.homework.mapper;

import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.auth.Login;
import ru.skypro.homework.dto.auth.Register;
import ru.skypro.homework.dto.user.NewPassword;
import ru.skypro.homework.dto.user.UpdateUser;
import ru.skypro.homework.dto.user.UserDTO;
import ru.skypro.homework.entity.User;

@Service
public class UserMapper {


    public User userFromUserDTO(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setEmail(userDTO.getEmail());
        user.setPhone(userDTO.getPhone());
        user.setRole(userDTO.getRole());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setImage(user.getImage());
        return user;
    }

    public User userFromNewPassword(NewPassword newPassword) {
        User user = new User();
        user.setPassword(newPassword.getNewPassword());
        return user;
    }

    public User userFromUpdateUser(UpdateUser updateUser) {
        User user = new User();
        user.setFirstName(updateUser.getFirstName());
        user.setLastName(updateUser.getLastName());
        user.setPhone(updateUser.getPhone());
        return user;
    }

    public User userFromRegister(Register register) {
        User user = new User();
        user.setEmail(register.getUsername());
        user.setPassword(register.getPassword());
        user.setFirstName(register.getFirstName());
        user.setLastName(register.getLastName());
        user.setPhone(register.getPhone());
        user.setRole(register.getRole());
        return user;
    }

    public User userFromLogin(Login login) {
        User user = new User();
        user.setEmail(login.getUsername());
        user.setPassword(login.getPassword());
        return user;
    }

    public UserDTO userToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setEmail(user.getEmail());
        userDTO.setPhone(user.getPhone());
        userDTO.setRole(user.getRole());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setImage(userDTO.getImage());
        return userDTO;
    }

    public NewPassword userToNewPassword(User user) {
        return new NewPassword(user.getPassword(), user.getPassword());
    }

    public UpdateUser userToUpdateUser(User user) {
        UpdateUser updateUser = new UpdateUser();
        updateUser.setFirstName(user.getFirstName());
        updateUser.setLastName(user.getLastName());
        updateUser.setPhone(user.getPhone());
        return updateUser;
    }

    public Register userToRegister(User user) {
        Register register = new Register();
        register.setUsername(user.getEmail());
        register.setPassword(user.getPassword());
        register.setFirstName(user.getFirstName());
        register.setLastName(user.getLastName());
        register.setPhone(user.getPhone());
        register.setRole(user.getRole());
        return register;
    }

    public Login userToLogin(User user) {
        Login login = new Login();
        login.setUsername(user.getEmail());
        login.setPassword(user.getPassword());
        return login;
    }
}
