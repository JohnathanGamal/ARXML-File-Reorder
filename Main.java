
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.io.IOException;
import java.util.Scanner;
import file_reorder.*;

public class Main {
	public static void main(String[] args) {
	//	System.out.println("File name: ");
	//	Scanner sc = new Scanner(System.in);
	//	String filename = sc.nextLine();
		String filename = args[0];
		try {

			// Checking if file has the correct format
			Checker.checkName(filename);
			File file = new File(filename);
			// Checking if file has content
			Scanner reader = new Scanner(file);
			Checker.checkContent(file.length());
			// Creating an arraylist for starting and ending lines and for containers
			ArrayList<String> fixed = new ArrayList<>();
			ArrayList<Container> containers = new ArrayList<>();
			int before = 0;
			while (reader.hasNextLine()) {
				String tmp = reader.nextLine();
				// If the next lines include a container
				if (tmp.contains("CONTAINER")) {
					String id = tmp;

					String shortn = reader.nextLine();

					String longn = reader.nextLine();
					if (Container.getEnd() == null)
						Container.setEnd(reader.nextLine());
					else
						reader.nextLine();

					containers.add(new Container(id, shortn, longn));
				} else {
					// if it's a starting/ending line
					fixed.add(tmp);
					if (containers.size() == 0) {
						before++;
					}
				}
			}
			Collections.sort(containers);
			//Gather all the data into one string called fileContent
			String fileContent = "";
			for (int i = 0; i < before; i++) {
				fileContent += fixed.get(i) + '\n';
			}
			for (int i = 0; i < containers.size(); i++) {
				fileContent += containers.get(i).getID() + '\n';
				fileContent += containers.get(i).getShortName() + '\n';
				fileContent += containers.get(i).getLongName() + '\n';
				fileContent += Container.getEnd() + '\n';
			}
			for (int i = before; i < fixed.size(); i++) {
				fileContent += fixed.get(i);
				if (i < fixed.size() - 1)
					fileContent += "\n";

			}
			//New file name
			String modFileName = filename.substring(0, filename.lastIndexOf(".arxml")) + "_mod.arxml";
			FileWriter writer = new FileWriter(modFileName);
			writer.write(fileContent);
			writer.close();

		} catch (EmptyAutosarFileException e) {
			System.out.println(e);

		} catch (NotVaildAutosarFileException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}

	}

}
