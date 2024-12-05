package vn.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DataBook extends Main {

	public static ArrayList<sach> loadSach(String pathbook) {
		FileReader fRead = null;
		BufferedReader bfR = null;

		ArrayList<sach> loads = new ArrayList<sach>();
		try {
			fRead = new FileReader(new File(pathbook));
			bfR = new BufferedReader(fRead);
			String line;
			while ((line = bfR.readLine()) != null) {
				sach s = new sach(line);
				loads.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (bfR != null) {
					bfR.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return loads;
	}

	public static void saveSach(ArrayList<sach> person) {
		FileWriter fWrite = null;
		BufferedWriter bfW = null;

		try {
			fWrite = new FileWriter(new File(root + "/book_data_en.txt"));
			bfW = new BufferedWriter(fWrite);
			for (sach sach : person) {
				String line = sach.getLine();
				bfW.write(line);
				bfW.newLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bfW != null) {
				try {
					bfW.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
