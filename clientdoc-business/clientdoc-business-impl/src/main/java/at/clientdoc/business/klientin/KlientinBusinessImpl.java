package at.clientdoc.business.klientin;

import clientdoc.domainmodel.klientIn.Geschlecht;
import clientdoc.domainmodel.klientIn.KlientIn;
import clientdoc.exception.ClientdocBusinessException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

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
public class KlientinBusinessImpl implements KlientinBusiness {

    @Override
    public List<KlientIn> geData(String vorname, String nachname) {
        Stream<KlientIn> stream = this.generateFakeList().stream();

        if (StringUtils.isNotEmpty(vorname)) {
            stream = stream.filter(e -> StringUtils.containsIgnoreCase(e.getVorname(), vorname));
        }

        if (StringUtils.isNotEmpty(nachname)) {
            stream = stream.filter(e -> StringUtils.containsIgnoreCase(e.getNachname(), nachname));
        }

        return stream.collect(Collectors.toList());
    }

    @Override
    public void save(String vorname, String nachname, Geschlecht geschlecht) {
        throw new ClientdocBusinessException("not implemented yet!");
    }

    private List<KlientIn> generateFakeList() {
        List<KlientIn> klientinBusinessList = new ArrayList<>();

        klientinBusinessList.add(new KlientIn("Oliver", "Queen", Geschlecht.MAENNLICH));
        klientinBusinessList.add(new KlientIn("Felicity", "Smoak", Geschlecht.WEIBLICH));
        klientinBusinessList.add(new KlientIn("Barry", "Allen", Geschlecht.MAENNLICH));
        klientinBusinessList.add(new KlientIn("Kara", "Zor-El", Geschlecht.WEIBLICH));
        klientinBusinessList.add(new KlientIn("John", "Diggle", Geschlecht.MAENNLICH));
        klientinBusinessList.add(new KlientIn("Laurel", "Lance", Geschlecht.WEIBLICH));

        return klientinBusinessList;
    }
}
