package ex.api.system.dto;

import java.io.Serializable;
import java.util.Date;

public class CommentDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String text;
	private Date date;
	private AuthorDTO author; // INTEGRANDO COMENTARIOS AO AUTOR DO POST
	
	public CommentDTO() {
		super();
	}

	public CommentDTO(String text, Date date, AuthorDTO authorDTO) {
		super();
		this.text = text;
		this.date = date;
		this.author = authorDTO;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public AuthorDTO getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}
	
	
	
}
