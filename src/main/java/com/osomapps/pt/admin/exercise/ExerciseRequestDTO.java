package com.osomapps.pt.admin.exercise;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Getter
@Setter
class ExerciseRequestDTO {
    Integer exerciseId;
    String nameEn;
    String nameNo;
    String descriptionEn;
    String descriptionNo;
    ExerciseBodypartRequestDTO bodypart;
    ExerciseEquipmentTypeRequestDTO equipmentType;
    List<ExerciseTypeRequestDTO> types;
    List<ExerciseInputRequestDTO> inputs;
    List<ExerciseOutputRequestDTO> outputs;
    List<ExerciseFileRequestDTO> files;
    Integer cardioPercent;
}
