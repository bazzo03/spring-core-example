/**
 * 
 */
package ar.com.bsf.courses.spring.entities;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author fromero
 *
 */
@XmlRootElement(name="Author", namespace="ar.com.belax" )
//@javax.persistence.Entity
public class Author extends Person {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Author [" + (id != null ? "id=" + id + ", " : "")
				+ (lastName != null ? "lastName=" + lastName + ", " : "")
				+ (firstName != null ? "firstName=" + firstName + ", " : "")
				+ (birthDate != null ? "fechaNacimento=" + birthDate : "") + "]";
	}
	
	
	
	

}