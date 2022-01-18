package org.treinamento.consumer.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Mensagem {

    private String idMensagem;
    private String mensagem;
    private Date messageDate;

}
