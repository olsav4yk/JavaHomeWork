package com.pb.savchuk.hw8;


public class Auth {
    private String login;
    private String password;

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void signUp (String userLogin, String userPassword, String confirmPassword)
     throws WrongLoginException, WrongPasswordException {

        if(userLogin.length()>=5 && userLogin.length()<=20 && userLogin.matches("^[a-zA-Z0-9][a-zA-Z0-9\\s]+$")) {
            login = userLogin;


        } else {

            throw new WrongLoginException("Извините, но Ваш логин или пароль не соответствует требованиям");
        }

        if(userPassword.length()>=5 && userPassword.matches("^[a-zA-Z_0-9][a-zA-Z_0-9\\s]+$") &&
                userPassword.equals(confirmPassword)) {

            password = userPassword;

        } else {

            throw new WrongPasswordException();
        }

    }
    public void signIn (String userLogin, String userPassword) throws WrongLoginException {
        if (userLogin.equals(login) && userPassword.equals(password)){
            System.out.println("Вы успешно вошли на сайт");
        }else {
            throw new WrongLoginException("Извините, но Ваш логин или пароль не верный");
        }
    }
}

