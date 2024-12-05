package vn.main;

import java.util.ArrayList;

public class showBook {
	public static void hienthiDS(ArrayList<sach> loads) {
		System.out.printf("%-10s %-100s %-45s %-40s %-10s", "Mã sách:", "Tựa sách:", "Tên tác giả:", "Thể loại:",
				"Năm xuất bản:\n");
		for (sach sach : loads) {
			System.out.println(sach);
		}
	}

}
