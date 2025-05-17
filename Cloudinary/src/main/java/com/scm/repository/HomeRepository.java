package com.scm.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.scm.model.DbUser;

@Repository
public class HomeRepository {

	public boolean saveUser(DbUser user) {

		Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cloudinary", "root", "Pass@123");
			String query = "insert into user (id, name, imagepublicId, imageId , ishuman) values (0, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, user.getName());
			ps.setString(2, user.getPublicUserImageId());
			ps.setString(3, user.getUserImageId());
			ps.setBoolean(4, user.isIshuman());
			int saved = ps.executeUpdate();
			if (saved > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public List<DbUser> getAllUser() {

		String query = "select * from user";

		List<DbUser> list = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cloudinary", "root", "Pass@123");
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				DbUser user = new DbUser(rs.getInt("id"), rs.getString("name"), rs.getBoolean("ishuman"),
						rs.getString("imagepublicId"), rs.getString("imageId"));
				list.add(user);

			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public DbUser getUserById(int id) {

		String query = "select * from user where id = ?";

		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cloudinary", "root", "Pass@123");
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				DbUser user = new DbUser(rs.getInt("id"), rs.getString("name"), rs.getBoolean("ishuman"),
						rs.getString("imagepublicId"), rs.getString("imageId"));

				return user;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public boolean deleteUserById(int id) {
		String query = "delete from user where id = ?";

		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cloudinary", "root", "Pass@123");
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			int delete = ps.executeUpdate();
			if (delete > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateUser(DbUser user) {
		String query = "update user set name=?, imagepublicId=?, imageId=?,ishuman=? where id=? ";
		try {
			System.out.println("update User REpository");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cloudinary", "root", "Pass@123");
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, user.getName());
			ps.setString(2, user.getPublicUserImageId());
			ps.setString(3, user.getUserImageId());
			ps.setBoolean(4, user.isIshuman());
			ps.setInt(5, user.getId());
			int update = ps.executeUpdate();
			System.out.println("Update User REpository 2");
			if (update > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
