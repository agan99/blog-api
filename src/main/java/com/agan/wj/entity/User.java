package com.agan.wj.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @TableId
    private Integer id;

    private String username;

    private String password;

    private String salt;

    private String name;

    private String phone;

    private String email;

    private String enabled;


}
