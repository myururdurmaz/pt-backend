package com.osomapps.pt.admin.user;

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
class UserRequestDTO {
    Long id;
    String name;
    String email;
    String password;
    Integer level;
    List<UserGoalRequestDTO> goals;
    UserTypeRequestDTO type;
}
