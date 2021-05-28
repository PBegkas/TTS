package input;

import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;

public class WordReader implements DocumentReader
{
	private List<String> content;
	private XWPFDocument document;
	WordReader(String path)
	{
		
		
		try {
			File file = new File(path);
			FileInputStream fis = new FileInputStream(file);
			
			document = new XWPFDocument(OPCPackage.open(fis));
			
		} catch (Exception e) {
			System.out.println("file not found at: " + path );
		}
	}

	@Override
	public List<String> read() 
	{
		List<XWPFParagraph> paragraphList =  document.getParagraphs();
	       for (XWPFParagraph paragraph: paragraphList){
		   content.add(paragraph.getText());
	       }
		return content;
	}

}
