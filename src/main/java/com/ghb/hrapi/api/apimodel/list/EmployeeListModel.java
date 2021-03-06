package com.ghb.hrapi.api.apimodel.list;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by agheboianu on 02.03.2017.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeListModel {
    private String id;

    private String firstName;

    private String lastName;

    private String email;
}
