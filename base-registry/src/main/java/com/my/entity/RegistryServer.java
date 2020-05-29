package com.my.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author liu peng bo
 * date: 2020/5/25 11:20
 */
@Data
@Entity
@Table(name = "registry_server")
public class RegistryServer {
    @Id
    private Integer id;

    private String name;

    private String zone;

    private String host;

    private String url;

    private Integer status;

    private String remark;

    private Date gmtCreated;

    private Date gmtModified;

}
