package core.com.ptk.entity;

import java.io.Serializable;

public class Typeword implements Serializable{

	private int id;
	private String name;
	private String describe;
	private Typeword parent;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public Typeword getParent() {
		return parent;
	}
	public void setParent(Typeword parent) {
		this.parent = parent;
	}
	
}
