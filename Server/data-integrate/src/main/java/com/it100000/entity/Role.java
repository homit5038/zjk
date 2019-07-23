package com.it100000.entity;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@Table(name = "t_role")
public class Role implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 角色名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 别名(中文名)
     */
    @Column(name = "alias")
    private String alias;

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
        Role other = (Role) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getAlias() == null ? other.getAlias() == null : this.getAlias().equals(other.getAlias()))
            && (this.getIsDel() == null ? other.getIsDel() == null : this.getIsDel().equals(other.getIsDel()))
            && (this.getIsEnable() == null ? other.getIsEnable() == null : this.getIsEnable().equals(other.getIsEnable()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getAlias() == null) ? 0 : getAlias().hashCode());
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
        sb.append(", alias=").append(alias);
        sb.append(", isDel=").append(isDel);
        sb.append(", isEnable=").append(isEnable);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}