import lombok.Data;

public class SecurityFacade {

    @Data
    public class User {
        public User(String email) {
            this.email = email;
        }
        public String email;
    }

    public static SecurityFacade getInstance() {
        return new SecurityFacade();
    }

    public User getCurrentUser() {
        //TODO dummy impl!
        return new User("sample.user@vote.it");
    }

}
