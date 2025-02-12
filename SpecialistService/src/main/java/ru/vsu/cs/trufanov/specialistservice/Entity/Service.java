package ru.vsu.cs.trufanov.specialistservice.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "services")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @ColumnDefault("gen_random_uuid()")
    @Column(name = "id", nullable = false)
    private UUID id;

    @NotNull
    @Column(name = "specialist_id", nullable = false)
    private UUID specialistId;

    @Column(name = "service_name", nullable = false)
    private String serviceName;

    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

}