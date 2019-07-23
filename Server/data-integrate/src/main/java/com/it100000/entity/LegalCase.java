package com.it100000.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@Table(name = "t_legal_case")
public class LegalCase implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 违章名称 命名规则：日期+区域+摄像机名称+违章类型
     */
    @Column(name = "name")
    private String name;

    /**
     * 上报人ID
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 区域ID
     */
    @Column(name = "area_id")
    private Integer areaId;

    /**
     * 监控ID
     */
    @Column(name = "monitor_id")
    private Integer monitorId;

    /**
     * 案件ID
     */
    @Column(name = "legal_case_type_id")
    private Integer legalCaseTypeId;

    /**
     * 其他
     */
    @Column(name = "other")
    private String other;

    /**
     * 违章位置
     */
    @Column(name = "site")
    private String site;

    /**
     * 违章截图,以|号分割多个图片
     */
    @Column(name = "img")
    private String img;

    /**
     * 违章视频
     */
    @Column(name = "video")
    private String video;

    /**
     * 上传日期
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 是否删除(0-false 1-true 默认0)
     */
    @Column(name = "is_del")
    private Boolean isDel;

    /**
     * 是否启用(0-false 1-true 默认1)
     */
    @Column(name = "is_enable")
    private Boolean isEnable;

    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        LegalCase other = (LegalCase) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getAreaId() == null ? other.getAreaId() == null : this.getAreaId().equals(other.getAreaId()))
            && (this.getMonitorId() == null ? other.getMonitorId() == null : this.getMonitorId().equals(other.getMonitorId()))
            && (this.getLegalCaseTypeId() == null ? other.getLegalCaseTypeId() == null : this.getLegalCaseTypeId().equals(other.getLegalCaseTypeId()))
            && (this.getOther() == null ? other.getOther() == null : this.getOther().equals(other.getOther()))
            && (this.getSite() == null ? other.getSite() == null : this.getSite().equals(other.getSite()))
            && (this.getImg() == null ? other.getImg() == null : this.getImg().equals(other.getImg()))
            && (this.getVideo() == null ? other.getVideo() == null : this.getVideo().equals(other.getVideo()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getIsDel() == null ? other.getIsDel() == null : this.getIsDel().equals(other.getIsDel()))
            && (this.getIsEnable() == null ? other.getIsEnable() == null : this.getIsEnable().equals(other.getIsEnable()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getAreaId() == null) ? 0 : getAreaId().hashCode());
        result = prime * result + ((getMonitorId() == null) ? 0 : getMonitorId().hashCode());
        result = prime * result + ((getLegalCaseTypeId() == null) ? 0 : getLegalCaseTypeId().hashCode());
        result = prime * result + ((getOther() == null) ? 0 : getOther().hashCode());
        result = prime * result + ((getSite() == null) ? 0 : getSite().hashCode());
        result = prime * result + ((getImg() == null) ? 0 : getImg().hashCode());
        result = prime * result + ((getVideo() == null) ? 0 : getVideo().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getIsDel() == null) ? 0 : getIsDel().hashCode());
        result = prime * result + ((getIsEnable() == null) ? 0 : getIsEnable().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", userId=").append(userId);
        sb.append(", areaId=").append(areaId);
        sb.append(", monitorId=").append(monitorId);
        sb.append(", legalCaseTypeId=").append(legalCaseTypeId);
        sb.append(", other=").append(other);
        sb.append(", site=").append(site);
        sb.append(", img=").append(img);
        sb.append(", video=").append(video);
        sb.append(", createTime=").append(createTime);
        sb.append(", isDel=").append(isDel);
        sb.append(", isEnable=").append(isEnable);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}