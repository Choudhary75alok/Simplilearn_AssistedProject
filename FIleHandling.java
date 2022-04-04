package fileHandling;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FIleHandling {

	public static void main(String[] args) throws IOException {

		String path = "C:\\project\\";
		Scanner sc = new Scanner(System.in);
		char d;

		do {

			System.out.println("Main Menu");
			String MainMenu = ("1.Retrieve files in ascending order\n2.Business level operation\n0.Exit");
			System.out.println(MainMenu);
			int ch;
			Scanner sc1 = new Scanner(System.in);
			ch = sc1.nextInt();

			switch (ch) {
			case 1:
				File fl = new File(path);
				File filename[] = fl.listFiles();
				for (File fname : filename) {
					System.out.println(fname.getName());
				}
				break;
			case 2:
				String mainmenu = ("OPERATION MENU:\n" + "1.Add file\n" + "2.Delete file\n" + "3.Search file\n"
						+ "4.Go to main menu\n" + "5.Exit from the application");
				System.out.println(mainmenu);
				int choice;
				Scanner sc2 = new Scanner(System.in);
				choice = sc2.nextInt();
				switch (choice) {
				case 1:
					Scanner xyz = new Scanner(System.in);
					ArrayList<String> al = new ArrayList<>();
					while (true) {
						System.out.println("Enter The File Name To Create\n");
						String fname = xyz.next();
						String finalname = path + fname;
						System.out.println(finalname);

						// creating a file

						File fi = new File(finalname);
						boolean bb = fi.createNewFile();
						if (bb != true) {
							System.out.println("!! No File Created !!");
						} else {
							al.add(fname);
							System.out.println("* File Sucessfully Created *");
						}

						System.out.println(" All Available Files:- " + al);
						break;
					}
					break;
				case 2:
					Scanner abc = new Scanner(System.in);
					System.out.println(" !! Write The File Name To Be Deleted !!");
					String fileName = abc.next();
					String finalfile = path + fileName;
					File file = new File(finalfile);
					file.delete();
					System.out.println("Deleted");

					break;
				case 3:
					File fi = new File(path);
					Scanner scanf = new Scanner(System.in);
					System.out.println("* Type File Name to Search *");
					String fileSearchName = scanf.next();
					File filesname[] = fi.listFiles();
					int flag = 0;
					for (File ff : filesname) {
						if (ff.getName().equals(fileSearchName)) {
							flag = 1;
							break;
						} else {
							flag = 0;
						}
					}
					if (flag == 1) {
						System.out.println("* File Found *");
					} else {
						System.out.println("!! No Files Found !!");
					}
					break;
				case 4:
					System.out.println(MainMenu);
					break;
				case 5:
					System.exit(0);
					break;
				default:
					System.out.println("!! Enter The Correct Choice !!");
				}
				break;
			case 3:
				System.exit(0);
			default:
				System.out.println(" !! Enter The Correct Choice !!");
			}
			System.out.println("!* Do you want to continue(Y/N) *!");
			d = sc.next().charAt(0);
		} while (d == 'y' || d == 'Y');
		sc.close();
	}

}
