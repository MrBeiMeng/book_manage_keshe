package club.beimeng.book_manage_keshe.entity.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SearchForm {
    @ApiModelProperty("通过书名查询")
    private String bookName;

    @ApiModelProperty("通过内容查询")
    private String content;

    @ApiModelProperty("通过作者查询")
    private String author;
}
