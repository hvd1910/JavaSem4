public class ValidateAccount {
    public static String MOBILE = "0904999999";
    public static String PASSWORD = "123456";
    public boolean checkAccount(String mobile, String password){
        if (mobile.equals(MOBILE)){
            if (password.equals(PASSWORD)) {
                System.out.println("Đăng nhập thành công!");
                return true;
            }else {
                System.out.println("Mật khẩu sai, vui lòng thử lại.");
                return false;
            }
        }else {
            System.out.println("Kiểm tra lại số điện thoại hoặc password!");
            return false;
        }
    }
}
