package qldichvu;

import java.util.ArrayList;
import java.util.List;

public class TourNuocNgoai extends DichVu implements IXacNhan, IThongKe {

    private List<String> danhSachKhach;
    private int soChoToiDa;
    private String quocGia;
    private double phiVisa;
    private double phuThuHanhLy;
    private double soKgHanhLy;

    public TourNuocNgoai() {
        danhSachKhach = new ArrayList<>();
    }
    public TourNuocNgoai(String maDichVu, String tenDichVu, String donViToChuc, double giaNiemYet, String ngayKhoiHanh, int soChoToiDa, String quocGia, double phiVisa, double phuThuHanhLy, double soKgHanhLy) {
        super(maDichVu, tenDichVu, donViToChuc, giaNiemYet, ngayKhoiHanh);
        setSoChoToiDa(soChoToiDa);
        setPhiVisa(phiVisa);
        setPhuThuHanhLy(phuThuHanhLy);
        setSoKgHanhLy(soKgHanhLy);

        this.quocGia = quocGia;

        danhSachKhach = new ArrayList<>();
    }

    public List<String> getDanhSachKhach() {
        return danhSachKhach;
    }

    public void setDanhSachKhach(List<String> danhSachKhach) {
        this.danhSachKhach = danhSachKhach;
    }

    public int getSoChoToiDa() {
        return soChoToiDa;
    }

    public void setSoChoToiDa(int soChoToiDa) {
        this.soChoToiDa = soChoToiDa;
    }

    public String getQuocGia() {
        return quocGia;
    }

    public void setQuocGia(String quocGia) {
        this.quocGia = quocGia;
    }

    public double getPhiVisa() {
        return phiVisa;
    }

    public void setPhiVisa(double phiVisa) {
        if(phiVisa < 0)
            throw new IllegalArgumentException("Phí visa không hợp lệ");

        this.phiVisa = phiVisa;
    }

    public void setPhuThuHanhLy(double phuThuHanhLy) {
        if(phuThuHanhLy < 0)
            throw new IllegalArgumentException("Phụ thu hành lý không hợp lệ");

        this.phuThuHanhLy = phuThuHanhLy;
    }

    public void setSoKgHanhLy(double soKgHanhLy) {
        if(soKgHanhLy < 0)
            throw new IllegalArgumentException("Số kg hành lý không hợp lệ");

        this.soKgHanhLy = soKgHanhLy;
    }

    @Override
    public double tinhGiaThuThuc() {
        return getGiaNiemYet() + phiVisa + phuThuHanhLy * soKgHanhLy;
    }

    @Override
    public boolean kiemTraKhaDung() {
        return danhSachKhach.size() < soChoToiDa;
    }

    @Override
    public String thongTinKhaDung() {
        if (kiemTraKhaDung()){
            return "Còn " + (soChoToiDa - danhSachKhach.size()) + " chỗ";
    }
        return "Đã hết chỗ";
    }

    @Override
    public void inDanhSachKhachHang() {
        if (danhSachKhach.isEmpty()) {
            System.out.println("Danh sách khách trống");
            return;
        }
        for (int i = 0; i < danhSachKhach.size(); i++) {
            System.out.println((i + 1) + ". "
                    + danhSachKhach.get(i));
        }
    }

    @Override
    public int demSoKhach() {
        return danhSachKhach.size();
    }

    //???????????????????????????????
    public void themKhach(String tenKhach) {
        if (!kiemTraKhaDung()) {
            throw new IllegalStateException("Tour đã đầy chỗ");
        }
        danhSachKhach.add(tenKhach);
    }

    public void xoaKhach(String tenKhach) {
        if (!danhSachKhach.remove(tenKhach))
            throw new IllegalArgumentException("Không tìm thấy khách hàng: " + tenKhach);
    }

    public boolean kiemTraTonTai(String tenKhach) {
        return danhSachKhach.contains(tenKhach);
    }

    @Override
    public void hienThi() {
        super.hienThi();
        System.out.println("Quốc gia đến: " + quocGia);
        System.out.println("Phí visa: " + phiVisa);
        System.out.println("Hành lý ký gửi: " + soKgHanhLy + " kg");
        System.out.println("Phụ thu hành lý: " + phuThuHanhLy);
        System.out.println("Giá thu thực: " + tinhGiaThuThuc());
    }
}