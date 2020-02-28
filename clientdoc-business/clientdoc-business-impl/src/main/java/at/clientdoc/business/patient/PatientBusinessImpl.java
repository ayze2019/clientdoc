package at.clientdoc.business.patient;

import clientdoc.domainmodel.patient.Patient;
import clientdoc.domainmodel.patient.Sex;
import clientdoc.exception.ClientdocBusinessException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author fs-green
 * @date 24.12.19
 * <p>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
@Component
public class PatientBusinessImpl implements PatientBusiness {

    @Override
    public List<Patient> geData(String vorname, String nachname) {
        Stream<Patient> stream = this.generateFakeList().stream();

        if (StringUtils.isNotEmpty(vorname)) {
            stream = stream.filter(e -> StringUtils.containsIgnoreCase(e.getForename(), vorname));
        }

        if (StringUtils.isNotEmpty(nachname)) {
            stream = stream.filter(e -> StringUtils.containsIgnoreCase(e.getSurname(), nachname));
        }

        return stream.collect(Collectors.toList());
    }

    @Override
    public void save(String vorname, String nachname, Sex sex) {
        throw new ClientdocBusinessException("not implemented yet!");
    }

    private List<Patient> generateFakeList() {
        List<Patient> patientBusinessList = new ArrayList<>();

        patientBusinessList.add(new Patient("Oliver", "Queen", Sex.MALE, LocalDate.of(1990, 1, 1), "1234567890", "ÖGK", "address", "city", "+43123456790"));
        patientBusinessList.add(new Patient("Felicity", "Smoak", Sex.FEMALE, LocalDate.of(1990, 1, 1), "1234567890", "ÖGK", "address", "city", "+43123456790"));
        patientBusinessList.add(new Patient("Barry", "Allen", Sex.MALE, LocalDate.of(1990, 1, 1), "1234567890", "ÖGK", "address", "city", "+43123456790"));
        patientBusinessList.add(new Patient("Kara", "Zor-El", Sex.FEMALE, LocalDate.of(1990, 1, 1), "1234567890", "ÖGK", "address", "city", "+43123456790"));

        return patientBusinessList;
    }
}
