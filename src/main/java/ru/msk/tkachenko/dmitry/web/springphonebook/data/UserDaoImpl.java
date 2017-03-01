package ru.msk.tkachenko.dmitry.web.springphonebook.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import ru.msk.tkachenko.dmitry.web.springphonebook.error.UserNotFoundException;
import ru.msk.tkachenko.dmitry.web.springphonebook.model.User;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String findAllQuery = "SELECT * FROM profile";
    private final String findById = "SELECT * FROM profile WHERE id=?";
    private final String deleteById = "DELETE FROM profile WHERE id=?";
    private final String updateQuery = "UPDATE profile set username=?, phone=? where id=?";
    private final String saveQuery = "INSERT INTO profile (username, phone) values (?, ?)";

    @Override
    public long totalCount() {
        final String sql = "SELECT count(*) FROM profile";
        long count = jdbcTemplate.queryForObject(sql, Long.class);

        return count;
    }

    @Override
    public User save(User user) {
        jdbcTemplate.update(
                saveQuery,
                user.getPhone(),
                user.getUsername());

        return user;
    }

    @Override
    public int update(User user) {
        return jdbcTemplate.update(
                updateQuery,
                user.getUsername(),
                user.getPhone(),
                user.getId());
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update(deleteById, id);
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query(findAllQuery, new UserRowMapper());
    }


    private class UserRowMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new User(
                    rs.getLong("id"),
                    rs.getString("username"),
                    rs.getString("phone")
            );
        }

    }

    @Override
    public User find(@PathVariable Long id) {
        try {
            return jdbcTemplate.queryForObject(findById, new UserRowMapper(), id);
        } catch (EmptyResultDataAccessException e) {
            throw new UserNotFoundException(id);
        }

    }
}
