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
		String sql = "insert into item(id,price,name) values('" + t.getId() + "','" + t.getPrice() + "','"
				+ t.getName() + "')";
		return template.update(sql);
	}

	public int update(Item t) {
		String sql = "UPDATE item SET name=?,price=? WHERE id=?";
		template.update(sql, new Object[] { t.getPrice(), t.getName(), t.getId() });
		return template.update(sql, new Object[] { t.getName(), t.getPrice(), t.getId() });

	}

	public int delete(int id) {
		String sql = "delete from item where id=" + id + "";
		return template.update(sql);
	}

	public Item getItemById(int id1) {

		String sql = "select * from item where id=?";
		Item item = template.queryForObject(sql, new Object[] { id1 },
				new BeanPropertyRowMapper<Item>(Item.class));
		System.out.println(item);
		return item;
	}

	public List<Item> getItems() {
		System.out.println("list of items are displayed");
		return template.query("select * from item", new RowMapper<Item>() {

			public Item mapRow(ResultSet resultset, int row) throws SQLException {
				Item tt = new Item();
				tt.setId(resultset.getInt(1));
				tt.setPrice(resultset.getString(2));
				tt.setName(resultset.getString(3));
				return tt;
			}
		});
	}
}
