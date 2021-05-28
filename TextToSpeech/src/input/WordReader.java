package input;

import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.poifs.*;

public class WordReader implements DocumentReader
{
	
	
	WordReader(String path)
	{
		
		File file = new File(path);
		try {
			FileInputStream fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			System.out.println("file not found at: " + path );
		}
		POIFSFileSystem fileSystem = new POIFSFileSystem(fis);
	}

	@Override
	public List<String> read() 
	{
		// TODO Auto-generated method stub
		return null;
	}

}
