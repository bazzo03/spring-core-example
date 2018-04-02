/**
 * 
 */
package ar.com.bsf.courses.spring.entities;

//import javax.persistence.Table;

/**
 * @author fromero
 *
 */
//@javax.persistence.Entity
//@Table(name="MIEMBRO")
public class Member extends Person {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long ssNumber;

	/**
	 * @return the ssNumber
	 */
	public Long getSSNumber() {
		return ssNumber;
	}

	/**
	 * @param ssNumber the ssNumber to set
	 */
	public void setSSNumber(Long ssNumber) {
		this.ssNumber = ssNumber;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Member [ssNumber=" + ssNumber + ", "
				+ (lastName != null ? "lastName=" + lastName + ", " : "")
				+ (firstName != null ? "firstName=" + firstName + ", " : "")
				+ (birthDate != null ? "birthDate=" + birthDate + ", " : "")
				+ (id != null ? "id=" + id : "") + "]";
	}
	
	
	 

}
