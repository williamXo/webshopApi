package api.persistence;

import api.model.User;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

    public UserMapper(){}


    @Override
    public User map(ResultSet rs, StatementContext ctx) throws SQLException {
        User resultUser = new User();
        resultUser.setId(rs.getInt("id"));
        resultUser.setUsername(rs.getString("username"));
        resultUser.setPassword(rs.getString("password"));
        resultUser.setEmail(rs.getString("email"));
        resultUser.setFirstName(rs.getString("firstName"));
        resultUser.setLastName(rs.getString("lastName"));
        resultUser.setRole(rs.getString("role"));

        return resultUser;
    }
}
