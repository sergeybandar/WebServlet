package storage;

import model.Role;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class InMemoryUserStorage {

    private static List<User> memory = new ArrayList<>();
    private static int idUser = 1;

    static {
        User user = new User("admin", "admin", "admin", Role.SUPER_ADMIN);
        user.setUserId(0);
        memory.add(user);
    }

    public void save(User user) {
        memory.add(user);
        user.setUserId(idUser);
        idUser++;
    }

    public User getByLogin(String login) {
        for (User user : memory) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }

    public List<User> getInfo() {
        return memory;
    }

    public boolean reg(String login) {
        for (int i = 0; i < memory.size(); i++) {
            if (login.equals(memory.get(i).getLogin())) {
                return false;
            }
        }
        return true;
    }

    public List<User> getAllUser() {
        return new ArrayList<>(memory);
    }
}
