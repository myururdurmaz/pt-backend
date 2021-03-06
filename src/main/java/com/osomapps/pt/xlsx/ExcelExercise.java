package com.osomapps.pt.xlsx;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Getter
@Setter
@ToString
public class ExcelExercise {
    Integer exercise_id;
    String exercise_name;
    Integer user_group_1_percent;
    Integer user_group_2_percent;
    Integer user_group_3_percent;
    Integer user_group_4_percent;
    String basis_for_calculations;
}
