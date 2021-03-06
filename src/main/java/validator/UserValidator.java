package validator;

import entity.User;
import exception.UserShortLengthLoginException;
import exception.UserShortLengthPasswordException;

public class UserValidator
{
    private static UserValidator instance = null;
    private final int MIN_LOGIN_LENGTH = 4;
    private final int MIN_PASWWORD_LENGTH = 6;


    public UserValidator()
    {

    }

    public static UserValidator getInstance()
    {
        if(instance == null)
            instance = new UserValidator();

        return instance;
    }

    public boolean isValidate(User user) throws UserShortLengthLoginException, UserShortLengthPasswordException
    {
        if(!isLoginLongEnough(user.getLogin()))
        {
            throw new UserShortLengthLoginException("Login " + user.getLogin() + " is to short");
        }
        if(!isPasswordLongEnough(user.getPassword()))
        {
            throw new UserShortLengthPasswordException("Password " + user.getPassword() + " is to short");
        }

        return true;
    }

    private boolean isLoginLongEnough(String login)
    {
        if(login.length() >= MIN_LOGIN_LENGTH)
            return true;
        else
            return false;
    }

    private boolean isPasswordLongEnough(String password)
    {
        if(password.length() >= MIN_PASWWORD_LENGTH)
            return true;
        else
            return false;
    }
}
