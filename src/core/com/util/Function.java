package core.com.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.*;

import core.com.ptk.DaoImpl.KotobaDaoImpl;
import core.com.ptk.DaoImpl.TypewordDaoImpl;
import core.com.ptk.entity.Kanji;
import core.com.ptk.entity.Kotoba;
import core.com.ptk.entity.Typeword;
import core.com.ptk.serviceImpl.KotobaServiceImpl;
import core.com.ptk.serviceImpl.TypewordServiceImpl;

public class Function {

	private static final int KOTOBA = 0;
	private static final int KANJI = 1;
	private static final String RANH = "^";

	public static void main(String[] args) throws IOException {
		int countdown = 1;
		String kkk = "fdsf,fsf,sdfs,dfsdf,sf,sfsdf,sf,";
		System.out.println(kkk.substring(0,  kkk.length()-1));
		(new Function()).importDBFromExcel(9,5,KOTOBA);
	}

	public String tostring(ArrayList<Kotoba> kotobas) {
		
		String result = "";
		for (int i = 0; i < kotobas.size(); i++){
			result += (kotobas.get(i).getId() + RANH);
			result += (kotobas.get(i).getJp() + RANH);
			result += (kotobas.get(i).getVn() + RANH);
			result += (kotobas.get(i).getEn() + RANH);
			result += (kotobas.get(i).getTypeword().getName() + RANH);
			result += (kotobas.get(i).getLesson() + RANH);
			result += (kotobas.get(i).isIgnoreword() + RANH);
		}
		result = result.substring(0, result.length()-1);
		return result;
	}

	public String tostringKanji(ArrayList<Kanji> kanjis) {
		
		String result = "";
		for (int i = 0; i < kanjis.size(); i++){
			result += (kanjis.get(i).getId() + RANH);
			result += (kanjis.get(i).getKanji() + RANH);
			result += (kanjis.get(i).getKotoba().getJp() + RANH);
			result += (kanjis.get(i).getKotoba().getVn() + RANH);
//			result += (kanjis.get(i).getEn() + ",");
//			result += (kanjis.get(i).getTypeword().getName() + ",");
//			result += (kanjis.get(i).getLesson() + ",");
//			result += (kanjis.get(i).isIgnore() + ",");
		}
		result = result.substring(0, result.length()-1);
		return result;
	}
	
	public void importDBFromExcel(int bai, int sheet, int types) throws IOException{
		FileInputStream fileInputStream = new FileInputStream("db/"+bai+".xls");
		HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
		HSSFSheet worksheet = workbook.getSheet(Integer.toString(sheet));
		int count = 0;
		for (int i = 0; i <= worksheet.getLastRowNum(); i++){
			HSSFRow row = worksheet.getRow(i);
			if (types == KOTOBA){
				Kotoba kotoba = new Kotoba();
				kotoba.setJp(row.getCell(0).getStringCellValue());
				kotoba.setVn(row.getCell(1).getStringCellValue());
				kotoba.setTypeword((new TypewordServiceImpl()).getById((int) row.getCell(2).getNumericCellValue()));
				kotoba.setLesson(bai);
				int rsu = (new KotobaServiceImpl()).insert(kotoba);
				count += rsu;
				if (rsu == 0)
					System.out.println("Loi o tu: " + kotoba.getJp());
			}
		}
		
		System.out.println("Done: " + count);
	}
}
