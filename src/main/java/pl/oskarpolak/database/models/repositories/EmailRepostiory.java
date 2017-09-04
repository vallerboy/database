package pl.oskarpolak.database.models.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.oskarpolak.database.models.EmailModel;

import java.util.List;

/**
 * Created by Lenovo on 04.09.2017.
 */
@Repository
public interface EmailRepostiory extends CrudRepository<EmailModel, Integer> {
    //@Query(nativeQuery =  true, value = "SELECT * FROM costam WHERE cos= ")
    List<EmailModel> findByAuthorStartingWith(String author);
    EmailModel findFirstByAuthorStartingWithOrderByDateDesc(String author);
}
