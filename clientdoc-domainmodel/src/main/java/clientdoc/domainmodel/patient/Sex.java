package clientdoc.domainmodel.patient;

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
public enum Sex {

    FEMALE("FEMALE"),
    MALE("MALE"),
    UNKNOWN("UNKNOWN");

    private final String sex;

    Sex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    public static boolean exists(String sexExists) {
        return Arrays.stream(values()).anyMatch(sex -> StringUtils.equals(sex.sex, sexExists));
    }
}
