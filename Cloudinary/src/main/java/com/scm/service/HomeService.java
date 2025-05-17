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

}
