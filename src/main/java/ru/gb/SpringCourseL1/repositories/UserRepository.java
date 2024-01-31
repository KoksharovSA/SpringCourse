package ru.gb.SpringCourseL1.repositories;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.gb.SpringCourseL1.model.AppProperties;
import ru.gb.SpringCourseL1.model.User;

import java.util.List;

@Repository
@AllArgsConstructor
public class UserRepository {
    private final JdbcTemplate jdbc;
    private final AppProperties properties;

    public List<User> findAll(){
        String sql = properties.getFindAll();

        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };

        return jdbc.query(sql, userRowMapper);
    }
    public User getUserById(int id){
        String sql = properties.getGetUserById() + id + ";";

        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };

        return jdbc.query(sql, userRowMapper).stream().findFirst().orElse(null);
    }

    public User save(User user){
        String sql = properties.getSave();
        jdbc.update(sql, user.getFirstName(), user.getLastName());
        return user;
    }

    public void deleteById(int id){
        String sql = properties.getDeleteById();
        jdbc.update(sql, id);
    }

    public User updateUser(User user){
        String sql = properties.getUpdateUser();
        jdbc.update(sql, user.getFirstName(), user.getLastName(), user.getId());
        return user;
    }
}
