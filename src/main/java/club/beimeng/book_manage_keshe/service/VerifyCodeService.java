package club.beimeng.book_manage_keshe.service;

public interface VerifyCodeService {
    String getCode(String email);

    boolean verifyCode(String email,String code);
}
