package club.beimeng.book_manage_keshe;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@EnableOpenApi // 开启swagger
@SpringBootApplication
//@MapperScan("club.beimeng.book_manage_keshe.mapper")
public class BookManageKesheApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookManageKesheApplication.class, args);
    }

}
