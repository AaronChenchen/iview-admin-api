package cn.saatana.modules.person.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import cn.saatana.modules.person.entity.Person;

@Component
public class PersonRepository {
	@Autowired
	private JdbcTemplate template;

	public List<Person> findByLastname(String lastname, int start, int end) {
		String sql = "select * from person where lastname like concat('%',?,'%') limit ?,?";
		List<Person> res = template.query(sql, new Object[] { lastname, start, end }, new RowMapper<Person>() {
			@Override
			public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
				Person res = new Person();
				res.setId(rs.getString("id"));
				res.setFirstname(rs.getString("firstname"));
				res.setLastname(rs.getString("lastname"));
				res.setSex(rs.getString("sex"));
				res.setAge(rs.getInt("age"));
				return res;
			}
		});
		return res;
	}
}
