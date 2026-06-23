package qldichvu;

public abstract class DichVu {

    private String maDichVu;
    private String tenDichVu;
    private String donViToChuc;
    private double giaNiemYet;
    private String ngayKhoiHanh;

    public DichVu() {
    }
    public DichVu(String maDichVu, String tenDichVu, String donViToChuc, double giaNiemYet, String ngayKhoiHanh) {
        this.maDichVu = maDichVu;
        this.tenDichVu = tenDichVu;
        this.donViToChuc = donViToChuc;
        this.giaNiemYet = giaNiemYet;
        this.ngayKhoiHanh = ngayKhoiHanh;
    }

    public String getMaDichVu() {
        return maDichVu;
    }

    public void setMaDichVu(String maDichVu) {
        this.maDichVu = maDichVu;
    }

    public String getTenDichVu() {
        return tenDichVu;
    }

    public void setTenDichVu(String tenDichVu) {
        this.tenDichVu = tenDichVu;
    }

    public String getDonViToChuc() {
        return donViToChuc;
    }

    public void setDonViToChuc(String donViToChuc) {
        this.donViToChuc = donViToChuc;
    }

    public double getGiaNiemYet() {
        return giaNiemYet;
    }

    public void setGiaNiemYet(double giaNiemYet) {
        if (giaNiemYet < 0)
            throw new IllegalArgumentException("Giá không hợp lệ");
        this.giaNiemYet = giaNiemYet;
    }

    public String getNgayKhoiHanh() {
        return ngayKhoiHanh;
    }

    public void setNgayKhoiHanh(String ngayKhoiHanh) {
        this.ngayKhoiHanh = ngayKhoiHanh;
    }

    public void hienThi() {
        System.out.println("Mã DV: " + maDichVu);
        System.out.println("Tên DV: " + tenDichVu);
        System.out.println("Đơn vị tổ chức: " + donViToChuc);
        System.out.println("Giá niêm yết: " + giaNiemYet);
        System.out.println("Ngày khởi hành: " + ngayKhoiHanh);
    }
    public abstract double tinhGiaThuThuc();
}