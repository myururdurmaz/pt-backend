package com.osomapps.pt.exercises;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Getter
@Setter
@Entity
@Table (name = "exercise_output", schema = "ptcore")
@DynamicInsert
public class ExerciseOutput {
    @Id
    @GenericGenerator(
        name = "ExerciseOutputIdSequence",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = {
                @Parameter(name = "sequence_name", value = "ptcore.exercise_output_id_seq"),
                @Parameter(name = "initial_value", value = "1"),
                @Parameter(name = "increment_size", value = "1")
        }
    )
    @GeneratedValue(generator = "ExerciseOutputIdSequence")
    Long id;
    LocalDateTime created;
    String name;
    @ManyToMany
    @JoinTable(
            name = "exercise_output_has_exercise",
            schema = "ptcore",
            joinColumns = { @JoinColumn(name = "exercise_output_id") },
            inverseJoinColumns = { @JoinColumn(name = "exercise_id") }
    )
    List<Exercise> exercises = new ArrayList<>(0);
}
