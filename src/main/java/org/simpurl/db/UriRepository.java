package org.simpurl.db;

import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UriRepository extends PagingAndSortingRepository<UriRoot, UUID> {
	public UriRoot findByMappedId(@Param("mappedId") String mappedId);
}
