package org.simpurl.db;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "uri_children")
public class UriChildren {
	@Id
	private UUID id;

	@ManyToOne(targetEntity = UriRoot.class)
	private UriRoot rootId;

	private String uri;
	private String shortUrl;
	private String created_date;
	private String updated_date;
	private Long hitCount;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public UriRoot getRootId() {
		return rootId;
	}

	public void setRootId(UriRoot rootId) {
		this.rootId = rootId;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getShortUrl() {
		return shortUrl;
	}

	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}

	public String getCreated_date() {
		return created_date;
	}

	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}

	public String getUpdated_date() {
		return updated_date;
	}

	public void setUpdated_date(String updated_date) {
		this.updated_date = updated_date;
	}

	public Long getHitCount() {
		return hitCount;
	}

	public void setHitCount(Long hitCount) {
		this.hitCount = hitCount;
	}

}
