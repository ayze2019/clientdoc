package clientdoc.domainmodel.klientIn;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

/**
 * Created by fs-green on 24.12.2019.
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
public enum Geschlecht {

    WEIBLICH("weiblich"),
    MAENNLICH("männlich"),
    UNBEKANNT("unbekannt");

    private final String geschlecht;

    Geschlecht(String geschlecht) {
        this.geschlecht = geschlecht;
    }

    public String getGeschlecht() {
        return geschlecht;
    }

    public static boolean exists(String geschlechtExists) {
        return Arrays.stream(values()).anyMatch(geschlecht -> StringUtils.equals(geschlecht.geschlecht, geschlechtExists));
    }
}
