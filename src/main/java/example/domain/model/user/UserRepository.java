package example.domain.model.user;

public interface UserRepository {
    User findBy(UserIdentifier id);
    Boolean isExist(UserIdentifier id);

    UserSummaries list();

    User prototype();

    void register(User user);

    void update(User user);

    void delete(User user);
}
