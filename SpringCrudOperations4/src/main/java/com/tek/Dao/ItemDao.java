package com.tek.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tek.model.Item;

@Repository
public class ItemDao {
	@Autowired
	JdbcTemplate template;

	public void setTempalte(JdbcTemplate tempalte) {
		this.template = tempalte;
	}

	public int save(Item t) {
		String sql = "insert into plist(id,price,name) values('" + t.getId() + "','" + t.getPrice() + "','"
				+ t.getName() + "')";
		return template.update(sql);
	}

	public int update(Item t) {
		String sql = "UPDATE plist SET name=?,price=? WHERE id=?";
		template.update(sql, new Object[] { t.getPrice(), t.getName(), t.getId() });
		return template.update(sql, new Object[] { t.getName(), t.getPrice(), t.getId() });
	}

	public int delete(int id) {
		String sql = "delete from plist where id=" + id + "";
		return template.update(sql);
	}

	public Item getItemById(long id) {
		int id1 = (int) id;
		String sql = "select * from plist where id=?";
		Item item = template.queryForObject(sql, new Object[] { id1 }, new BeanPropertyRowMapper<Item>(Item.class));
		System.out.println(item);
		return item;
	}

	public List<Item> getItems() {
		return template.query("select * from plist", new RowMapper<Item>() {

			public Item mapRow(ResultSet resultSet, int row) throws SQLException {
				Item tt = new Item();
				tt.setId(resultSet.getInt(1));
				tt.setPrice(resultSet.getString(2));
				tt.setName(resultSet.getString(3));
				return tt;
			}
		});
	}
}
