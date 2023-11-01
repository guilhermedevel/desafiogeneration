package com.guilhermedevel.desafiogeneration.domain.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "with")
public class StudentRequest {

    @Schema(name = "name", defaultValue = "Guilherme Zarzur", description = "Student's name")
    @Length(min = 4, max = 50, message = "O campo nome precisa ter entre 4 e 50 caracteres.")
    @NotBlank(message = "O campo nome é obrigatório!")
    private String name;

    @Schema(name = "age", defaultValue = "18", description = "Student's age")
    @Min(value = 0, message = "O valor mínimo para o campo idade é 1")
    @Max(value = 100, message = "O valor máximo para o campo idade é 100")
    private Integer age;

    @Schema(name = "note1", defaultValue = "7.00", description = "Student's first semester note")
    @Min(value = 0, message = "O valor mínimo para o campo nota 1 é 0.00")
    @Max(value = 10, message = "O valor máximo para o campo nota 1 é 10.00")
    private Float note1;

    @Schema(name = "note2", defaultValue = "7.00", description = "Student's second semester note")
    @Min(value = 0, message = "O valor mínimo para o campo nota 2 é 0.00")
    @Max(value = 10, message = "O valor máximo para o campo nota 2 é 10.00")
    private Float note2;

    @Schema(name = "professorName", defaultValue = "Jean Pablo", description = "Professor's name")
    @Length(min = 4, max = 50, message = "O campo nome do professor precisa ter entre 4 e 50 caracteres.")
    @NotBlank(message = "O campo nome do professor é obrigatório!")
    private String professorName;

    @Schema(name = "classId",defaultValue = "129B", description = "Identification of a classroom")
    @Length(min= 3, max = 10, message = "O campo número da sala precisa ter entre 3 e 10 caracteres.")
    private String classId;
}
