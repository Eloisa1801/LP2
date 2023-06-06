package br.ifms.demo.javabeans;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Estoque {
    @ApiModelProperty(value = "Código do estoque")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEstoque;

  
    public int getIdEstoque() {
        return idEstoque;
    }

    public void setIdEstoque(int idEstoque) {
        this.idEstoque = idEstoque;
    }

    
}
