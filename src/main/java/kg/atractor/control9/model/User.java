package kg.atractor.control9.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "ФИО не может быть пустым")
    @Size(max = 255, message = "ФИО не может превышать 255 символов")
    @Column(nullable = false)
    private String fullName;

    @NotBlank(message = "Адрес не может быть пустым")
    @Size(max = 255, message = "Адрес не может превышать 255 символов")
    @Column(nullable = false)
    private String address;

    @NotBlank(message = "Номер паспорта не может быть пустым")
    @Pattern(regexp = "[A-Z0-9]{6,20}", message = "Номер паспорта должен быть правильного формата")
    @Column(nullable = false, unique = true)
    private String passportNumber;

    @NotBlank(message = "Пароль не может быть пустым")
    @Size(min = 6, max = 255, message = "Пароль должен быть не менее 6 символов")
    @Column(nullable = false)
    private String password;

    @NotBlank(message = "Читательский билет должен быть сгенерирован")
    @Column(name = "library_card_number", nullable = false, unique = true)
    private String libraryCardNumber;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<BookRequest> bookRequests;
}

