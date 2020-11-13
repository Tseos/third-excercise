package com.example.model;
import java.util.*;

public class EshopingExpert {
	public List<String> getBrands (String sort)  {
		List<String> brands = new ArrayList<String>();
		if (sort.equals("Push Button-phones")) {
			brands.add("Alcatel");
			brands.add("Cat");
			brands.add("NOKIA");
			brands.add("PANASONIC");
			brands.add("My Phone");
		}
		else {
			brands.add("Xiaomi");
			brands.add("Samsung");
			brands.add("Apple");
			brands.add("Huawei");
			brands.add("LG");
			brands.add("BlackView");
		}
		return(brands);
		}
	}
