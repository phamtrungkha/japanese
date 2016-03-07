package core.com.ptk.entity;

import java.io.Serializable;

public class Kotoba implements Serializable{

	private int id;
	private String jp;
	private String vn;
	private String en;
	private Typeword typeword;
	private int lesson;
	private boolean ignoreword;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getJp() {
		return jp;
	}
	public void setJp(String jp) {
		this.jp = jp;
	}
	public String getVn() {
		return vn;
	}
	public void setVn(String vn) {
		this.vn = vn;
	}
	public String getEn() {
		return en;
	}
	public void setEn(String en) {
		this.en = en;
	}
	public int getLesson() {
		return lesson;
	}
	public void setLesson(int lesson) {
		this.lesson = lesson;
	}
	public boolean isIgnoreword() {
		return ignoreword;
	}
	public void setIgnoreword(boolean ignoreword) {
		this.ignoreword = ignoreword;
	}
	public Typeword getTypeword() {
		return typeword;
	}
	public void setTypeword(Typeword typeword) {
		this.typeword = typeword;
	}
	
}
