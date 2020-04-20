package com.java.dto;

import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

public class User {

		@Size( max=40, min=6)
		String name;
		String password;
		MultipartFile photo;
		//needs getters and setters
		@Override
		public String toString() {
			return "User [name=" + name + ", password=" + password + "]";
		}
		public String getName() {
			return name;
		}
		public String getPassword() {
			return password;
		}
		public void setName(String name) {
			this.name = name;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public MultipartFile getPhoto() {
			return photo;
		}
		public void setPhoto(MultipartFile photo) {
			this.photo = photo;
		}
		
		
}
