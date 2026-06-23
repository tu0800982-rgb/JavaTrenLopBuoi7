package demo;

import qldichvu.*;

public class Main_2 {

    public static void main(String[] args) {

        // ==========================
        // BƯỚC 1: KHỞI TẠO DỮ LIỆU
        // ==========================

        TourTrongNuoc t1;

        try {

            t1 = new TourTrongNuoc(
                    "TN01",
                    "Tour Đà Nẵng",
                    "VietTravel",
                    3000000,
                    "20/07/2026",
                    5,
                    -1,
                    true
            );

        } catch (IllegalArgumentException e) {

            System.out.println("Lỗi: " + e.getMessage());

            // tạo lại dữ liệu hợp lệ để chương trình chạy tiếp
            t1 = new TourTrongNuoc(
                    "TN01",
                    "Tour Đà Nẵng",
                    "VietTravel",
                    3000000,
                    "20/07/2026",
                    5,
                    0,
                    true
            );
        }

        TourTrongNuoc t2 = new TourTrongNuoc(
                "TN02",
                "Tour Nha Trang",
                "VietTravel",
                2500000,
                "25/07/2026",
                6,
                50000,
                false
        );

        TourNuocNgoai n1 = new TourNuocNgoai(
                "NN01",
                "Tour Nhật Bản",
                "Saigon Tourist",
                15000000,
                "15/08/2026",
                10,
                "Nhật Bản",
                2000000,
                100000,
                20
        );

        TourNuocNgoai n2 = new TourNuocNgoai(
                "NN02",
                "Tour Hàn Quốc",
                "Saigon Tourist",
                12000000,
                "20/08/2026",
                8,
                "Hàn Quốc",
                1500000,
                80000,
                15
        );

        GoiNghiDuong g1 = new GoiNghiDuong(
                "ND01",
                "Nghỉ dưỡng Phú Quốc",
                "Vinpearl",
                5000000,
                "01/09/2026",
                8,
                "Vinpearl Resort",
                3,
                1500000,
                true,
                300000
        );

        GoiNghiDuong g2 = new GoiNghiDuong(
                "ND02",
                "Nghỉ dưỡng Đà Lạt",
                "Dalat Resort",
                4000000,
                "10/09/2026",
                6,
                "Dalat Palace",
                2,
                1200000,
                false,
                200000
        );

        DichVu[] ds = {t1, t2, n1, n2, g1, g2};

        // ==========================
        // BƯỚC 2: HIỂN THỊ TOÀN BỘ
        // ==========================

        System.out.println("\n===== DANH SÁCH DỊCH VỤ =====");

        for (DichVu dv : ds) {
            dv.hienThi();
            System.out.println("----------------------");
        }

        // ==========================
        // BƯỚC 3: THÊM KHÁCH HÀNG
        // ==========================

        try {
            t1.themKhach("Nguyen Van A");
            t1.themKhach("Tran Thi B");

            t2.themKhach("Le Van C");

            n1.themKhach("Pham Thi D");
            n1.themKhach("Hoang Van E");

            n2.themKhach("Do Thi F");

            g1.themKhach("Nguyen Van G");

            g2.themKhach("Tran Van H");
            g2.themKhach("Le Thi I");

        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

        // ==========================
        // BƯỚC 4: KIỂM TRA TỒN TẠI VÀ XÓA
        // ==========================

        if (t1.kiemTraTonTai("Tran Thi B")) {
            t1.xoaKhach("Tran Thi B");
            System.out.println("Đã xóa Tran Thi B");
        }

        // ==========================
        // BƯỚC 5: DUYỆT DANH SÁCH KHÁCH
        // ==========================

        System.out.println("\n===== DANH SÁCH KHÁCH HÀNG =====");

        for (DichVu dv : ds) {

            IThongKe tk = (IThongKe) dv;

            tk.inDanhSachKhachHang();

            System.out.println("Tổng khách: "
                    + tk.demSoKhach());

            System.out.println("----------------------");
        }

        // ==========================
        // BƯỚC 6: KIỂM TRA KHẢ DỤNG
        // ==========================

        System.out.println("\n===== KIỂM TRA KHẢ DỤNG =====");

        for (DichVu dv : ds) {

            IXacNhan xn = (IXacNhan) dv;

            System.out.println(
                    dv.getTenDichVu()
                            + ": "
                            + xn.thongTinKhaDung());
        }

        // ==========================
        // BƯỚC 7: THỐNG KÊ
        // ==========================

        int demConCho = 0;
        int tongKhach = 0;

        DichVu max = ds[0];

        for (DichVu dv : ds) {

            IXacNhan xn = (IXacNhan) dv;
            IThongKe tk = (IThongKe) dv;

            if (xn.kiemTraKhaDung()) {
                demConCho++;
            }

            tongKhach += tk.demSoKhach();

            if (dv.tinhGiaThuThuc() > max.tinhGiaThuThuc()) {
                max = dv;
            }
        }

        System.out.println("\n===== THỐNG KÊ =====");

        System.out.println("Số dịch vụ còn chỗ: "
                + demConCho);

        System.out.println("Tổng khách hàng: "
                + tongKhach);

        System.out.println("\nDịch vụ có giá thu thực cao nhất:");

        max.hienThi();
    }
}