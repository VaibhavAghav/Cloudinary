package com.scm.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

}
