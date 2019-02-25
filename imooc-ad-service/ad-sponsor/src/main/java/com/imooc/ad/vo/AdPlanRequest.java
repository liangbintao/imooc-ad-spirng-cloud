package com.imooc.ad.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.StringUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdPlanRequest {

    private Long id;
    private Long userId;
    private String planName;
    private String startDate;
    private String endDate;

    /**
     * 创建时候的参数校验
     *
     * @return
     */
    public boolean createValidate() {

        return userId != null
                && StringUtils.isNotEmpty(planName)
                && StringUtils.isNotEmpty(startDate)
                && StringUtils.isNotEmpty(endDate);
    }

    /**
     * 修改时候的参数校验
     *
     * @return
     */
    public boolean updateValidate() {
        return id != null && userId != null;
    }

    /**
     * 删除时候的参数校验
     *
     * @return
     */
    public boolean deleteValidate() {
        return id != null && userId != null;
    }
}
