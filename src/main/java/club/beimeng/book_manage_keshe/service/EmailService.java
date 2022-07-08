package club.beimeng.book_manage_keshe.service;

public interface EmailService {
    void sendSimpleMail(String from, String to, String subject, String text);
}
