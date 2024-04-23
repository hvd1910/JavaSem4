public class Menu {
    public  static void  mainMenu() {
        System.out.println("1 - Xem thông tin sản phẩm");
        System.out.println("2 - In danh sách sản phẩm có gi trên 10.000");
        System.out.println("3 - Đếm số sản phẩm có số lượng bán từ 50 trở lên");
        System.out.println("4 - Liệt kê sản phẩm dựa theo loại sản phẩm");
        System.out.println("5 - Sắp xêp sản phẩm theo số lượng bán được");
        System.out.println("6 - Đưa ra sản phẩm bán được nhiều nhất");
        System.out.println("7 - Sắp xếp sản phẩm theo tên");
        System.out.println("0 - Thoát chương trình");
        System.out.print("Lựa chọn của bạn là: ");

    }

    public static void chooseCategory() {
        System.out.println("1 - Thực phẩm");
        System.out.println("2 - Đồ gia dụng");
        System.out.println("3 - Mỹ phẩm");
        System.out.println("4 - Thời trang");
        System.out.print("Lựa chọn của bạn là: ");
    }

    public static  void secondMenu() {
        System.out.println("1 - Sửa thông tin sản phẩm");
        System.out.println("2 - Xóa sản phẩm");
        System.out.println("0 - Quay về trang chủ");
        System.out.print("Lựa chọn của bạn là: ");

    }
}
