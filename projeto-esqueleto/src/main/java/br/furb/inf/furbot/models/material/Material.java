package br.furb.inf.furbot.models.material;

import br.furb.inf.furbot.enuns.FileType;
import br.furb.inf.furbot.enuns.Language;
import br.furb.inf.furbot.models.ModelImpl;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Material extends ModelImpl {

    private String title;
    private Date year;
    private String authors;
    private String description;
    private String keyWord;
    private FileType fileType;
    private Language language;
    private int avaliation;
    private boolean published;

    private String link;


}
