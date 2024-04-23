import java.util.*;

public class Reponsitory {
    List<Product> listProducts = new ArrayList<>();

    public Reponsitory() {
        listProducts.add (new Product("01","Bánh Doraemon 3 vị", Category.FOOD, 100,3500, 57));
        listProducts.add(new Product("02","Xúc xích sườn non" , Category.FOOD,150,3500, 12));
        listProducts.add(new Product("03","Thanh cua", Category. FOOD,100,5000, 85));
        listProducts.add(new Product("04","Bánh khoai môn", Category.FOOD,200,42000, 78));
        listProducts.add(new Product("05","Thìa ăn cơm inox mạ vàng", Category. HOUSEWARE,50,8000,4));
        listProducts.add(new Product("06","Bát đựng gia vị", Category.HOUSEWARE,65,4000,44));
        listProducts.add(new Product("07","Nước Hoa Hồng Soothing Facial Toner Simple", Category .COSMETICS,140,92000,88)) ;
        listProducts.add(new Product("08","Combo gội xả HAIRBURST.", Category.COSMETICS,100, 639000,79));
        listProducts.add(new Product("09","Tinh chất dưỡng ẩm sâu Klains Rich Moist Soothing Serum", Category. COSMETICS,50,249000,24));
        listProducts.add(new Product("10","Kem dưỡng thể Paula's Choice RESIST WEIGHTLESS BODY TREATMENT", Category.COSMETICS,80,715000, 63));
        listProducts.add(new Product("11","Ao thun ISUN", Category.FASHION,250,320000,146));
    }

    public void  show() {
        listProducts.forEach(product -> System.out.println(product));
    }

    public void sortProductByName() {
        listProducts.sort((p1,p2) -> p1.getName().compareTo(p2.getName()));
    }

    public void filterProductPrice(long minPrice) {
        listProducts.stream().filter(product -> product.getPrice() >= minPrice)
                .forEach(product -> System.out.println(product));
    }

    public void  countProductByAmountSale(long minAmountSale) {
        long count = listProducts.stream().filter(product -> product.getAmount() >=50).count();

        System.out.println("Số lượng sản phẩm bán được từ " + minAmountSale + " trở lên là: " + count);
    }

    public void filterByCategory(String category) {
        listProducts.stream().filter(product -> product.getCategory().getValue() == category)
                .forEach(product -> System.out.println(product));
    }

    public void sortProductByAmountSale() {
        listProducts.sort((p1,p2) -> Long.compare(p1.getAmountSale(), p2.getAmountSale()));
    }

    public void productMaxAmountSale() {
        Product p =  listProducts.stream()
                .max(Comparator.comparingLong(Product::getAmountSale))
                .orElse(null);
        System.out.println(p);
    }

    public void removeProduct(String id) {
        List<Product> productsToRemove = new ArrayList<>();
        listProducts.stream()
                .filter(p ->p !=null && p.getId().equals(id))
                .forEach(p -> {
                    int choice;
                    System.out.println("Are you sure deleting this product? (1. Yes 2. No)");
                    choice = new Scanner(System.in).nextInt();
                    if (choice == 1) {
                        productsToRemove.add(p);
                        System.out.println("Xóa product có ID " + id + " thành công.");
                        System.out.println("-------------------------------------------");
                        System.out.println("-------------------------------------------");


                    }
                });
        listProducts.removeAll(productsToRemove);

    }


    public Product  findProductById(String id) {

        for (Product p: listProducts) {
            if(p.getId().equals(id)) {
                System.out.println("thấy rồi");
                return p;
            }
        }
        return null;
    }

    public void  updateProduct(Product product) {
       Scanner input = new Scanner(System.in);
        String name;
        long amount;
        long price;
        long amountSale;
        System.out.print("Enter Product Name: ");
        name = input.nextLine();
        System.out.print("Enter Product Amount: ");
        amount = input.nextLong();
        System.out.print("Enter Product Price: ");
        price = input.nextLong();
        System.out.print("Enter Product AmountSale: ");
        amountSale = input.nextLong();

        product.setName(name);
        product.setAmount(amount);
        product.setPrice(price);
        product.setAmountSale(amountSale);

        System.out.println("Update thông tin sản phẩm thành công.");
        System.out.println(product);

    }



}
