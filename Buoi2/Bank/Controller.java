import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Controller {
    private static  long balanceNumber = 1000000;
    List<TransactionHistory> listHistory = new ArrayList<TransactionHistory>();

    public long getBalanceNumber() {
        return balanceNumber;
    }

    public static long transfer(long money) {

        return  balanceNumber;
    }


    public void  actionTransfer(String phone) {
        Scanner input = new Scanner(System.in);
        LocalDate day = LocalDate.now();
        System.out.print("Nhập số tài khoản người nhận:");
        String numberStk = input.nextLine();
        System.out.print("Nhập số tiền cần chuyển: ");
        long transferMoney = input.nextLong();
        System.out.print("Ghi chú: ");
        String description = input.nextLine();
        System.out.println("1: Xác nhận chuyển tiền  -   2: Hủy bỏ giao dịch");
        System.out.print("Vui lòng nhập lựa chon: ");
        int booltranfer = input.nextInt();
        long id = 1;
        switch (booltranfer) {
            case 1:
                balanceNumber = balanceNumber - transferMoney;
                System.out.println("Đã chuyển tiền cho: " + numberStk);
                System.out.println("Số tiền: " +formatMoney(transferMoney));

                TransactionHistory th = new TransactionHistory(id,day, description, phone, transferMoney);
                listHistory.add(th);
                System.out.println("Trạng thái giao dịch: Thành công");
                System.out.println("---------------------------------");
                System.out.println("---------------------------------");
                System.out.println("Số dư còn lại: " +formatMoney(balanceNumber));
                return;
            case 2:
                System.exit(0);

        }


    }

    public void getHistory() {
        System.out.println("Danh sách lịch sử đã giao dịch.");
        listHistory.forEach(th -> System.out.println(th));

    }

    public  static  String formatMoney(long money) {
        DecimalFormat formmater = new DecimalFormat("###,###,##0.00");
        return formmater.format(money);
    }
}
