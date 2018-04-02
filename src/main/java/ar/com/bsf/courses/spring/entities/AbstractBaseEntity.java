/**
 * 
 */
package ar.com.bsf.courses.spring.entities;

/*import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
*/

/**
 * @author fromero
 *
 */
/*@MappedSuperclass
@Inheritance(strategy=javax.persistence.InheritanceType.TABLE_PER_CLASS)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})*/
public abstract class AbstractBaseEntity implements Entity {

	/* Static members */
	
	private static final long serialVersionUID = 1L;


	/* Instance members  */
	
	/* unique instance identifier */
	/*@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	*/
	protected Long id;
	
	
	/**
	 * 
	 */
	public AbstractBaseEntity() {
	
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (!(obj instanceof AbstractBaseEntity)) {
      return false;
    }
    AbstractBaseEntity other = (AbstractBaseEntity) obj;
    if (id == null) {
      if (other.id != null) {
        return false;
      }
    } else if (!id.equals(other.id)) {
      return false;
    }
    return true;
  }
	
}