/**
 * 
 */
package ar.com.bsf.courses.spring.entities;

//import javax.persistence.FetchType;
//import javax.persistence.ManyToOne;

/**
 * @author fromero
 *
 */
//@javax.persistence.Entity
public class Book extends AbstractBaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer isbn;
	private String title;
	private Short year;
	private Short pages;
	//@ManyToOne(fetch = FetchType.EAGER)
	private Author author;
	/**
	 * @return the isbn
	 */
	public Integer getIsbn() {
		return isbn;
	}
	/**
	 * @param isbn the isbn to set
	 */
	public void setIsbn(Integer isbn) {
		this.isbn = isbn;
	}
	/**
	 * @return the titulo
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param titulo the titulo to set
	 */
	public void setTitle(String titulo) {
		this.title = titulo;
	}
	/**
	 * @return the anio
	 */
	public Short getYear() {
		return year;
	}
	/**
	 * @param anio the anio to set
	 */
	public void setYear(Short anio) {
		this.year = anio;
	}
	/**
	 * @return the paginas
	 */
	public Short getPages() {
		return pages;
	}
	/**
	 * @param paginas the paginas to set
	 */
	public void setPages(Short paginas) {
		this.pages = paginas;
	}
	/**
	 * @return the author
	 */
	public Author getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(Author author) {
		this.author = author;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
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
		if (!(obj instanceof Book)) {
			return false;
		}
		Book other = (Book) obj;
		if (isbn == null) {
			if (other.isbn != null) {
				return false;
			}
		} else if (!isbn.equals(other.isbn)) {
			return false;
		}
		return true;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Book [" + (isbn != null ? "isbn=" + isbn + ", " : "")
				+ (title != null ? "titulo=" + title + ", " : "") + "anio=" + year + ", paginas=" + pages + ", "
				+ (author != null ? "author=" + author.getFullName() : "") + "]";
	}
	
	

}
