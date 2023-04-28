package file_reorder;

public class Checker {
	public static void checkName(String file) throws NotVaildAutosarFileException{
		if(!file.endsWith(".arxml")) {
			String type = file.substring(file.lastIndexOf("."));
			throw new NotVaildAutosarFileException("Invalid file type " + type);
		}
	}
	public static void checkContent(long len) throws EmptyAutosarFileException{
		if(len == 0) {
			throw new EmptyAutosarFileException();
		}
	}


}
