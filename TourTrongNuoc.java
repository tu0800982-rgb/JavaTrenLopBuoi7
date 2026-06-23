package qldichvu;

import java.util.ArrayList;
import java.util.List;

public class TourTrongNuoc extends DichVu implements IXacNhan, IThongKe {
    private List<String> danhSachKhach;
    private int soChoToiDa;
    private double phuThuCuoiTuan;
    private boolean laCuoiTuan;

    public TourTrongNuoc() {
        danhSachKhach = new ArrayList<>();
    }

    public TourTrongNuoc(String maDichVu, String tenDichVu, String donViToChuc, double giaNiemYet, String ngayKhoiHanh, int soChoToiDa, double phuThuCuoiTuan, boolean laCuoiTuan) {
        super(maDichVu, tenDichVu, donViToChuc, giaNiemYet, ngayKhoiHanh);
        this.soChoToiDa = soChoToiDa;
        this.phuThuCuoiTuan = phuThuCuoiTuan;
        this.laCuoiTuan = laCuoiTuan;
        setSoChoToiDa(soChoToiDa);
        setPhuThuCuoiTuan(phuThuCuoiTuan);
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
        if (soChoToiDa <= 0) {
            throw new IllegalArgumentException("Số chỗ tối đa phải > 0");
        }
        this.soChoToiDa = soChoToiDa;
    }

    public double getPhuThuCuoiTuan() {
        return phuThuCuoiTuan;
    }

    public void setPhuThuCuoiTuan(double phuThuCuoiTuan) {
        if (phuThuCuoiTuan < 0) {
            throw new IllegalArgumentException("Phụ thu không hợp lệ");
        }
        this.phuThuCuoiTuan = phuThuCuoiTuan;
    }

    //????????????????????????
    public boolean isLaCuoiTuan() {
        return laCuoiTuan;
    }
    //????????????????????????
    public void setLaCuoiTuan(boolean laCuoiTuan) {
        this.laCuoiTuan = laCuoiTuan;
    }

    @Override
    public double tinhGiaThuThuc() {
        if (laCuoiTuan) {
            return getGiaNiemYet() + phuThuCuoiTuan;
        }
        return getGiaNiemYet();
    }

    @Override
    public boolean kiemTraKhaDung() {
        return danhSachKhach.size() < soChoToiDa;
    }

    @Override
    public String thongTinKhaDung() {
        if (kiemTraKhaDung()) {
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
            System.out.println((i + 1) + ". " + danhSachKhach.get(i));
        }
    }

    @Override
    public int demSoKhach() {
        return danhSachKhach.size();
    }
    public void themKhach(String tenKhach) {
        if (!kiemTraKhaDung()) {
            throw new IllegalStateException("Tour đã đầy chỗ");
        }
        danhSachKhach.add(tenKhach);
    }

    //????????????????????????????
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
        System.out.println("Sức chứa tối đa: " + soChoToiDa);
        System.out.println("Số khách hiện tại: " + danhSachKhach.size());
        System.out.println("Số chỗ còn trống: " + (soChoToiDa - danhSachKhach.size()));
        System.out.println("Phụ thu cuối tuần: " + (laCuoiTuan ? "Có" : "Không"));
        System.out.println("Giá thu thực: " + tinhGiaThuThuc());
    }
}