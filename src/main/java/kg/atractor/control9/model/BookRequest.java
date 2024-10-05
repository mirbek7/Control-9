package kg.atractor.control9.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@Entity
@Table(name = "book_requests")
@NoArgsConstructor
@AllArgsConstructor
public class BookRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    @NotNull(message = "Книга должна быть указана")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @NotNull(message = "Пользователь должен быть указан")
    private User user;

    @NotNull(message = "Дата возврата должна быть указана")
    @Column(nullable = false)
    private LocalDate returnDate;

    @NotNull(message = "Статус возврата должен быть указан")
    @Enumerated(EnumType.STRING)
    @Column(name = "return_status", nullable = false)
    private ReturnStatus returnStatus;
}

