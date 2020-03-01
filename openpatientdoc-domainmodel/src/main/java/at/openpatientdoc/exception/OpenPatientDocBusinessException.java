package at.openpatientdoc.exception;

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
public class OpenPatientDocBusinessException extends RuntimeException {

    private static final long serialVersionUID = 1059252170107342952L;

    public OpenPatientDocBusinessException(String message) {
        super(message);
    }

    public OpenPatientDocBusinessException(Throwable cause) {
        super(cause);
    }

    public OpenPatientDocBusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * this method is required in the frontend layer to print the right message in the
     * Messagebox dialog through getCause(). Since the repo layer as well as the
     * business layer may throw this exception, this method is needed to distinguish between
     * a nested exception ({@link OpenPatientDocDbRepoException} as the cause (exception translation)
     * or a usual {@link OpenPatientDocBusinessException}
     * @return the cause of the exception (must not be null, avoids nullpointer in the frontend)
     */
    public Throwable getTrueCause() {
        Throwable cause = super.getCause();
        return cause == null ? this : cause;
    }
}
