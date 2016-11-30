package com.happy.model;


import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.servlet.MultipartConfigElement;
import javax.persistence.GeneratedValue;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class Product {

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int pid;
		private String pname;
		private String pdescription;
		private double price;
		private int sid;
		private int stock;
		private int cid;
		
		@Transient
		private MultipartFile file;
		private String imgs;
		
		
		public int getStock() {
			return stock;
		}
		public void setStock(int stock) {
			this.stock = stock;
		}
		public int getPid() {
			return pid;
		}
		public void setPid(int pid) {
			this.pid = pid;
		}
		public String getPname() {
			return pname;
		}
		public void setPname(String pname) {
			this.pname = pname;
		}
		public String getPdescription() {
			return pdescription;
		}
		public void setPdescription(String pdescription) {
			this.pdescription = pdescription;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public int getSid() {
			return sid;
		}
		public void setSid(int sid) {
			this.sid = sid;
		}
		public int getCid() {
			return cid;
		}
		public void setCid(int cid) {
			this.cid = cid;
		}
		public MultipartFile getFile() {
			return file;
		}
		public void setFile(MultipartFile file) {
			this.file = file;
		}
		public String getImgs() {
			return imgs;
		}
		public void setImgs(String imgs) {
			this.imgs = imgs;
		}
		
		}
