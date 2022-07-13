package club.beimeng.book_manage_keshe.entity;

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
 * @since 2022-07-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Application对象", description="")
public class Application implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    private String bookId;

    private String userId;

    @ApiModelProperty(value = "申请借 1  申请还 2")
    private Integer type;

    @ApiModelProperty(value = "0 未审批 1 同意 2 拒接")
    private Integer status;

    private Date createTime;

    private Date updateTime;


}
