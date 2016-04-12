package core.com.ptk.entity;

import java.io.Serializable;

public class Kanji implements Serializable{

	private int id;
	private String kanji;
	private Kotoba kotoba;
	private KanjiRoot kanjiRoot;

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
	public Kotoba getKotoba() {
		return kotoba;
	}
	public void setKotoba(Kotoba kotoba) {
		this.kotoba = kotoba;
	}
	public KanjiRoot getKanjiRoot() {
		return kanjiRoot;
	}
	public void setKanjiRoot(KanjiRoot kanjiRoot) {
		this.kanjiRoot = kanjiRoot;
	}
}
