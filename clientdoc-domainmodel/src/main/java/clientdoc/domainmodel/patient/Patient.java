package clientdoc.domainmodel.patient;

import java.time.LocalDate;
import java.time.Period;

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
public class Patient {

    private String forename;
    private String surname;
    private Sex sex;
    private LocalDate birthdate;
    private String socialInsuranceId;
    private String socialInsuranceCarrier;
    private String address;
    private String city;
    private String phoneNumber;

    public Patient(String forename, String surname, Sex sex, LocalDate birthdate, String socialInsuranceId, String socialInsuranceCarrier, String address, String city, String phoneNumber) {
        this.forename = forename;
        this.surname = surname;
        this.sex = sex;
        this.birthdate = birthdate;
        this.socialInsuranceId = socialInsuranceId;
        this.socialInsuranceCarrier = socialInsuranceCarrier;
        this.address = address;
        this.city = city;
        this.phoneNumber = phoneNumber;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getSocialInsuranceId() {
        return socialInsuranceId;
    }

    public void setSocialInsuranceId(String socialInsuranceId) {
        this.socialInsuranceId = socialInsuranceId;
    }

    public String getSocialInsuranceCarrier() {
        return socialInsuranceCarrier;
    }

    public void setSocialInsuranceCarrier(String socialInsuranceCarrier) {
        this.socialInsuranceCarrier = socialInsuranceCarrier;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return Period.between(this.birthdate, LocalDate.now()).getYears();
    }
}
