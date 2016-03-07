package core.com.ptk.entity;

import java.io.Serializable;

public class KanjiRoot implements Serializable{

	private int id;
	private String kanji;
	private String hanTu;
	private String amOn;
	private String amKun;
	private String moTa;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getKanji() {
		return kanji;
	}
	public void setKanji(String kanji) {
		this.kanji = kanji;
	}
	public String getHanTu() {
		return hanTu;
	}
	public void setHanTu(String hanTu) {
		this.hanTu = hanTu;
	}
	public String getAmOn() {
		return amOn;
	}
	public void setAmOn(String amOn) {
		this.amOn = amOn;
	}
	public String getAmKun() {
		return amKun;
	}
	public void setAmKun(String amKun) {
		this.amKun = amKun;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
}
