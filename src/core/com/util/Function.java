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
	private static final int BAI = 7;
	private static final int SOPHAN = 5;
	private static final String RANH = "^";

	public static void main(String[] args) throws IOException {
		String kkk = "fdsf,fsf,sdfs,dfsdf,sf,sfsdf,sf,";
		System.out.println(kkk.substring(0,  kkk.length()-1));
		for (int i = 0; i < SOPHAN; i++){
			(new Function()).importDBFromExcel(BAI,i,KOTOBA);
		}
	}

	public String toJSONKotoba(ArrayList<Kotoba> kotobas){
		
		String result = "{'kotobas':[";
		for (int i = 0; i < kotobas.size(); i++){
			result += "{";
			result += "'id':'" + kotobas.get(i).getId() + "',";
			result += "'jp':'" + kotobas.get(i).getJp() + "',";
			result += "'vn':'" + kotobas.get(i).getVn() + "',";
			result += "'en':'" + kotobas.get(i).getEn() + "',";
			result += "'typeword':'" + kotobas.get(i).getTypeword().getName() + "',";
			result += "'lesson':'" + kotobas.get(i).getLesson() + "',";
			result += "'ignore':'" + kotobas.get(i).isIgnoreword() + "'";
			if (i == kotobas.size()-1)
				result += "}";
			else
				result += "},";
		}
		result += "]}";
		result = result.replaceAll("\'", "\\\\\"");		
		return result;
	}
	
	public String toJSONKanji(ArrayList<Kanji> kanjis){
		
		String result = "{'kanjis':[";
		for (int i = 0; i < kanjis.size(); i++){
			result += "{";
			result += "'id':'" + kanjis.get(i).getId() + "',";
			result += "'kanji':'" + kanjis.get(i).getKanji() + "',";
			result += "'jp':'" + kanjis.get(i).getKotoba().getJp() + "',";
			result += "'vn':'" + kanjis.get(i).getKotoba().getVn() + "',";
			result += "'ignore':'false'";
			if (i == kanjis.size()-1)
				result += "}";
			else
				result += "},";
		}
		result += "]}";
		result = result.replaceAll("\'", "\\\\\"");		
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
