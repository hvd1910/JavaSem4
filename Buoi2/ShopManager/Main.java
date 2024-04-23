import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Reponsitory reponsitory = new Reponsitory();
        Scanner scanner = new Scanner(System.in);
        Menu.mainMenu();
        int choose = scanner.nextInt();
        switch (choose) {
            case 0:
                System.exit(0);
                break;
            case 1:
                System.out.println("DANH SÁCH SẢN PHẨM");
                reponsitory.show();
                Menu.secondMenu();
                int secondchoose = scanner.nextInt();
                switch (secondchoose) {
                    case 1:
                        System.out.print("Nhập ID sản phẩm muốn sửa: ");
                        String idproduct = scanner.next();
                        Product p = reponsitory.findProductById(idproduct);
                        if(p == null) {
                            System.out.println("Sản phẩm này không tồn tại vui lòng thử lại.");

                        }else {
                            reponsitory.updateProduct(p);
                        }
                        break;
                    case 2:
                        System.out.print("Nhập ID sản phẩm muốn sửa: ");
                        String idremove = scanner.next();
                        reponsitory.removeProduct(idremove);
                        reponsitory.show();
                        break;
                    case 0:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Chức năng này không tồn tại.");
                        break;
                }
            case 2:
                System.out.println("Các sản phẩm có giá trên 10000: ");
                reponsitory.filterProductPrice(10000);
                break;
            case 3:
                reponsitory.countProductByAmountSale(50);
                break;
            case 4:
                Menu.chooseCategory();
                int choosecategory = scanner.nextInt();
                switch (choosecategory){
                    case 1:
                        reponsitory.filterByCategory(Category.FOOD.getValue());
                        break;
                    case 2:
                        reponsitory.filterByCategory(Category.HOUSEWARE.getValue());
                        break;
                    case 3:
                        reponsitory.filterByCategory(Category.COSMETICS.getValue());
                        break;
                    case 4:
                        reponsitory.filterByCategory(Category.FASHION.getValue());
                        break;
                    default:
                        System.out.println("Loại sản phẩm này không tồn tại.");
                        break;
                }
                break;
            case 5:
                reponsitory.sortProductByAmountSale();
                System.out.println("Sản phẩm sau khi sắp xếp: ");
                reponsitory.show();
                break;
            case 6:
                reponsitory.productMaxAmountSale();
                break;
            case 7:
                reponsitory.sortProductByName();
                System.out.println("Sản phẩm sau khi sắp xếp: ");
                reponsitory.show();
                break;
            default:
                System.out.println("Chức năng này không tồn tại.");
                break;

        }
    }

}