package api.persistence;

        import api.model.User;
        import org.jdbi.v3.core.Jdbi;
        import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
        import org.jdbi.v3.sqlobject.customizer.Bind;
        import org.jdbi.v3.sqlobject.customizer.BindBean;
        import org.jdbi.v3.sqlobject.statement.SqlQuery;
        import org.jdbi.v3.sqlobject.statement.SqlUpdate;

public interface UserDAO {

    @SqlQuery("select * from user where username = :name")
    @RegisterRowMapper(UserMapper.class)
    User getUsernameByName(@Bind("name") String name);


    @SqlQuery("select * from user where username = :name and password = :pass")
    @RegisterRowMapper(UserMapper.class)
    User loginUser(@Bind("name") String username, @Bind("pass") String password);


    @SqlUpdate("UPDATE user SET email= :email, firstName= :firstName, lastName= :lastName WHERE username = :username")
    void updateUser(@BindBean User user);
}
