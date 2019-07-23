package com.it100000.entity;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@Table(name = "t_legal_case_type")
public class LegalCaseType implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 分类名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 父ID
     */
    @Column(name = "pid")
    private Integer pid;

    /**
     * 分类(0-一级分类 1-二级分类)
     */
    @Column(name = "type")
    private Integer type;

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
        LegalCaseType other = (LegalCaseType) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getPid() == null ? other.getPid() == null : this.getPid().equals(other.getPid()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getIsDel() == null ? other.getIsDel() == null : this.getIsDel().equals(other.getIsDel()))
            && (this.getIsEnable() == null ? other.getIsEnable() == null : this.getIsEnable().equals(other.getIsEnable()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getPid() == null) ? 0 : getPid().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
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
        sb.append(", pid=").append(pid);
        sb.append(", type=").append(type);
        sb.append(", isDel=").append(isDel);
        sb.append(", isEnable=").append(isEnable);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}