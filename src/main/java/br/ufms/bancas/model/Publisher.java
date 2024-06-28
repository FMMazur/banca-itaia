package br.ufms.bancas.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull private String name;

    @OneToOne
    @JoinColumn(name = "image_id", referencedColumnName = "id")
    private DbImage image;

    @OneToMany(mappedBy = "publisher")
    private List<Product> products;
}
