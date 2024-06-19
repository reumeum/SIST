package kr.spring.ch11.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import kr.spring.ch11.vo.PageRank;

public class PageRanksView extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//시트 생성
		HSSFSheet sheet = createFirstSheet((HSSFWorkbook) workbook); //자식타입으로 다운캐스팅
		
		//열이름 생성
		createColumnLabel(sheet);
		
		//시트에 데이터 표시하기
		List<PageRank> pageRanks = (List<PageRank>)model.get("pageRanks");
		int rowNum = 1; //0번은 이미 사용했기 때문에 시작할 행번호를 1으로 지정
		for (PageRank rank : pageRanks) {
			createPageRankRow(sheet, rank, rowNum++);
		}
		
		//HTTP 응답 메세지 헤더 설정
		String fileName = "pageRanks2024.xls";
		response.setHeader("Content-Disposition", "attachment;filename=\""+ fileName +"\";");
		response.setHeader("Content-Transfer-Encoding", "binary");
	}

	// 시트 생성
	private HSSFSheet createFirstSheet(HSSFWorkbook workbook) {
		HSSFSheet sheet = workbook.createSheet();
		// sheet index, 이름
		workbook.setSheetName(0, "페이지 순위");
		// 특정 컬럼의 넒이 지정
		// column index, width
		sheet.setColumnWidth(1, 256 * 20);

		return sheet;
	}

	// 열이름 생성
	private void createColumnLabel(HSSFSheet sheet) {
		HSSFRow firstRow = sheet.createRow(0);

		HSSFCell cell = firstRow.createCell(0);
		cell.setCellValue("순위");

		cell = firstRow.createCell(1);
		cell.setCellValue("페이지");
	}

	// 표시할 데이터 생성
	private void createPageRankRow(HSSFSheet sheet, PageRank rank, int rowNum) {
		HSSFRow row = sheet.createRow(rowNum);

		HSSFCell cell = row.createCell(0);
		cell.setCellValue(rank.getRank());

		cell = row.createCell(1);
		cell.setCellValue(rank.getPage());
	}

}
