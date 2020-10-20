package com.itwillbs.domain;

// 도메인 : 프로젝트에서 중요한 의미를 가지는 명사로 ex) 회원, 글, 상품, 주문 ... 등등

//자바빈(DTO == VO)설계규약
//규칙1번 : public클래스
public class ProductVO {
	//규칙2 : private로 멤버변수 생성
	private String name;
	private double price;
	
	//규칙4 : 생성자(생략가능 - 생략하면 디폴트생성자)
	public ProductVO() {};
	public ProductVO(String name, double price) {
		this.name = name;
		this.price = price;
	};	
	
	//규칙3 : getter setter메서드생성
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	// 5. toString
	@Override
	public String toString() {
		return "제품정보 [name=" + name + ", price=" + price + "]";
	}
}
