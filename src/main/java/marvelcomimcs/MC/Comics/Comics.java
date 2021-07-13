package marvelcomimcs.MC.Comics;
import marvelcomimcs.MC.Usuario.Usuario;
import javax.persistence.*;
import java.time.DayOfWeek;


import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "Comics")
@Table(name = "comics")
public class Comics {

    @Id
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "seq_comic"
    )
    @SequenceGenerator(
            name = "seq_comic",
            sequenceName = "seq_comic",
            allocationSize = 1
    )
    private Long controle;
    @Column(
            name = "comicid",
            nullable = false,
            updatable = false,
            columnDefinition = "bigint(20)"
    )
    private Long comicid;

    @Column(
            name = "titulo",
            nullable = false,
            columnDefinition = "varchar(100)"
    )
    private String titulo;

    @Column(
            name = "preco",
            columnDefinition = "double(10,2)"
    )
    private Double preco;
    @Column(
            name = "autores",
            columnDefinition = "varchar(225)"
    )
    private String autores;

    @Column(
            name = "isbn",
            columnDefinition = "varchar(30)"
    )
    private String isbn;
    @Column(
            name = "descricao",
            columnDefinition = "varchar(4000)"
    )
    private String descricao;

//    @Column(
//            name = "usuario_id",
//            nullable = false
//    )
    @ManyToOne
    @JoinColumn(name = "id",
            updatable = false
    )
    private Usuario usuarioId;

    @Transient
    private DayOfWeek diaDesconto;

    @Transient
    private Boolean descontoAtivo;

    public Comics() {
    }

//    public Comics(Long id, Long comicid, String titulo, Double preco, String autores, String isbn, String descricao, Usuario usuarioId, LocalDate diaDesconto, Boolean descontoAtivo) {
//        this.id = id;
//        this.comicid = comicid;
//        this.titulo = titulo;
//        this.preco = preco;
//        this.autores = autores;
//        this.isbn = isbn;
//        this.descricao = descricao;
//        this.usuarioId = usuarioId;
//        this.diaDesconto = diaDesconto;
//        this.descontoAtivo = descontoAtivo;
//    }

    public Comics(Long comicid, String titulo, Double preco, String autores, String isbn, String descricao, Usuario usuarioId) {
        this.comicid = comicid;
        this.titulo = titulo;
        this.preco = preco;
        this.autores = autores;
        this.isbn = isbn;
        this.descricao = descricao;
        this.usuarioId = usuarioId;
    }

    public Comics(String titulo, Double preco, String autores, String isbn, String descricao, Usuario usuarioId) {
        this.titulo = titulo;
        this.preco = preco;
        this.autores = autores;
        this.isbn = isbn;
        this.descricao = descricao;
        this.usuarioId = usuarioId;
    }

    public Long getComicid() {
        return comicid;
    }

    public void setComicid(Long comicid) {
        this.comicid = comicid;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        //if (!autores.isEmpty()) autores = autores + ",";
        this.autores = autores;// + autores;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    public DayOfWeek getDiaDesconto() {
        return diaDesconto;
    }

    public void setDiaDesconto(DayOfWeek diaDesconto) {
        this.diaDesconto = diaDesconto;
    }

    public Boolean getDescontoAtivo() {
        return descontoAtivo;
    }

    public void setDescontoAtivo(Boolean descontoAtivo) {
        this.descontoAtivo = descontoAtivo;
    }

    @Override
    public String toString() {
        return "Comics{" +
                "comicid=" + comicid +
                ", titulo='" + titulo + '\'' +
                ", preco=" + preco +
                ", autores='" + autores + '\'' +
                    ", isbn=" + isbn +
                ", descricao='" + descricao + '\'' +
                ", usuarioId=" + usuarioId +
                '}';
    }


}
