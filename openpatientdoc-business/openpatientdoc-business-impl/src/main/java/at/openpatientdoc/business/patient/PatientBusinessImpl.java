package at.openpatientdoc.business.patient;

import at.openpatientdoc.domainmodel.patient.Patient;
import at.openpatientdoc.domainmodel.patient.Sex;
import at.openpatientdoc.exception.OpenPatientDocBusinessException;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private Logger logger;

    @Override
    public List<Patient> geData(String vorname, String nachname) {
        this.logger.info("getting data from database");
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
    public void save(Patient patient) {
        this.logger.info("saving patient");
        throw new OpenPatientDocBusinessException("not implemented yet!");
    }

    private List<Patient> generateFakeList() {
        List<Patient> patientBusinessList = new ArrayList<>();

        patientBusinessList.add(new Patient("Oliver", "Queen", Sex.MALE, LocalDate.of(1990, 1, 1), "1234567890", "ÖGK", "address", "city", "+43123456790", "1@2.at"));
        patientBusinessList.add(new Patient("Felicity", "Smoak", Sex.FEMALE, LocalDate.of(1990, 1, 1), "1234567890", "ÖGK", "address", "city", "+43123456790", "3@4.at"));
        patientBusinessList.add(new Patient("Barry", "Allen", Sex.MALE, LocalDate.of(1990, 1, 1), "1234567890", "ÖGK", "address", "city", "+43123456790", "5@6.at"));
        patientBusinessList.add(new Patient("Kara", "Zor-El", Sex.FEMALE, LocalDate.of(1990, 1, 1), "1234567890", "ÖGK", "address", "city", "+43123456790", "7@8.at"));

        return patientBusinessList;
    }
}
