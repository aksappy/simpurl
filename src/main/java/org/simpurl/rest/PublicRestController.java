package org.simpurl.rest;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

import org.h2.util.StringUtils;
import org.simpurl.db.UriRepository;
import org.simpurl.db.UriRoot;
import org.simpurl.utils.CustomResponse;
import org.simpurl.utils.UrlInput;
import org.simpurl.utils.UrlParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class PublicRestController {

	@Autowired
	public UriRepository repository;

	@RequestMapping("/")
	public List<UriRoot> getAll() {
		UUID randomUUID = UUID.randomUUID();
		System.out.println(randomUUID);
		return (List<UriRoot>) repository.findAll();
	}

	@RequestMapping(value = "/", method = POST, consumes = "application/json")
	public CustomResponse create(@RequestBody UrlInput root) {
		CustomResponse response = new CustomResponse();
		if (null != root && !StringUtils.isNullOrEmpty(root.getUrl())) {
			String _url = root.getUrl();
			UriRoot _root = new UriRoot();
			_root.setId(UUID.randomUUID());
			_root.setDomain(UrlParser.getHost(_url));
			_root.setProtocol(UrlParser.getProtocol(_url));
			String mappedId = UUID.randomUUID().toString().substring(0, 4);
			_root.setMappedId(mappedId);
			System.out.println(_root);
			repository.save(_root);
			response.setResponseCode(200);
			response.setResponseText("success");
			return response;
		}
		response.setResponseCode(500);
		response.setResponseText("failure");
		return response;
	}

	@RequestMapping(value = "/{mappedId}", method = GET)
	public void getMappedUrl(@PathVariable("mappedId") String uri, @Autowired HttpServletResponse response) {
		UriRoot _root = repository.findByMappedId(uri);
		String _url = _root.getProtocol() + "://" + _root.getDomain();
		try {
			response.sendRedirect(_url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
