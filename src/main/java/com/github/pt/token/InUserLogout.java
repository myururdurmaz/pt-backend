package com.github.pt.token;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Getter
@Setter
@Entity
@Table(name = "in_user_logout", schema = "ptcore")
public class InUserLogout {
    @Id
    @SequenceGenerator(name = "InUserLogoutIdSequence", sequenceName = "ptcore.in_user_logout_id_seq",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "InUserLogoutIdSequence")
    Long id;
    @ManyToOne
    @JoinColumn(name="in_user_id")
    InUser inUser;
    LocalDateTime created;
    String token;
}
