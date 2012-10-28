package lab.converters;

import lab.domain.Person;
import lab.dto.DtoPerson;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Tatsiana
 * Date: 10/24/12
 * Time: 2:12 AM
 * To change this template use File | Settings | File Templates.
 */
public class DTOBetweenPersonsConverter {
    public Set<DtoPerson> convert(List<Person> persons) {
        Set<DtoPerson> personDtoSet = new HashSet<DtoPerson>();
        for (Person person : persons) {
            personDtoSet.add(new DtoPerson(person.getFisrtName(), person.getLastName(), person.getMiddleName(),
                    person.getBirthDate()));
        }
        return personDtoSet;
    }
}
