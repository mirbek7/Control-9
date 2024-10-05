package kg.atractor.control9.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@Entity
@Table(name = "books")
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Название книги не может быть пустым")
    @Size(max = 255, message = "Название книги не может превышать 255 символов")
    @Column(nullable = false)
    private String title;

    @NotBlank(message = "Имя автора не может быть пустым")
    @Size(max = 255, message = "Имя автора не может превышать 255 символов")
    @Column(nullable = false)
    private String author;

    @Size(max = 255, message = "URL изображения не может превышать 255 символов")
    private String imagePreview;

    @NotNull(message = "Статус доступности книги должен быть указан")
    @Column(nullable = false)
    private Boolean isAvailable;

    private LocalDate returnDate;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
}

