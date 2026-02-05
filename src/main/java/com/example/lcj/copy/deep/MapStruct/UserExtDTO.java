package com.example.lcj.copy.deep.MapStruct;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author lichengjian
 * @date 2021/12/18
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserExtDTO extends UserDTO {
    private String school;
}
