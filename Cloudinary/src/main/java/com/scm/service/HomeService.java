package com.scm.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.model.DbUser;
import com.scm.model.User;
import com.scm.repository.HomeRepository;

@Service
public class HomeService {

	@Autowired
	HomeRepository homeRepository;

	@Autowired
	ImageService imageService;

	public boolean savedData(User user) {

		Map uploaFile;
		try {
			uploaFile = imageService.uploaFile(user.getPhoto());

			DbUser db = new DbUser();
			db.setId(0);
			db.setIshuman(user.isIshuman());
			db.setName(user.getName());
			db.setPublicUserImageId((String) uploaFile.get("public_id"));
			db.setUserImageId((String) uploaFile.get("secure_url"));
			return homeRepository.saveUser(db);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return false;
	}

	public List<DbUser> getAllData() {
		return homeRepository.getAllUser();
	}

	public DbUser getUserById(int id) {
		return homeRepository.getUserById(id);
	}

	public boolean updateUser(User user, String existingPublicId, String existingSecureUrl) {
		DbUser dbUser = homeRepository.getUserById(user.getId());
		System.out.println("UserUpdate HomeService Method");

		try {
			dbUser.setIshuman(user.isIshuman());
			dbUser.setName(user.getName());

			if (!user.getPhoto().isEmpty()) {
				System.out.println("Uploading new image");
				Map uploadFile = imageService.uploaFile(user.getPhoto());
				  dbUser.setPublicUserImageId((String) uploadFile.get("public_id"));
		            dbUser.setUserImageId((String) uploadFile.get("secure_url"));
			} else {
				System.out.println("No new image, keeping existing");
				dbUser.setPublicUserImageId(existingPublicId);
				dbUser.setUserImageId(existingSecureUrl);
			}

			return homeRepository.updateUser(dbUser);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteUser(int id) {
		return homeRepository.deleteUserById(id);
	}

}
