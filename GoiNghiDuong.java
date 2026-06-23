package qldichvu;

import java.util.ArrayList;
import java.util.List;

public class GoiNghiDuong extends DichVu implements IXacNhan, IThongKe {

    private List<String> danhSachKhach;
    private int soChoToiDa;
    private String tenKhachSan;
    private int soDem;
    private double giaMoiDem;
    private boolean baoBietBuaAn;
    private double phuThuBuaAn;

    public GoiNghiDuong() {
        danhSachKhach = new ArrayList<>();
    }
    public GoiNghiDuong(String maDichVu, String tenDichVu, String donViToChuc, double giaNiemYet, String ngayKhoiHanh, int soChoToiDa, String tenKhachSan, int soDem, double giaMoiDem, boolean baoBietBuaAn, double phuThuBuaAn) {
        super(maDichVu, tenDichVu, donViToChuc, giaNiemYet, ngayKhoiHanh);
        setSoChoToiDa(soChoToiDa);
        setSoDem(soDem);
        setGiaMoiDem(giaMoiDem);
        setPhuThuBuaAn(phuThuBuaAn);

        this.tenKhachSan = tenKhachSan;
        this.baoBietBuaAn = baoBietBuaAn;
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

    public String getTenKhachSan() {
        return tenKhachSan;
    }

    public void setTenKhachSan(String tenKhachSan) {
        this.tenKhachSan = tenKhachSan;
    }

    public int getSoDem() {
        return soDem;
    }

    public void setSoDem(int soDem) {
        if(soDem <= 0)
            throw new IllegalArgumentException("Số đêm phải > 0");

        this.soDem = soDem;
    }

    public void setGiaMoiDem(double giaMoiDem) {
        if(giaMoiDem < 0)
            throw new IllegalArgumentException("Giá mỗi đêm không hợp lệ");

        this.giaMoiDem = giaMoiDem;
    }

    public void setPhuThuBuaAn(double phuThuBuaAn) {
        if(phuThuBuaAn < 0)
            throw new IllegalArgumentException("Phụ thu bữa ăn không hợp lệ");

        this.phuThuBuaAn = phuThuBuaAn;
    }

    @Override
    public double tinhGiaThuThuc() {
        double tong = getGiaNiemYet() + giaMoiDem * soDem;
        if (!baoBietBuaAn) {
            tong += phuThuBuaAn * soDem;
        }
        return tong;
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
            System.out.println((i + 1) + ". "
                    + danhSachKhach.get(i));
        }
    }

    @Override
    public int demSoKhach() {
        return danhSachKhach.size();
    }

    public void themKhach(String tenKhach) {
        if (!kiemTraKhaDung()) {
            throw new IllegalStateException("Gói nghỉ dưỡng đã đầy chỗ");
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
        System.out.println("Khách sạn: " + tenKhachSan);
        System.out.println("Số đêm: " + soDem);
        System.out.println("Giá mỗi đêm: " + giaMoiDem);
        System.out.println("Bao gồm bữa ăn: " + (baoBietBuaAn ? "Có" : "Không"));
        System.out.println("Phụ thu bữa ăn: " + phuThuBuaAn);
        System.out.println("Giá thu thực: " + tinhGiaThuThuc());
    }
}