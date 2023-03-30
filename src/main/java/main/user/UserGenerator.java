package main.user;

import static main.Utils.randomString;

public class UserGenerator {

    public User genericLogin() {
        return new User("fds423423423@ya.ru", "56782y349uie0");
    }

    public User randomRegister() {
        return new User (randomString(12), randomString(12), randomString(12));
    }

    public User randomRegisterWithShortPassword() {
        return new User (randomString(12), randomString(12), randomString(5));
    }

}
