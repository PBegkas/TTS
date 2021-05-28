package input;

import java.util.List;
import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xwpf.extractor.XPFFWordExtractor;

public class WordReader implements DocumentReader
{
	
	
	WordReader(String path)
	{
		
		File file = new File(path);
		FileInputStream fis = new FileInputStream(file);
		
	}

	@Override
	public List<String> read() 
	{
		// TODO Auto-generated method stub
		return null;
	}

}
