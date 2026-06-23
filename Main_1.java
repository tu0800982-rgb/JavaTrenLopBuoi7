package demo;

import qlphuongtien.*;

public class Main_1 {
    public static void main(String[] args) {
        try {
            TauDienNgam tdn2 = new TauDienNgam(
                    "TDN02",
                    "Metro So 2",
                    1200,
                    2021,
                    18000,
                    1,
                    8,
                    5500
            );

            XeBuyt xb2 = new XeBuyt(
                    "XB02",
                    "Tuyen 19",
                    60,
                    2022,
                    8000,
                    85000,
                    -1
            );

            XeDapCongCong xd2 = new XeDapCongCong(
                    "XD02",
                    "Tram Bach Dang",
                    1,
                    2024,
                    12000,
                    5,
                    "Thuong"

            );


            PhuongTien[] ds = {tdn2, xb2, xd2};

            // In toàn bộ thông tin
            System.out.println("===== DANH SACH PHUONG TIEN =====");
            for (PhuongTien pt : ds) {
                pt.hienThi();
                System.out.println("------------------");
            }

            // In lịch bảo trì và chi phí bảo trì
            System.out.println("\n===== THONG TIN BAO TRI =====");
            double tongChiPhiBaoTri = 0;

            for (PhuongTien pt : ds) {
                if (pt instanceof IBaoTri) {

                    try {
                        IBaoTri bt = (IBaoTri) pt;

                        bt.hienThiLichBaoTri();

                        double chiPhi = bt.tinhChiPhiBaoTri();

                        System.out.println("Chi phi bao tri: " + chiPhi);

                        tongChiPhiBaoTri += chiPhi;

                    } catch (Exception e) {
                        System.out.println("Loi: " + e.getMessage());
                    }
                }
            }

            // Tìm phương tiện có giá vé cao nhất
            PhuongTien max = null;
            double maxGia = -1;

            for (PhuongTien pt : ds) {
                try {
                    double gia = pt.tinhGiaVe();

                    if (gia > maxGia) {
                        maxGia = gia;
                        max = pt;
                    }

                } catch (Exception e) {
                    System.out.println("Loi: " + e.getMessage());
                }
            }

            System.out.println("\n===== PHUONG TIEN CO GIA VE CAO NHAT =====");
            max.hienThi();

            // Tổng chi phí bảo trì
            System.out.println("\nTong chi phi bao tri: " + tongChiPhiBaoTri);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
