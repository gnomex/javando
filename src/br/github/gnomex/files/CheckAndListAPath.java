package br.github.gnomex.files;

import java.io.File;

public class CheckAndListAPath {

	private String pathName = "./";
	
	private File file;
	
	public void AnalyzePath()	{
		
		file = new File(pathName);
		
		if (file .exists())	{
			
			System.out.println(	file.getName()	);
			System.out.println("is file?:" + file.isFile());
			if (file.isDirectory()){
				System.out.println("The absolut path is: " + file.getAbsolutePath());
				System.out.println("is a directory and contains: ");
				String[] allPath = file.list();
				
				for (String path : allPath )	{
					System.out.println("  ->" + path);
				}
			}
			
		}else	{
			System.out.println("Diretorio nao existe!!!");
		}
		
	}
	
	public static void main(String[] args) {
		CheckAndListAPath cpath = new CheckAndListAPath();
		cpath.AnalyzePath();
	}
	
}
