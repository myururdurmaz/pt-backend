package com.osomapps.pt.programs;

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
class WarmupWorkoutItemSetResponseDTO {
    Integer repetitions;
    Integer weight;
    Boolean bodyweight;
    Integer time_in_sec;
    Integer speed;
    Integer incline;
    Integer resistance;
}
