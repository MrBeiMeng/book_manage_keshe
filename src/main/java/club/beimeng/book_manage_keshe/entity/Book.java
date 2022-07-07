package club.beimeng.book_manage_keshe.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author 蔡济声
 * @since 2022-07-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Book对象", description="")
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    @ApiModelProperty(value = "书籍类别")
    private String categoryId;

    private String bookName;

    @ApiModelProperty(value = "内容")
    private String content;

    private String author;

    private String publisher;

    private Date publishDate;

    @ApiModelProperty(value = "单价")
    private BigDecimal unitPrice;

    @ApiModelProperty(value = "图片地址")
    private String imgUrl;

    @ApiModelProperty(value = "简介")
    private String summary;

    @ApiModelProperty(value = "最大数量")
    private Integer allNum;

    @ApiModelProperty(value = "标签")
    private String tags;

    @ApiModelProperty(value = "剩余数量")
    private Integer lastNum;

    @ApiModelProperty(value = "借阅次数")
    private Integer times;

    @ApiModelProperty(value = "图书状态(1为下架，2为上架)")
    private Integer status;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "删除状态(1代表未删除,2代表删除)")
    private Integer deleted;

    private Date createTime;

    private Date updateTime;


}
