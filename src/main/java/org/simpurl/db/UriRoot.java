package org.simpurl.db;

import java.math.BigInteger;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "uri_root")
public class UriRoot {
	@Id
	private UUID id;

	private String domain;
	private String protocol;
	private String mappedId;
	private String created_date;
	private String updated_date;

	@OneToMany(mappedBy = "rootId")
	private List<UriChildren> uri_children;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
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

	@Override
	public String toString() {
		return "UriRoot [id=" + id + ", domain=" + domain + ", protocol=" + protocol + ", created_date=" + created_date
				+ ", updated_date=" + updated_date + ", uri_children=" + uri_children + "]";
	}

	public String getMappedId() {
		return mappedId;
	}

	public void setMappedId(String mappedId) {
		this.mappedId = mappedId;
	}

	public List<UriChildren> getUri_children() {
		return uri_children;
	}

	public void setUri_children(List<UriChildren> uri_children) {
		this.uri_children = uri_children;
	}

}
