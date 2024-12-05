package vn.main;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static String root = "D:/Java";

	// load data
	static ArrayList<sach> data = DataBook.loadSach(root + "/book_data_en.txt");

	public static void main(String[] args) {
		hienThi();

	}

	private static void hienThi() {
		System.out.println("------MENU------");
		System.out.println("\n1. Hiển thị danh sách");
		System.out.println("2. Tìm kiếm");
		System.out.println("3. Thêm sách");
		System.out.println("4. Sửa thông tin sách");
		System.out.println("5. Xóa sách");
		System.out.println("\n0. Thoát");
		int chon = 0;
		do {
			Scanner scanner = new Scanner(System.in);
			System.out.println("\nMời chọn:");
			chon = scanner.nextInt();
			switch (chon) {
			case 1: {
				// Hiển thị danh sách:
				hienthiSach();
				break;
			}
			case 2: {
				// Tìm kiếm
				timKiem();
				break;
			}
			case 3: {
				// Thêm sách
				themSach();
				break;
			}
			case 4: {
				suaSach();
				// Sửa thông tin sách
				break;
			}
			case 5: {
				// Xóa sách
				xoaSach();
				break;
			}
			case 0: {
				System.out.println("Thoát khỏi chương trình");
				break;
			}
			default:
				System.out.println("Chọn sai!");
			}
		} while (chon != 0);
	}

	private static void timKiem() {
		System.out.println("------SEARCH------");
		System.out.println("\n1. Tìm theo mã sách");
		System.out.println("2. Tìm theo tựa sách");
		System.out.println("3. Tìm theo tên tác giả");
		System.out.println("\n0. Quay lại");
		int chon = 0;
		do {
			Scanner scanner = new Scanner(System.in);
			System.out.println("\nMời chọn:");
			chon = scanner.nextInt();
			switch (chon) {
			case 1: {
				// Tìm theo mã sách
				timMaSach();
				break;
			}
			case 2: {
				// Tìm theo tựa sách
				timTuaSach();
				break;
			}
			case 3: {
				// Tìm theo tên tác giả
				timTacGia();
				break;
			}
			case 0: {
				hienThi();
				break;
			}
			default:
				System.out.println("Chọn sai!");
			}
		} while (chon != 0);
	}

	private static void hienthiSach() {
		int chon = 0;
		System.out.println("--- Hiển thị danh sách ---\n");
		Scanner scanner = new Scanner(System.in);
		System.out.println("1. Hiển thị theo mã sách");
		System.out.println("2. Hiển thị theo tựa sách");
		System.out.println("3. Hiển thị theo tên tác giả");
		System.out.println("4. Hiển thị theo thể loại");
		System.out.println("5. Hiển thị theo năm xuất bản");
		System.out.println("\n0. Quay lại");
		do {
			System.out.println("\nMời chọn:");
			chon = scanner.nextInt();
			switch (chon) {
			case 1: {
				// sắp xếp theo mã sách:
				data.sort((s2, s1) -> s2.getMaSach().compareTo(s1.getMaSach()));
				showBook.hienthiDS(data);
				break;
			}
			case 2: {
				// Sắp xếp theo tựa sách A-Z
				data.sort((s2, s1) -> s2.getTuaSach().compareTo(s1.getTuaSach()));
				showBook.hienthiDS(data);
				break;
			}
			case 3: {
				// Sắp xếp theo tên Tác giả A-Z
				data.sort((s2, s1) -> s2.getTenTG().compareTo(s1.getTenTG()));
				showBook.hienthiDS(data);
				break;
			}
			case 4: {
				// Sắp xếp theo thể loại A-Z
				data.sort((s2, s1) -> s2.getTheLoai().compareTo(s1.getTheLoai()));
				showBook.hienthiDS(data);
				break;
			}
			case 5: {
				// Sắp xếp theo năm xuất bản mới - cũ
				data.sort((s2, s1) -> s1.getNamXB().compareTo(s2.getNamXB()));
				showBook.hienthiDS(data);
				break;
			}
			case 0: {
				hienThi();
				break;
			}
			default:
				System.out.println("Chọn sai!");
			}
		} while (chon != 0);

	}

	private static void themSach() {
		sach s = new sach();
		s.nhap();
		data.add(s);

		showBook.hienthiDS(data);
		DataBook.saveSach(data);
		System.out.println("\nThêm sách thành công!");
	}

	private static void xoaSach() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhập mã sách muốn xóa:");
		String del = scanner.nextLine();
		for (int i = 0; i < data.size(); i++) {
			boolean kq = del.equals(data.get(i).getMaSach());
			if (kq == true) {
				data.remove(i);
			}
		}
		DataBook.saveSach(data);
		showBook.hienthiDS(data);
		System.out.println("\nXóa sách thành công!");

	}

	private static void suaSach() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhập mã sách muốn sửa:");
		String id = scanner.nextLine();
		for (sach sach : data) {
			boolean kq = id.equals(sach.getMaSach());
			if (kq == true) {
				sach.nhap();
			}
		}
		DataBook.saveSach(data);
		showBook.hienthiDS(data);
		System.out.println("\nSửa sách thành công!");
	}

	private static void timMaSach() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhập mã sách muốn tìm:");
		String searchID = scanner.nextLine();
		System.out.println("\nKết quả tìm kiếm:");
		for (sach sach : data) {
			boolean kq = searchID.equals(sach.getMaSach());
			if (kq == true) {
				System.out.println(sach);
			}
		}
	}

	private static void timTuaSach() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhập tựa sách muốn tìm:");
		String searchName = scanner.nextLine();
		System.out.println("\nKết quả tìm kiếm:");
		for (sach sach : data) {
			boolean kq = searchName.equals(sach.getTuaSach());
			if (kq == true) {
				System.out.println(sach);
			}
		}

	}

	private static void timTacGia() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhập tên tác giả muốn tìm:");
		String searchAuthor = scanner.nextLine();
		System.out.println("\nKết quả tìm kiếm:");
		for (sach sach : data) {
			boolean kq = searchAuthor.equals(sach.getTenTG());
			if (kq == true) {
				System.out.println(sach);
			}
		}

	}

}
