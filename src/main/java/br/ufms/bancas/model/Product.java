package br.ufms.bancas.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @NonNull private String name;

    @NonNull private String description;

    @NonNull private Double stockPrice;
    @NonNull private Double sellPrice;

    @NonNull private String supplier;

    @NonNull private Long quantity;

    @NonNull
//    @ManyToOne
//    @JoinColumn(name = "publisher_id", nullable = false)
//    private Publisher publisher;
    private String publisher;

    @Enumerated(EnumType.STRING)
    private Type type;

    public enum Type {
        Magazine,
        Book,
        Journal
    }
}
