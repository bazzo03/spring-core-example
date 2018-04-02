/**
 * 
 */
package ar.com.bsf.courses.spring.entities;

import java.util.Date;
import java.util.Set;

/*import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;*/

/**
 * @author fromero
 *
 */
//@javax.persistence.Entity
public class Lending extends AbstractBaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	

	//@ManyToOne
	private Member member;
	
	//@OneToMany
	//@JoinTable(name="RETIRO_LIBRO",
	//	inverseJoinColumns={ @JoinColumn(name="LIBRO_ID", referencedColumnName="ID", unique=true) })
	private Set<Book> books;
	
	private Date startDate;
	
	private Date returnDate;

	/**
	 * @return the member
	 */
	public Member getMember() {
		return member;
	}

	/**
	 * @param member the member to set
	 */
	public void setMember(Member member) {
		this.member = member;
	}

	/**
	 * @return the books
	 */
	public Set<Book> getBooks() {
		return books;
	}

	/**
	 * @param books the books to set
	 */
	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	/**
	 * @return the date
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param date the date to set
	 */
	public void setStartDate(Date date) {
		this.startDate = date;
	}

	/**
	 * @return the returnDate
	 */
	public Date getReturnDate() {
		return returnDate;
	}

	/**
	 * @param returnDate the returnDate to set
	 */
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((returnDate == null) ? 0 : returnDate.hashCode());
		result = prime * result + ((books == null) ? 0 : books.hashCode());
		result = prime * result + ((member == null) ? 0 : member.hashCode());
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
		if (!(obj instanceof Lending)) {
			return false;
		}
		Lending other = (Lending) obj;
		if (startDate == null) {
			if (other.startDate != null) {
				return false;
			}
		} else if (!startDate.equals(other.startDate)) {
			return false;
		}

		if (books == null) {
			if (other.books != null) {
				return false;
			}
		} else if (!books.equals(other.books)) {
			return false;
		}
		if (member == null) {
			if (other.member != null) {
				return false;
			}
		} else if (!member.equals(other.member)) {
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Lending [" + (member != null ? "member=" + member + ", " : "")
				+ (books != null ? "books=" + books + ", " : "") + (startDate != null ? "date=" + startDate + ", " : "")
				+ (returnDate != null ? "returnDate=" + returnDate : "") + "]";
	}

}