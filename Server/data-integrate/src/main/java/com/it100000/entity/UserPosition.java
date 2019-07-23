package com.it100000.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Accessors(chain = true)
@Table(name = "t_user_position")
public class UserPosition implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户ID
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 经度
     */
    @Column(name = "lng")
    private BigDecimal lng;

    /**
     * 纬度
     */
    @Column(name = "lat")
    private BigDecimal lat;

    /**
     * 上传时间
     */
    @Column(name = "upload_time")
    private Date uploadTime;

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
        UserPosition other = (UserPosition) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getLng() == null ? other.getLng() == null : this.getLng().equals(other.getLng()))
            && (this.getLat() == null ? other.getLat() == null : this.getLat().equals(other.getLat()))
            && (this.getUploadTime() == null ? other.getUploadTime() == null : this.getUploadTime().equals(other.getUploadTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getLng() == null) ? 0 : getLng().hashCode());
        result = prime * result + ((getLat() == null) ? 0 : getLat().hashCode());
        result = prime * result + ((getUploadTime() == null) ? 0 : getUploadTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", lng=").append(lng);
        sb.append(", lat=").append(lat);
        sb.append(", uploadTime=").append(uploadTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}