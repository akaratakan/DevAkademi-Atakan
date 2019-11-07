package com.example.asus.devakademi2019.network.model;

public class Advert {
	private String town;
	private String city;
	private String description;
	private String title;
	private String c0;
	private String c1;
	private String c2;
	private String c3;
	private String c4;
	private String c5;
	private String c6;
	private double price;
	private int has_promotion;
	private int id;
	private int view_count;

	public void setTown(String town){
		this.town = town;
	}

	public String getTown(){
		return town;
	}

	public void setCity(String city){
		this.city = city;
	}

	public String getCity(){
		return city;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setC0(String c0){
		this.c0 = c0;
	}

	public String getC0(){
		return c0;
	}

	public void setC1(String c1){
		this.c1 = c1;
	}

	public String getC1(){
		return c1;
	}

	public void setC2(String c2){
		this.c2 = c2;
	}

	public String getC2(){
		return c2;
	}

	public void setC3(String c3){
		this.c3 = c3;
	}

	public String getC3(){
		return c3;
	}

	public void setC4(String c4){
		this.c4 = c4;
	}

	public String getC4(){
		return c4;
	}

	public void setC5(String c5){
		this.c5 = c5;
	}

	public String getC5(){
		return c5;
	}

	public void setC6(String c6){
		this.c6 = c6;
	}

	public String getC6(){
		return c6;
	}

	public void setPrice(int price){
		this.price = price;
	}

	public double getPrice(){
		return price;
	}

	public void setHasPromotion(int has_promotion){
		this.has_promotion = has_promotion;
	}

	public int getHasPromotion(){
		return has_promotion;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setViewCount(int view_count){
		this.view_count = view_count;
	}

	public int getViewCount(){
		return view_count;
	}

	@Override
 	public String toString(){
		return 
			"Advert{" +
			"town = '" + town + '\'' + 
			",city = '" + city + '\'' + 
			",description = '" + description + '\'' + 
			",title = '" + title + '\'' + 
			",c0 = '" + c0 + '\'' + 
			",c1 = '" + c1 + '\'' + 
			",c2 = '" + c2 + '\'' + 
			",c3 = '" + c3 + '\'' + 
			",c4 = '" + c4 + '\'' + 
			",c5 = '" + c5 + '\'' + 
			",c6 = '" + c6 + '\'' + 
			",price = '" + price + '\'' + 
			",has_promotion = '" + has_promotion + '\'' +
			",id = '" + id + '\'' + 
			",view_count = '" + view_count + '\'' +
			"}";
		}
}
