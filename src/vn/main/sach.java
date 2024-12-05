package vn.main;

import java.io.Serializable;
import java.util.Scanner;

public class sach implements Serializable {
	private String maSach;
	private String tuaSach;
	private String tenTG;
	private String theLoai;
	private String namXB;

	public sach(String maSach, String tuaSach, String tenTG, String theLoai, String namXB) {
		super();
		this.maSach = maSach;
		this.tuaSach = tuaSach;
		this.tenTG = tenTG;
		this.theLoai = theLoai;
		this.namXB = namXB;
	}

	public sach() {
		super();
		// TODO Auto-generated constructor stub
	}

	public sach(String line) {
		String[] paths = line.split(";");
		maSach = String.valueOf(paths[0]);
		tuaSach = String.valueOf(paths[1]);
		tenTG = String.valueOf(paths[2]);
		theLoai = String.valueOf(paths[3]);
		namXB = String.valueOf(paths[4]);

	}

	public String getMaSach() {
		return maSach;
	}

	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}

	public String getTuaSach() {
		return tuaSach;
	}

	public void setTuaSach(String tuaSach) {
		this.tuaSach = tuaSach;
	}

	public String getTenTG() {
		return tenTG;
	}

	public void setTenTG(String tenTG) {
		this.tenTG = tenTG;
	}

	public String getTheLoai() {
		return theLoai;
	}

	public void setTheLoai(String theLoai) {
		this.theLoai = theLoai;
	}

	public String getNamXB() {
		return namXB;
	}

	public void setNamXB(String namXB) {
		this.namXB = namXB;
	}

	public String getLine() {
		return String.format("%s;%s;%s;%s;%s", maSach, tuaSach, tenTG, theLoai, namXB);

	}

	@Override
	public String toString() {

		return String.format("\n%-10s %-100s %-45s %-40s %-10s", maSach, tuaSach, tenTG, theLoai, namXB);
	}

	public void nhap() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhập thông tin sách:");
		System.out.println("Nhập mã sách:");
		maSach = scanner.nextLine();
		System.out.println("Nhập tựa sách:");
		tuaSach = scanner.nextLine();
		System.out.println("Nhập tên tác giả:");
		tenTG = scanner.nextLine();
		System.out.println("Nhập thể loại sách:");
		theLoai = scanner.nextLine();
		System.out.println("Nhập năm xuất bản:");
		namXB = scanner.nextLine();
	}

}
