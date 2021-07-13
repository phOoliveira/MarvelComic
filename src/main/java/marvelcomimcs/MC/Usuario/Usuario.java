package marvelcomimcs.MC.Usuario;



import javax.persistence.*;
import java.time.LocalDate;

import static javax.persistence.GenerationType.SEQUENCE;


@Entity(name = "Usuario")
@Table(
        name = "usuario",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_usuario_email", columnNames = "email"),
                @UniqueConstraint(name = "uk_usuario_cpf", columnNames = "cpf")
        }
)
public class Usuario {
    @Id
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "seq_usuario"
    )
    @SequenceGenerator(
            name = "seq_usuario",
            sequenceName = "seq_usuario",
            allocationSize = 1
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;
    @Column(
            name = "nome",
            nullable = false,
            columnDefinition = "varchar(100)"
    )
    private String name;
    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "varchar(100)"
    )
    private String email;
    @Column(
            name = "cpf",
            nullable = false,
            columnDefinition = "varchar(11)"
    )
    private String cpf;
    @Column(
            name = "dtn",
            nullable = false,
            columnDefinition = "DATE"
    )
    private LocalDate dtn;

    public Usuario() {
    }

    public Usuario(Long id, String name, String email, String cpf, LocalDate dtn) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.dtn = dtn;
    }

    public Usuario(String name, String email, String cpf, LocalDate dtn) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.dtn = dtn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDtn() {
        return dtn;
    }

    public void setDtn(LocalDate dtn) {
        this.dtn = dtn;
    }



    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", cpf=" + cpf +
                ", dtn=" + dtn +
                '}';
    }
}
