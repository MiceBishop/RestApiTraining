package sn.micesoft.rat.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Bookmark {
	@Id
	@GeneratedValue
	private Long id;

	@JsonIgnore
	@ManyToOne
	private Account account;

	private String uri;

	private String description;

	private Bookmark() {
	}

	public Bookmark(final Account account, final String uri, final String description) {
		this.account = account;
		this.uri = uri;
		this.description = description;
	}

	public static Bookmark from(Account account, Bookmark bookmark) {
		return new Bookmark(account, bookmark.uri, bookmark.description);
	}

	public Long getId() {
		return this.id;
	}

	public Account getAccount() {
		return this.account;
	}

	public String getUri() {
		return this.uri;
	}

	public String getDescription() {
		return this.description;
	}
}
