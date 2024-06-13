package dh.backend.clinicaodontologica.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OdontologoResponseDto {
    private Integer id;
    private int matricula;
    private String nombre;
    private String apellido;
}
