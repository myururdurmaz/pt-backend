package com.osomapps.pt.admin.email;

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
class EmailMessageTemplateRequestDTO {
    String emailSubjectEn;
    String emailSubjectNo;
    String emailTextEn;
    String emailTextNo;
    EmailMessageTypeRequestDTO type;
}
