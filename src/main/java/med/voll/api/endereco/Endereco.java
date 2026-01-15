package med.voll.api.endereco;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class Endereco {

    protected Endereco() {
        // exigido pelo Hibernate / JPA
    }

    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    // no caso de embeddable, é necessário criar constructor manualmente e não com
    // o lombok, por causa de bugs com o Hibernate7
    public Endereco(String logradouro, String bairro, String cep, String numero,
                    String complemento, String cidade, String uf) {
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cep = cep;
        this.numero = numero;
        this.complemento = complemento;
        this.cidade = cidade;
        this.uf = uf;
    }

    public Endereco(DadosEndereco dados) {
        this.logradouro = dados.logradouro();
        this.bairro = dados.bairro();
        this.numero = dados.numero();
        this.complemento = dados.complemento();
        this.cep = dados.cep();
        this.cidade = dados.cidade();
        this.uf = dados.uf();
    }
}
